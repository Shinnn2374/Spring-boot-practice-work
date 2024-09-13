package com.example.springbootnewsportal.repository;

import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.model.Comment;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository
{
    List<Category> findAll();
    Optional<Category> findById(Long categoryId);
    Category save(Category category);
    Category update(Category category);
    void deleteById(Long categoryId);
}
