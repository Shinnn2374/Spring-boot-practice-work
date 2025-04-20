package com.example.springbootnewsportal.services;

import com.example.springbootnewsportal.model.Category;

import java.util.List;

public interface CategoryService
{
    List<Category> findAll();
    Category findById(Long id);
    Category save(Category category);
    Category update(Category category);
    void deleteById(Long id);
}
