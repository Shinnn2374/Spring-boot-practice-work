package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.repository.DBCategoryRepository;
import com.example.springbootnewsportal.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@AllArgsConstructor
@Service
public class DBCategoryService implements CategoryService
{
    private final DBCategoryRepository repository;

    @Override
    public List<Category> findAll() {
        return repository.findAll();
    }

    @Override
    public Category findById(Long categoryId) {
        return repository.findById(categoryId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("categoryId {0} not found", categoryId)));
    }

    @Override
    public Category save(Category category) {
        return repository.save(category);
    }

    @Override
    public Category update(Category category) {
        return repository.save(category);
    }

    @Override
    public void delete(Long categoryId) {
        repository.deleteById(categoryId);
    }
}
