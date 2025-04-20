package com.example.springbootnewsportal.services.impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repositoryes.CommentRepository;
import com.example.springbootnewsportal.services.CommentService;
import com.example.springbootnewsportal.services.UserService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService
{
    @Autowired
    private CommentRepository commentRepository;
    private UserServiceImpl userServiceImpl;

    @Override
    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Comment {0} not found", id)));
    }

    @Override
    public Comment save(Comment comment) {
        User user = userServiceImpl.findById(comment.getAuthor().getId());
        comment.setAuthor(user);
        return commentRepository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        User updatedUser = userServiceImpl.findById(comment.getAuthor().getId());
        Comment existingComment = findById(comment.getId());
        existingComment.setAuthor(updatedUser);
        BeanUtils.copyNonNullProperties(comment, existingComment);
        return commentRepository.save(existingComment);
    }

    @Override
    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public void deleteByIdIn(List<Long> ids) {
        commentRepository.deleteAllById(ids);
    }
}
