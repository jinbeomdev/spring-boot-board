package com.fasoo.boardtutorial.web.post.dto;

import com.fasoo.boardtutorial.web.post.entity.Post;
import lombok.Getter;

@Getter
public class PostDetailResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostDetailResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
    }
}
