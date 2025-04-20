package com.example.springbootnewsportal.services;

import com.example.springbootnewsportal.model.Posts;

import java.util.List;

public interface PostsService
{
    List<Posts> findAll();
    Posts findById(Long id);
    Posts save(Posts posts);
    Posts update(Posts posts);
    void deleteById(Long id);
}
