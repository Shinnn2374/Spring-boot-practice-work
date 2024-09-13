package com.example.springbootnewsportal.repository.impl;

import com.example.springbootnewsportal.exceptions.EntityNotFoundException;
import com.example.springbootnewsportal.model.Category;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.repository.CategoryRepository;
import com.example.springbootnewsportal.repository.NewsRepository;
import com.example.springbootnewsportal.utils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

@Repository
public class InMemoryCategoryRepository implements CategoryRepository
{
    private NewsRepository newsRepository;
    private AtomicLong currentId = new AtomicLong(1);
    private final Map<Long, Category> repository = new ConcurrentHashMap<>();

    @Autowired
    public void setNewsRepository(NewsRepository newsRepository)
    {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<Category> findAll() {
        return new ArrayList<>(repository.values());
    }

    @Override
    public Optional<Category> findById(Long categoryId) {
        return Optional.ofNullable(repository.get(categoryId));
    }

    @Override
    public Category save(Category category) {
        Long categoryId = currentId.getAndIncrement();
        category.setId(categoryId);
        repository.put(categoryId, category);
        return category;
    }

    @Override
    public Category update(Category category) {
        Long categoryId = category.getId();
        Category currentCategory = repository.get(categoryId);
        if (currentCategory == null) {
            throw new EntityNotFoundException(MessageFormat.format("Category with id {0} not found", categoryId));
        }
        BeanUtils.copyNonNullProperties(categoryId,currentCategory);
        return currentCategory;
    }

    @Override
    public void deleteById(Long id) {
        Category category = repository.get(id);
        if (category == null) {
            throw new EntityNotFoundException(MessageFormat.format("Category with id {0} not found", id));
        }
        newsRepository.deleteByIdIn(category.getNewsWithThatCategory().stream().map(News::getId).collect(Collectors.toList()));
        repository.remove(id);
    }
}
