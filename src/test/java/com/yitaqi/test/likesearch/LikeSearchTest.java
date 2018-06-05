package com.yitaqi.test.likesearch;

import com.yitaqi.like.service.impl.LikeSearch;
import org.junit.Test;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-06-01 15:18
 */
public class LikeSearchTest {

    @Test
    public void testAdd() {
        LikeSearch<String> likeSearch = new LikeSearch<String>();
        likeSearch.put("河北省", "河北省");

        likeSearch.print();
//        System.out.println("-----------------");
//        likeSearch.update("此情可待成追忆", "此");
//        likeSearch.print();
//        System.out.println("-----------------");
//        likeSearch.put("此情可待成追忆", "忆");
//        likeSearch.print();
//        System.out.println("-----------------");
    }
}
