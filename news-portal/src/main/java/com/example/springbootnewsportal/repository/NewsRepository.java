package com.example.springbootnewsportal.repository;

import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepository
{
    List<News> findAll();
    Optional<News> findById(Long newsId);
    News news(News news);
    News update(News news);
    void deleteById(Long newsId);
    void deleteByIdIn(List<Long> newsIds);
}
