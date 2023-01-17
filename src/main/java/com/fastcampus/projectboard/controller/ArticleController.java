package com.fastcampus.projectboard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/articles")
@Controller
public class ArticleController {

    @GetMapping
    public String articles(ModelMap map) {
        map.addAttribute("articles", List.of());

        return "articles/index";
    }

    @GetMapping("/{id}")
    public String articlesOne(@PathVariable Long id, ModelMap map) {
        map.addAttribute("article", "article");  // TODO : 실제 구현 필요
        map.addAttribute("articleComments", List.of());

        return "articles/detail";
    }


}
