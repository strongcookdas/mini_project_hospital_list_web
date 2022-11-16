package com.example.mini_project_crud_exercise.domian.entity;

import com.example.mini_project_crud_exercise.domian.dto.ArticleResponse;
import com.example.mini_project_crud_exercise.repository.ArticleRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    public static ArticleResponse of(Article article){
        return new ArticleResponse(article.getId(),article.getTitle(),article.getContent());
    }
}
