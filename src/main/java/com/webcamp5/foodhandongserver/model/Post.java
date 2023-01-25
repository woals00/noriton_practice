package com.webcamp5.foodhandongserver.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "post_table")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private Date reg_date;
    private boolean isLogined;

    @ManyToOne
    @JoinColumn(name = "post_id")
    @JsonIgnore
    private User user;

    public void setUser(User user){
        this.user = user;
        user.getPosts().add(this);
    }
}
