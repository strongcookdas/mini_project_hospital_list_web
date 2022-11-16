package com.example.mini_project_crud_exercise.domian.dto;

import com.example.mini_project_crud_exercise.domian.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class ArticleRequest {

    private String title;
    private String content;

    public Article toEntity(){
        return new Article(title,content);
    }

}
