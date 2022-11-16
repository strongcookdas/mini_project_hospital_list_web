package com.example.mini_project_crud_exercise.service;

import com.example.mini_project_crud_exercise.domian.dto.ArticleDto;
import com.example.mini_project_crud_exercise.domian.dto.ArticleRequest;
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

    public ArticleDto getArticle(Long id){
        Optional<Article> optionalArticle = articleRepository.findById(id);
        return Article.of(optionalArticle.get());
    }

    public ArticleDto saveArticle(ArticleRequest articleRequest){
        Article article = articleRequest.toEntity();
        articleRepository.save(article);
        return this.getArticle(article.getId());
    }
}
