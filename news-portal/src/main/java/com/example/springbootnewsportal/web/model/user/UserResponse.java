package com.example.springbootnewsportal.web.model.user;

import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.Posts;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse
{
    private Long id;
    private String username;
    private List<Comment> comments = new ArrayList<>();
    private List<Posts> posts = new ArrayList<>();
}
