package com.webcamp5.foodhandongserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "user_table")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private boolean isLogined;

    @JsonIgnore(value = false)
    @OneToMany(mappedBy = "user")
    private List<Post> posts = new ArrayList<>();

    public void setPosts(List<Post> posts){
        if(posts!= null){
            this.posts = posts;
        }
    }
}
