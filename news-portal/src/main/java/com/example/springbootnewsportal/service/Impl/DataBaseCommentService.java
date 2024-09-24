package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repositories.DataBaseCommentRepository;
import com.example.springbootnewsportal.service.CommentService;
import com.example.springbootnewsportal.utils.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class DataBaseCommentService implements CommentService
{
    private DataBaseCommentRepository repository;
    private DataBaseUserService service;

    @Override
    public List<Comment> findAll()
    {
        return repository.findAll();
    }

    @Override
    public Comment findById(Long commentId)
    {
        return repository.findById(commentId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Comment with ID: {0} not found", commentId)));
    }

    @Override
    public Comment save(Comment comment)
    {
        User newUser= service.findById(comment.getUser().getId());
        comment.setUser(newUser);
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment)
    {
        User updatedUser = service.findById(comment.getUser().getId());
        Comment existComment = findById(comment.getId());
        existComment.setUser(updatedUser);
        BeanUtils.copyNonNullProperties(comment, existComment);
        return repository.save(existComment);
    }

    @Override
    public void deleteById(Long commentId)
    {
        repository.deleteById(commentId);
    }

    @Override
    public void deleteByIdInd(List<Long> ids)
    {
        repository.deleteAllById(ids);
    }
}
