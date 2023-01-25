package com.webcamp5.foodhandongserver.model.request;

import lombok.Data;

import java.util.Date;

@Data
public class PostCreationRequest {
    private Long id;
    private String title;
    private String content;
    private Long member_id;
}
