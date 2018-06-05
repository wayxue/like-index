package com.yitaqi.like.service.impl;

import com.yitaqi.like.init.CatchInit;
import com.yitaqi.like.mapper.IndexMapper;
import com.yitaqi.like.pojo.User;
import com.yitaqi.like.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

/**
 * 描述:
 * ${DESCRIPTION}
 *
 * @author xue
 * @create 2018-05-31 9:16
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexMapper indexMapper;
    @Override
    public List<User> search(String word) {
        return indexMapper.search(word);
    }

    @Override
    public List<User> listAll() {
        return indexMapper.listAll();
    }

    @Override
    public Collection<String> search(String word, int limit) {
        Collection<String> res = CatchInit.likeSearch.search(word, limit);
        return res;
    }
}
