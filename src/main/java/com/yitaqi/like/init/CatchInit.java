package com.yitaqi.like.init;

import com.yitaqi.like.pojo.User;
import com.yitaqi.like.service.IndexService;
import com.yitaqi.like.service.impl.LikeSearch;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-06-01 10:21
 */
public class CatchInit implements InitializingBean {

    @Autowired
    private IndexService indexService;

    public static LikeSearch<String> likeSearch = new LikeSearch<String>();

    @Override
    public void afterPropertiesSet() throws Exception {
        List<User> users = indexService.listAll();
        for (User user : users) {
            likeSearch.put(user.getName(), user.getName());
        }
    }
}
