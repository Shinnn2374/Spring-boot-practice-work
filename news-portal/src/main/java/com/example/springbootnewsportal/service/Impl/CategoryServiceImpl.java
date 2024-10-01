package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.repository.CategoryRepository;
import com.example.springbootnewsportal.service.CategoryService;
import com.example.springbootnewsportal.utils.BeanUtils;

import java.text.MessageFormat;
import java.util.List;

public class CategoryServiceImpl implements CategoryService
{
    private CategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long categoryId) {
        return repository.findById(categoryId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Category with id: {0} not found ", categoryId)));
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        Category updatedCategory = findById(category.getId());
        BeanUtils.copyNonNullProperties(category, updatedCategory);
        return repository.save(updatedCategory);
    }

    @Override
    public void deleteById(Long categoryId) {
        repository.deleteById(categoryId);
    }
}
