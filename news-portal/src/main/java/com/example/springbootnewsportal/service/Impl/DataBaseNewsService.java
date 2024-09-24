package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repositories.DataBaseNewsRepository;
import com.example.springbootnewsportal.service.NewsService;
import com.example.springbootnewsportal.utils.BeanUtils;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
public class DataBaseNewsService implements NewsService
{
    private DataBaseNewsRepository repository;
    private DataBaseUserService service;

    @Override
    public List<News> findAll()
    {
        return repository.findAll();
    }

    @Override
    public News findById(Long newsId)
    {
        return repository.findById(newsId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("News with ID: {0} not found", newsId)));
    }

    @Override
    public News save(News news)
    {
        User newUser = service.findById(news.getAuthor().getId());
        news.setAuthor(newUser);
        return repository.save(news);
    }

    @Override
    public News update(News news)
    {
       User updatedUser = service.findById(news.getAuthor().getId());
       News existNews = findById(news.getId());
       existNews.setAuthor(updatedUser);
       BeanUtils.copyNonNullProperties(news, existNews);
       return repository.save(existNews);
    }

    @Override
    public void delete(Long newsId)
    {
        repository.deleteById(newsId);
    }
}
