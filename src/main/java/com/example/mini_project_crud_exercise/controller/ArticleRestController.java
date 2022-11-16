package com.example.mini_project_crud_exercise.controller;

import com.example.mini_project_crud_exercise.domian.dto.ArticleResponse;
import com.example.mini_project_crud_exercise.domian.entity.Article;
import com.example.mini_project_crud_exercise.service.ArticleServicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {

    private final ArticleServicle articleServicle;

    public ArticleRestController(ArticleServicle articleServicle) {
        this.articleServicle = articleServicle;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleResponse> getArticleResponse(@PathVariable Long id){
        return ResponseEntity.ok().body(articleServicle.getArticle(id));
    }
}
