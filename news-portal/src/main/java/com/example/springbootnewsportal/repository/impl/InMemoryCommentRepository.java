package com.example.springbootnewsportal.repository.impl;

import com.example.springbootnewsportal.exceptions.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.CommentRepository;
import com.example.springbootnewsportal.repository.UserRepository;
import com.example.springbootnewsportal.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryCommentRepository implements CommentRepository
{
    private final AtomicLong currentId = new AtomicLong(1);
    private Map<Long, Comment> repository = new ConcurrentHashMap<>();

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<Comment> findById(Long commentId) {
        return Optional.ofNullable(repository.get(commentId));
    }

    @Override
    public Comment save(Comment comment) {
        Long commentId = currentId.getAndIncrement();
        Long userId = comment.getAuthor().getId();
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        comment.setAuthor(user);
        user.setId(userId);
        Instant now = Instant.now();
        repository.put(commentId, comment);
        user.addComment(comment);
        userRepository.update(user);
        return comment;
    }

    @Override
    public Comment update(Comment comment) {
        Long id = comment.getId();
        Comment currentComment = repository.get(id);
        if (currentComment == null) {
            throw new EntityNotFoundException("Order not found");
        }
        BeanUtils.copyNonNullProperties(comment,currentComment);
        currentComment.setId(id);
        repository.put(id, currentComment);
        return currentComment;
    }

    @Override
    public void deleteById(Long commentId) {
        repository.remove(commentId);
    }

    @Override
    public void deleteByIdIn(List<Long> commentIds) {
        commentIds.forEach(commentId -> {repository.remove(commentId);});
    }
}
