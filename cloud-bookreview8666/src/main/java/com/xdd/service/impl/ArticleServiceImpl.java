package com.xdd.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xdd.dao.ArticleMapper;
import com.xdd.service.ArticleService;
import com.xld.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author tianwen
 * @since 2020-09-05
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List findByUserId(Article article) {
        QueryWrapper<Article> wrapper = new QueryWrapper<>();
        wrapper.setEntity(article);
        return articleMapper.selectList(wrapper);
    }

    @Override
    public Article findById(Article articleId) {
        return articleMapper.selectById(articleId);
    }

    @Override
    public int add(Article article) {
        return articleMapper.insert(article);
    }
}
