package com.yitaqi.test.mybatis;

import com.yitaqi.like.data.Convert;
import com.yitaqi.like.mapper.UserMapper;
import com.yitaqi.like.pojo.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-30 14:13
 */
//@RunWith(SpringJUnit4ClassRunner.class)
public class InsertTest {

    @Test
    public void test() {
        System.out.println("test");
    }

//    @Autowired
    private UserMapper userMapper;

    @Before
    public void beforeTest() {
        ClassPathXmlApplicationContext classPathXmlApplicationContext =
                new ClassPathXmlApplicationContext("classpath*:application-dao.xml");
        userMapper = classPathXmlApplicationContext.getBean(UserMapper.class);
    }

    @Test
    public void insertTest() {

        User user = new User();
        user.setId(new BigDecimal(1));
        user.setAge(12);
        user.setEmail("email");
        user.setName("lucy");
        user.setSex("1");
        int res = userMapper.addUser(user);
        Assert.assertEquals(1,res);
    }

    @Test
    public void batchInsertTest() {

        List<String> list = Convert.fileData2Array();
        for (int i = 0; i < list.size(); i++) {
            User user = new User();
            user.setSex("1");
            user.setName(list.get(i));
            user.setEmail("email");
            user.setAge(i);
            user.setId(new BigDecimal(i));
            userMapper.addUser(user);
        }
    }

}
