package com.yitaqi.test.mybatis;

import com.yitaqi.like.mapper.IndexMapper;
import com.yitaqi.like.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-31 8:58
 */
public class IndexMapperTest {


    private IndexMapper indexMapper;

    @Before
    public void beforeTest() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath*:application-dao.xml");
        indexMapper = classPathXmlApplicationContext.getBean(IndexMapper.class);
    }

    @Test
    public void searchTest() {

        List<User> list = indexMapper.search("河北");
        print(list);
    }

    public void print(List<User> users) {
        int count = 0;
        for (User user : users) {
            System.out.println(user.getName());
            count++;
        }
        System.out.println("total num : " + count);
    }

    @Test
    public void listAllTest() {
        print(indexMapper.listAll());
    }
}
