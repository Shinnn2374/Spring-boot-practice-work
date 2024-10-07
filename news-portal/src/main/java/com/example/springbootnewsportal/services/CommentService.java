package com.example.springbootnewsportal.services;

import com.example.springbootnewsportal.model.Comment;

import java.util.List;

public interface CommentService
{
    List<Comment> findAll();
    Comment findById(Long id);
    Comment save(Comment comment);
    Comment update(Comment comment);
    void deleteById(Long id);
    void deleteByIdIn(List<Long> ids);
}
