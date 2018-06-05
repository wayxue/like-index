package com.yitaqi.like.mapper;

import com.yitaqi.like.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-31 8:37
 */
public interface IndexMapper {

    /**
     * find name by word
     * @param word
     * @return
     */
    List<User> search(String word);

    /**
     * query all
     * @return
     */
    List<User> listAll();
}
