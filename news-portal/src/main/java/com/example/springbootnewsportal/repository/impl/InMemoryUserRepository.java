package com.example.springbootnewsportal.repository.impl;

import com.example.springbootnewsportal.exceptions.EntityNotFoundException;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.CategoryRepository;
import com.example.springbootnewsportal.repository.CommentRepository;
import com.example.springbootnewsportal.repository.NewsRepository;
import com.example.springbootnewsportal.repository.UserRepository;
import com.example.springbootnewsportal.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryUserRepository implements UserRepository
{
    private final Map<Long,User> repository = new ConcurrentHashMap<>();

    private CommentRepository commentRepository;

    private final AtomicLong currentId = new AtomicLong(1);

    @Override
    public List<User> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(repository.get(id));
    }

    @Override
    public User save(User user) {
        Long id = currentId.getAndIncrement();
        user.setId(id);
        repository.put(id,user);
        return user;
    }

    @Override
    public User update(User user) {
        Long userId = user.getId();
        User currentUser = repository.get(userId);
        if (currentUser == null) {
            throw new EntityNotFoundException(MessageFormat.format("Entity with id {0} not found",userId));
        }
        BeanUtils.copyNonNullProperties(user, currentUser);
        currentUser.setId(userId);
        repository.put(userId,currentUser);
        return currentUser;
    }

    @Override
    public void deleteById(Long userId) {
        User user = repository.get(userId);
        if (user == null) {
            throw new EntityNotFoundException(MessageFormat.format("Entity with id {0} not found",userId));
        }
        commentRepository.deleteByIdIn(user.getComments().stream().map(Comment::getId).collect(Collectors.toList()));
        repository.remove(userId);
    }

    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
