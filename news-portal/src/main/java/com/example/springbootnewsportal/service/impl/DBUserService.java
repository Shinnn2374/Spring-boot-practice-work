package com.example.springbootnewsportal.service.impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.DBUserRepository;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBUserService implements UserService
{
    @Autowired
    private DBUserRepository repository;

    @Override
    public List<User> findAll()x {
        return repository.findAll();
    }

    @Override
    public User findById(Long userId) {
        return repository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("User with ID: {0} not found", userId)));
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(User user) {
        User updateUser = new User();
        BeanUtils.copyNonNullProperties(user, updateUser);
        return repository.save(updateUser);
    }

    @Override
    public void deleteById(Long userId) {
        repository.deleteById(userId);
    }
}
