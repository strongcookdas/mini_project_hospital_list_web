package com.example.mini_project_crud_exercise.domian.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class ArticleResponse {

    private Long id;
    private String title;
    private String content;

}
