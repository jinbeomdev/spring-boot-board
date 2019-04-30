package com.fasoo.boardtutorial.web.controller;

import com.fasoo.boardtutorial.web.post.dto.PostRequestDto;
import com.fasoo.boardtutorial.web.post.dto.UpdatePostDto;
import com.fasoo.boardtutorial.web.post.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class WebController {

    private PostService postService;

    @GetMapping(value = {"/", "/home"})
    public String homePage() {
        return "homePage";
    }

    @GetMapping(value = {"/board"})
    public String boardPage(Model model) {
        model.addAttribute("posts", postService.findAllDesc());

        return "boardPage";
    }

    @GetMapping(value = {"/write"})
    public String writePage() {
        return "writePage";
    }

    @PostMapping("/post/write")
    public void addPost(@RequestBody PostRequestDto dto) {
        postService.addPost(dto);
    }

    @GetMapping("/post/{postId}")
    public String getPostPageById(@PathVariable(name = "postId") Long postId, Model model) {
        model.addAttribute("post", postService.getPost(postId));
        return "postPage";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/post/{postId}/update")
    public String updatePage(@PathVariable(name = "postId") Long postId, Model model) {
        model.addAttribute("post", postService.getPost(postId));
        return "updatePage";
    }

    @PutMapping("/post/{postId}/update")
    private void updatePost(@PathVariable(name = "postId") Long postId, @RequestBody UpdatePostDto dto) {
        postService.updatePost(dto, postId);
    }
}
