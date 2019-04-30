package com.fasoo.boardtutorial.web.post;

import com.fasoo.boardtutorial.web.post.entity.Post;
import com.fasoo.boardtutorial.web.post.entity.PostComment;
import com.fasoo.boardtutorial.web.post.repository.PostCommentRepository;
import com.fasoo.boardtutorial.web.post.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostTest {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostCommentRepository commentRepository;

    @Test
    public void addPostAndComment() {
        //given
        Post post = Post.builder()
                .title("제목")
                .content("내용")
                .build();

        PostComment comment1 = PostComment.builder()
                .comment("댓글1")
                .build();

        PostComment comment2 = PostComment.builder()
                .comment("댓글2")
                .build();

        post.addCommnet(comment1);
        post.addCommnet(comment2);

        postRepository.save(post);

        //when
        List<Post> posts = postRepository.findAll();
        List<PostComment> comments = commentRepository.findAll();

        //then
        Post retPost = posts.get(0);
        PostComment retComment1 = comments.get(0);
        PostComment retComment2 = comments.get(1);

        assertThat(retPost.getTitle(), is("제목"));
        assertThat(retPost.getContent(), is("내용"));

        assertThat(retComment1.getComment(), is("댓글1"));
        assertThat(retComment2.getComment(), is("댓글2"));

        assertThat(retComment1.getPost().getId(), is(1L));
        assertThat(retComment2.getPost().getId(), is(1L));
    }
}
