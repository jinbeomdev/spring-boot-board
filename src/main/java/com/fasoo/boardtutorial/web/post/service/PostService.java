package com.fasoo.boardtutorial.web.post.service;

import com.fasoo.boardtutorial.web.post.dto.PostDetailResponseDto;
import com.fasoo.boardtutorial.web.post.dto.PostRequestDto;
import com.fasoo.boardtutorial.web.post.dto.PostResponseDto;
import com.fasoo.boardtutorial.web.post.dto.UpdatePostDto;
import com.fasoo.boardtutorial.web.post.entity.Post;
import com.fasoo.boardtutorial.web.post.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class PostService {

    private PostRepository postRepository;

    @Transactional(readOnly = true)
    public List<PostResponseDto> findAllDesc() {
        return postRepository.findAllDesc()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Long addPost(PostRequestDto dto) {
        return postRepository.save(dto.toEntiry()).getId();
    }

    @Transactional(readOnly = true)
    public PostDetailResponseDto getPost(Long postId) {
        return postRepository.findById(postId).map(PostDetailResponseDto::new).get();
    }

    @Transactional
    public Long updatePost(UpdatePostDto dto, Long postId) {
        Post post = postRepository.findById(postId).get();
        post.setTitle(dto.getTitle());
        post.setContent(dto.getContent());
        return postRepository.save(post).getId();
    }
}