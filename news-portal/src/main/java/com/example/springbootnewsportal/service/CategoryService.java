package com.example.springbootnewsportal.service;

import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.model.News;

import java.util.List;

public interface CategoryService
{
    List<Category> findAll();
    Category findById(Long categoryId);
    Category save(Category category);
    Category update(Category category);
    void deleteById(Long categoryId);
}
