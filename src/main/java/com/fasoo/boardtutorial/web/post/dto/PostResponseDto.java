package com.fasoo.boardtutorial.web.post.dto;

import com.fasoo.boardtutorial.web.post.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
public class PostResponseDto {

    private Long id;
    private String title;
    private String author;
    private String modifiedDate;

    public PostResponseDto(Post post) {
        this.id = post.getId();
        this.title = post.getTitle();
        this.author = post.getAuthor();
        this.modifiedDate = toStringDateTime(post.getModifiedDate());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
