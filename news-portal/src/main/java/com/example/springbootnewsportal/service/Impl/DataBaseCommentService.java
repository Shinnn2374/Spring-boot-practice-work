package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
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
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment)
    {
        Comment currentComment = findById(comment.getId());
        BeanUtils.copyNonNullProperties(comment, currentComment);
        return repository.save(comment);
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
