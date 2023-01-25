package com.webcamp5.foodhandongserver.model.request;

import com.webcamp5.foodhandongserver.model.Post;
import lombok.Data;

import java.util.List;

@Data
public class UserCreationRequest {
    private Long id;
    private String name;
    private List<Post> posts;
}
