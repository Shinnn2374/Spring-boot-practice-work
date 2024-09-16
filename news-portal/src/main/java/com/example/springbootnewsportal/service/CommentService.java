package com.example.springbootnewsportal.service;

import com.example.springbootnewsportal.model.Comment;

import java.util.List;

public interface CommentService
{
    List<Comment> findAll();
    Comment findById(Long commentId);
    Comment save(Comment comment);
    Comment update(Comment comment);
    void deleteById(Long commentId);
}
