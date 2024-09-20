package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.News;
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
        return repository.save(news);
    }

    @Override
    public News update(News news)
    {
        News currentNews = findById(news.getId());
        BeanUtils.copyNonNullProperties(news, currentNews);
        return repository.save(news);
    }

    @Override
    public void delete(Long newsId)
    {
        repository.deleteById(newsId);
    }
}
