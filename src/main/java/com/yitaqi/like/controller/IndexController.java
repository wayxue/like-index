package com.yitaqi.like.controller;

import com.yitaqi.like.pojo.User;
import com.yitaqi.like.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-29 16:44
 */
@Controller
public class IndexController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("list")
    @ResponseBody
    public List<User> list() {
        return indexService.listAll();
    }

    @RequestMapping("/search")
    @ResponseBody
    public List<User> search(String word) {
        return indexService.search(word);
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hi";
    }
}
