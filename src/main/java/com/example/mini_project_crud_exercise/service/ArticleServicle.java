package com.example.mini_project_crud_exercise.service;

import com.example.mini_project_crud_exercise.domian.dto.ArticleResponse;
import com.example.mini_project_crud_exercise.domian.entity.Article;
import com.example.mini_project_crud_exercise.repository.ArticleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ArticleServicle {
    private final ArticleRepository articleRepository;

    public ArticleServicle(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public ArticleResponse getArticle(Long id){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return Article.of(optionalArticle.get());
    }
}
