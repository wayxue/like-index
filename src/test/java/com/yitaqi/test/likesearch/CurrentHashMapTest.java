package com.yitaqi.test.likesearch;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-06-01 11:07
 */
public class CurrentHashMapTest {

    @Test
    public void testNullKey() {

        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
        String what = map.get("what");
        System.out.println(what);
    }
}
