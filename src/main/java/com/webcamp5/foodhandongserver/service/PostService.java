package com.webcamp5.foodhandongserver.service;


import com.webcamp5.foodhandongserver.model.Post;
import com.webcamp5.foodhandongserver.model.User;
import com.webcamp5.foodhandongserver.model.request.PostCreationRequest;
import com.webcamp5.foodhandongserver.model.request.UserCreationRequest;
import com.webcamp5.foodhandongserver.repository.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final UserService userService;

    public Post readPost(Long postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isPresent()) {
            return post.get();
        }

        throw new EntityNotFoundException(
                "Cant find any post under given ID");
    }

    public List<Post> readPosts() {
        return postRepository.findAll();
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }

    public Post createPost(PostCreationRequest request) {
        Post post = new Post();
        BeanUtils.copyProperties(request, post);
        return postRepository.save(post);
    }

    public Post updatePost(Long id, PostCreationRequest request) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (!optionalPost.isPresent()) {
            throw new EntityNotFoundException("User not present in the database.");
        }
        Post post = optionalPost.get();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        return postRepository.save(post);
    }

}
