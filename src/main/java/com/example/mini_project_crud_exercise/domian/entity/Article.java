package com.example.mini_project_crud_exercise.domian.entity;

import com.example.mini_project_crud_exercise.domian.dto.ArticleDto;
import com.example.mini_project_crud_exercise.domian.dto.ArticleRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "board")
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public static ArticleDto of(Article article){
        return new ArticleDto(article.getId(),article.getTitle(),article.getContent());
    }

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
