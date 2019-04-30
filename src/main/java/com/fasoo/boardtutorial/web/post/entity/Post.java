package com.fasoo.boardtutorial.web.post.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  All persistent classes must have a default constructor (which can be non-public)
 *  so that Hibernate can instantiate them using Constructor.newInstance().
 *  It is recommended that you have a default constructor with at least package visibility for runtime proxy generation in Hibernate.
 */

@Entity
@NoArgsConstructor
@Setter
@Getter
public class Post extends Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column(length = 500)
    private String content;

    /**
     * CascadeType.ALL vs orphanRemoval = true 차이
     * CascadeType.All 은 DB 에서 parent 가 삭제되면 children 이 모두 삭제되는 방식 (cascade)
     * orphanRemoval 은 parent 가 null 이 되면 children 들이 삭제되는 방식
     */
    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<PostComment> comments = new ArrayList<>();

    public void addCommnet(PostComment comment) {
        comments.add(comment);
        comment.setPost(this);
    }

    public void removeComment(PostComment comment) {
        comments.remove(comment);
        comment.setComment(null);
    }

    @Builder
    public Post(String title, String author, String content) {
        this.title = title;
        this.author = author;
        this.content = content;
    }
}
