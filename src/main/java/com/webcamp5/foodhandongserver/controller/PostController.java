package com.webcamp5.foodhandongserver.controller;

import com.webcamp5.foodhandongserver.model.Post;
import com.webcamp5.foodhandongserver.model.User;
import com.webcamp5.foodhandongserver.model.request.PostCreationRequest;
import com.webcamp5.foodhandongserver.model.request.UserCreationRequest;
import com.webcamp5.foodhandongserver.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;



    @GetMapping("/post")
    public ResponseEntity readPosts() {
        return ResponseEntity.ok(postService.readPosts());
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<Post> readPost (@PathVariable Long postId) {
        return ResponseEntity.ok(postService.readPost(postId));
    }

    @PostMapping("/post")
    public ResponseEntity<Post> createPost (@RequestBody PostCreationRequest request){
        return ResponseEntity.ok(postService.createPost(request));
    }

    @DeleteMapping("/post/{postId}")
    public ResponseEntity<Void> deletePost (@PathVariable Long postId){
        postService.deletePost(postId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/user/{postId}")
    public ResponseEntity<Post> updatePost(@RequestBody PostCreationRequest request, @PathVariable Long postId){
        return ResponseEntity.ok(postService.updatePost(postId,request));
    }
}
