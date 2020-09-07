package com.xdd.service;


import com.xld.pojo.Article;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tianwen
 * @since 2020-09-05
 */
public interface ArticleService {

    List findByUserId(Article article);


    Article findById(Article articleId);

    int add(Article article);
}
