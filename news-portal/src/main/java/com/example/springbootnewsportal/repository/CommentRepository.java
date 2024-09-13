package com.example.springbootnewsportal.repository;

import com.example.springbootnewsportal.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentRepository
{
    List<Comment> findAll();
    Optional<Comment> findById(Long commentId);
    Comment save(Comment comment);
    Comment update(Comment comment);
    void deleteById(Long commentId);
    void deleteByIdIn(List<Long> commentIds);
}
