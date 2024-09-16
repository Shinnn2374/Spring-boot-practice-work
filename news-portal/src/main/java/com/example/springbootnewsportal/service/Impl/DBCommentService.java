package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.repository.DBCommentRepository;
import com.example.springbootnewsportal.service.CommentService;
import lombok.AllArgsConstructor;
import org.hibernate.action.internal.EntityActionVetoException;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@AllArgsConstructor
@Service
public class DBCommentService implements CommentService
{
    private final DBCommentRepository repository;

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Comment findById(Long commentId) {
        return repository.findById(commentId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("comment with id {0} not found", commentId)));
    }

    @Override
    public Comment save(Comment comment) {
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
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
