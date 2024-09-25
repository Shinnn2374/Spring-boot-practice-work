package com.example.springbootnewsportal.service.impl;

import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.DBUserRepository;
import com.example.springbootnewsportal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DBUserService implements UserService
{
    private DBUserRepository repository;

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(Long userId) {
        return repository.findById(userId).orElse(null);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long userId) {

    }
}
