package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repositories.DataBaseUserRepository;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.utils.BeanUtils;

import java.text.MessageFormat;
import java.util.List;

public class DataBaseUserService implements UserService
{
    private DataBaseUserRepository repository;

    @Override
    public List<User> findAll()
    {
        return repository.findAll();
    }

    @Override
    public User findById(Long userId)
    {
        return repository.findById(userId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("User with ID: {0} not found", userId)));
    }

    @Override
    public User save(User user)
    {
        return repository.save(user);
    }

    @Override
    public User update(User user)
    {
        User updatedUser = findById(user.getId());
        BeanUtils.copyNonNullProperties(user, updatedUser);
        return repository.save(user);
    }

    @Override
    public void delete(Long userId)
    {
        repository.deleteById(userId);
    }
}
