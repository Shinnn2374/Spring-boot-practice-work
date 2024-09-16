package com.example.springbootnewsportal.service;

import com.example.springbootnewsportal.model.News;

import java.util.List;

public interface NewsService
{
    List<News> findAll();
    News findById(Long newsId);
    News save(News news);
    News update(News news);
    void deleteById(Long newsId);
}
