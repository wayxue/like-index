package com.yitaqi.like.service;

import com.yitaqi.like.pojo.User;

import java.util.Collection;
import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-31 9:14
 */
public interface IndexService {

    /**
     * 模糊查询
     * @param word
     * @return
     */
    List<User> search(String word);

    /**
     * find all
     * @return
     */
    List<User> listAll();

    /**
     * like search
     * @param word
     * @param limit
     * @return
     */
    Collection<String> search(String word, int limit);
}
