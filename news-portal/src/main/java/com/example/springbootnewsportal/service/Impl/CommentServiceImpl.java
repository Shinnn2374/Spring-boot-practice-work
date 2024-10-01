package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.CommentRepository;
import com.example.springbootnewsportal.repository.UserRepository;
import com.example.springbootnewsportal.service.CommentService;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService
{
    private CommentRepository repository;
    private UserService service;

    @Override
    public List<Comment> findAll() {
        return repository.findAll();
    }

    @Override
    public Comment findById(Long userId) {
        return repository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Comment with id:{0} not found", userId)));
    }

    @Override
    public Comment save(Comment comment) {
        User saveUser = service.findById(comment.getUser().getId());
        comment.setUser(saveUser);
        return repository.save(comment);
    }

    @Override
    public Comment update(Comment comment) {
        User updatedUser = service.findById(comment.getUser().getId());
        Comment existComment = findById(comment.getId());
        existComment.setUser(updatedUser);
        BeanUtils.copyNonNullProperties(comment, existComment);
        return repository.save(existComment);
    }

    @Override
    public void deleteById(Long commentId) {
        repository.deleteById(commentId);
    }

    @Override
    public void deleteByIdIn(List<Long> commentsIds) {
        repository.deleteAllById(commentsIds);
    }
}
