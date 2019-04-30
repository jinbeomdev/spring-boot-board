package com.fasoo.boardtutorial.web.post.repository;

import com.fasoo.boardtutorial.web.post.entity.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
}
