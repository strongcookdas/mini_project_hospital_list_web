package com.example.mini_project_crud_exercise.controller;

import com.example.mini_project_crud_exercise.domian.dto.ArticleDto;
import com.example.mini_project_crud_exercise.domian.dto.ArticleRequest;
import com.example.mini_project_crud_exercise.service.ArticleServicle;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/article")
public class ArticleRestController {

    private final ArticleServicle articleServicle;

    public ArticleRestController(ArticleServicle articleServicle) {
        this.articleServicle = articleServicle;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> getArticleResponse(@PathVariable Long id){
        return ResponseEntity.ok().body(articleServicle.getArticle(id));
    }

    @PostMapping("/new")
    public ResponseEntity<ArticleDto> saveArticle(@RequestBody ArticleRequest articleRequest){
        return ResponseEntity.ok().body(articleServicle.saveArticle(articleRequest));
    }
}
