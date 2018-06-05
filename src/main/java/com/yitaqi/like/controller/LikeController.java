package com.yitaqi.like.controller;

import com.yitaqi.like.service.IndexService;
import com.yitaqi.like.service.impl.LikeSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-06-04 17:36
 */
@Controller
public class LikeController {

    @Autowired
    private IndexService indexService;

    @RequestMapping("/like")
    @ResponseBody
    public Collection<String> likeSearch(String word) {

        Collection<String> result = indexService.search(word, 20);
        return result;
    }
}
