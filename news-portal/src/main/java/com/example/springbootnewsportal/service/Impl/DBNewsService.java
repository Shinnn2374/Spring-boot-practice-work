package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.repository.DBNewsRepository;
import com.example.springbootnewsportal.repository.DBUserRepository;
import com.example.springbootnewsportal.service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@AllArgsConstructor
@Service
public class DBNewsService implements NewsService
{
    private final DBNewsRepository repository;

    @Override
    public List<News> findAll() {
        return repository.findAll();
    }

    @Override
    public News findById(Long newsId) {
        return repository.findById(newsId).orElseThrow(() ->
                new EntityNotFoundException(MessageFormat.format("Entity with id {0} not found", newsId)));
    }

    @Override
    public News save(News news) {
        return repository.save(news);
    }

    @Override
    public News update(News news) {
        return repository.save(news);
    }

    @Override
    public void deleteById(Long newsId) {
        repository.deleteById(newsId);
    }
}
