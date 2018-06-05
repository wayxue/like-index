package com.yitaqi.like.service.impl;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-06-01 10:22
 */
public class LikeSearch<T> {

    private CharColumn<T>[] columns = new CharColumn[65535];

    public void put(T t, String value) {

        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            CharColumn<T> column = columns[c];
            if (column == null) {
                column = new CharColumn<T>();
                columns[c] = column;
            }
            column.add(t, (byte) i);
        }
    }

    public boolean remove(T t) {
        boolean flag = false;
        for (CharColumn<T> column : columns) {
            if (column != null) {
                if (column.remove(t)) {
                    flag = true;
                }
            }
        }
        return flag;
    }

    public void update(T t, String value) {

        remove(t);
        put(t, value);
    }

    public Collection<T> search(String word, int limit) {

        char[] chars = word.toCharArray();
        int length = word.length();
        Context context = new Context();
        for (int i = 0; i < chars.length; i++) {
            CharColumn<T> charColumn = columns[chars[i]];
            if (charColumn == null) {
                break;
            }
            if (!context.filter(charColumn)) {
                break;
            }
            length--;
        }
        return length == 0 ? context.limit(limit) : Collections.EMPTY_SET;
    }

    public void print() {
        for (CharColumn<T> column : columns) {
            if (column != null) {
                column.print();
            }
        }
    }

    private byte[] copy(byte[] arr, byte value) {
        Arrays.sort(arr);
        if (contain(arr, value)) {
            return arr;
        }
        byte[] res = new byte[arr.length + 1];
        res[res.length - 1] = value;
        System.arraycopy(arr, 0, res, 0, arr.length);
        Arrays.sort(res);
        return res;
    }

    private boolean contain(byte[] arr, byte value) {
        int index = Arrays.binarySearch(arr, value);
        return index >= 0 ? true : false;
    }

    private class Context {
        Map<T, byte[]> result;
        boolean used = false;

        private boolean filter(CharColumn<T> charColumn) {

            if (!used) {
                result = new TreeMap<T, byte[]>(charColumn.poxIndex);
                used = true;
                return true;
            }
            boolean flag = false;
            Map<T, byte[]> newResult = new TreeMap<T, byte[]>();
            Set<Map.Entry<T, byte[]>> entries = charColumn.poxIndex.entrySet();
            for (Map.Entry<T, byte[]> entry : entries) {
                T id = entry.getKey();
                if (!result.containsKey(id)) {
                    continue;
                }
                byte[] values = entry.getValue();
                byte[] bytes = result.get(id);
                for (byte b : bytes) {
                    if (contain(values, (byte) (b + 1))) {
                        newResult.put(id, values);
                        flag = true;
                        break;
                    }
                }
            }
            result = newResult;
            return flag;
        }

        public Collection<T> limit(int limit) {

            if (result.size() <= limit) {
                return result.keySet();
            }
            Collection<T> ids = new TreeSet<T>();
            for (T t : result.keySet()) {
                ids.add(t);
                if (ids.size() >= limit) {
                    break;
                }
            }
            return ids;
        }
    }

    private class CharColumn<T> {

        ConcurrentHashMap<T, byte[]> poxIndex = new ConcurrentHashMap<T, byte[]>();

        public void add(T t, byte pox) {

            byte[] arr = poxIndex.get(t);
            if (arr == null) {
                arr = new byte[]{pox};
            } else {
                arr = copy(arr, pox);
            }
            poxIndex.put(t, arr);
        }

        public boolean remove(T id) {

            return poxIndex.remove(id) == null ? false : true;
        }

        public void print() {
            Set<Map.Entry<T, byte[]>> entries = poxIndex.entrySet();
            for (Map.Entry<T, byte[]> entry : entries) {
                byte[] bytes = entry.getValue();
                String value = "";
                for (byte b : bytes) {
                    value = value + b;
                }
                System.out.println(entry.getKey() + "---" + value);
            }
        }
    }
}
