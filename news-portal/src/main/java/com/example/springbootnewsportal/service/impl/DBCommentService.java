package com.example.springbootnewsportal.service.impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.DBCommentRepository;
import com.example.springbootnewsportal.service.CommentService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBCommentService implements CommentService
{
    private DBCommentRepository repository;
    private DBUserService service;

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Comment findById(Long commentId) {
        return repository.findById(commentId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Comment with ID: {0} not found", commentId)));
    }

    @Override
    public Comment save(Comment comment) {
        User saveUser = service.findById(comment.getId());
        comment.setAuthor(saveUser);
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        User updateUser = service.findById(comment.getAuthor().getId());
        Comment existComment = findById(comment.getId());
        existComment.setAuthor(updateUser);
        BeanUtils.copyNonNullProperties(comment, existComment);
        return repository.save(comment);
    }

    @Override
    public void deleteById(Long commentId) {
        repository.deleteById(commentId);
    }

    @Override
    public void deleteByIdIn(List<Long> commentIds) {
        repository.deleteAllById(commentIds);
    }
}
