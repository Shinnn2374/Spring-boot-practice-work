package com.example.springbootnewsportal.service.impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.DBNewsRepository;
import com.example.springbootnewsportal.service.NewsService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DBNewsService implements NewsService
{
    private DBNewsRepository repository;
    private DBUserService service;

    @Override
    public List<News> findAll() {
        return repository.findAll();
    }

    @Override
    public News findById(Long newsId) {
        return repository.findById(newsId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("News with ID: {0} not found", newsId)));
    }

    @Override
    public News save(News news) {
        User saveUser = service.findById(news.getAuthor().getId());
        news.setAuthor(saveUser);
        return repository.save(news);
    }

    @Override
    public News update(News news) {
        User updatedUser = service.findById(news.getAuthor().getId());
        News existNews = findById(news.getId());
        existNews.setAuthor(updatedUser);
        BeanUtils.copyNonNullProperties(news, existNews);
        return repository.save(existNews);
    }

    @Override
    public void deleteById(Long newsId) {
        repository.deleteById(newsId);
    }

    @Override
    public void deleteByIdIn(List<Long> newsIds) {
        repository.deleteAllById(newsIds);
    }
}
