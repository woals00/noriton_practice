package com.webcamp5.foodhandongserver.repository;

import com.webcamp5.foodhandongserver.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
}
