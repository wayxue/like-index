package com.yitaqi.like.data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-30 17:17
 */
public class Convert {

    public static List<String> fileData2Array() {
        String filePath = "D:\\job\\workspace\\idea_wkspace\\like-index\\src\\main\\java\\com\\yitaqi\\like\\data\\city.txt";
        List<String> res = new ArrayList<String>(1550);
        FileInputStream fileInputStream = null;
        BufferedReader reader = null;
        try {
            fileInputStream = new FileInputStream(new File(filePath));
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                res.add(tmp);
            }
            reader.close();
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }
}
