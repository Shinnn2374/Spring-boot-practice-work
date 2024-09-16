package com.example.springbootnewsportal.service;

import com.example.springbootnewsportal.model.User;

import java.util.List;

public interface UserService
{
    List<User> findAll();
    User findById(Long userId);
    User save(User user);
    User update(User user);
    void deleteById(Long userId);
}
