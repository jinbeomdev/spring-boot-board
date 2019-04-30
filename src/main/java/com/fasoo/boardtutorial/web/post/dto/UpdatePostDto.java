package com.fasoo.boardtutorial.web.post.dto;

import lombok.Getter;

@Getter
public class UpdatePostDto {

    private String title;
    private String content;

    public UpdatePostDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
