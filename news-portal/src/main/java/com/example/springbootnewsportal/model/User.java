package com.example.springbootnewsportal.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User
{
    private Long id;
    private String username;
    private List<Comment> comments = new ArrayList<>();

    public void addComment(Comment comment)
    {
        comments.add(comment);
    }

    public void rmComment(Long commentId)
    {
        comments.remove(commentId);
    }
}
