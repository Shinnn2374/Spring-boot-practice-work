package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.repositories.DataBaseCategoryRepository;
import com.example.springbootnewsportal.service.CategoryService;
import com.example.springbootnewsportal.utils.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class DataBaseCategoryService implements CategoryService
{
    private DataBaseCategoryRepository repository;

    @Override
    public List<Category> findAll()
    {
        return repository.findAll();
    }

    @Override
    public Category findById(Long categoryId)
    {
        return repository.findById(categoryId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Category with ID: {0} not found", categoryId)));
    }

    @Override
    public Category save(Category category)
    {
        return repository.save(category);
    }

    @Override
    public Category update(Category category)
    {
        Category currentcategory = findById(category.getId());
        BeanUtils.copyNonNullProperties(category, currentcategory);
        return repository.save(category);
    }

    @Override
    public void delete(Long categoryId)
    {
        repository.deleteById(categoryId);
    }
}
