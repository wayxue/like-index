package com.yitaqi.like.mapper;

import com.yitaqi.like.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-30 14:16
 */
//@Mapper
public interface UserMapper {

    /**
     * insert
     * @param user
     * @return
     */
    @Insert("insert into t_user (id, name, age, sex, email) " +
            "values (#{id}, #{name}, #{age}, #{sex}, #{email})")
    int addUser(User user);
}
