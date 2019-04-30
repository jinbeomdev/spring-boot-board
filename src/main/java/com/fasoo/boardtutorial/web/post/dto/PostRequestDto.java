package com.fasoo.boardtutorial.web.post.dto;

import com.fasoo.boardtutorial.web.post.entity.Post;
import lombok.Getter;

@Getter
public class PostRequestDto {

    private String author;
    private String title;
    private String content;

    PostRequestDto(String userId, String title, String content) {
        this.author = userId;
        this.title = title;
        this.content = content;
    }

    public Post toEntiry() {
        return Post.builder()
                .author(author)
                .title(title)
                .content(content)
                .build();
    }
}
