package com.xdd.controller;


import com.xdd.service.ArticleService;
import com.xld.pojo.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tianwen
 * @since 2020-09-05
 */
@RestController
@RequestMapping("article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("findAll")
    public Map findAll(Article userId) {

        HashMap<String, Object> map = new HashMap<>();

        List<Article> Articles = articleService.findByUserId(userId);

        map.put("Articles", Articles);
        return map;
    }

    @RequestMapping("findById")
    public Map findById(Article articleId) {
        HashMap<String, Object> map = new HashMap<>();

        Article article = articleService.findById(articleId);

        map.put("article", article);
        return map;

    }

    @RequestMapping("add")
    public Map add(Article article) {
        HashMap<String, Object> map = new HashMap<>();
        System.out.println(article);

        if (null == article) {
            map.put("info", "error");
            return map;
        }
        if (article.getUserId().equals(null)) {
            map.put("info", "发布人不能为空");
            return map;
        }
        if (article.getArticleHead().equals(null)) {
            map.put("info", "标题不能为空");
            return map;
        }
        if (article.getArticleContent().equals(null)) {
            map.put("info", "内容不能为空");
        }
        article.setArticleTime(new Date());
        System.out.println(article.getArticleTime());
        int i = articleService.add(article);
        if (i < 0) {
            map.put("info", "发布失败!");
        }
        map.put("info", "发布成功!");
        return map;
    }
}
