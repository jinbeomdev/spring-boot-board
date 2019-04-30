package com.fasoo.boardtutorial.web.post.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(!(obj instanceof PostComment)) return false;

        return id != null && id.equals(((PostComment) obj).getId());
    }

    @Builder
    public PostComment(String comment) {
        this.comment = comment;
    }
}
