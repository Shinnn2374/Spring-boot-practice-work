package com.example.springbootnewsportal.service.Impl;

import com.example.springbootnewsportal.exception.EntityNotFoundException;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.repository.NewsRepository;
import com.example.springbootnewsportal.service.NewsService;
import com.example.springbootnewsportal.utils.BeanUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService
{
    private NewsRepository repository;

    @Override
    public List<News> findAll() {
        return repository.findAll();
    }

    @Override
    public News findById(Long newsId) {
        return repository.findById(newsId).orElseThrow(() ->
        new EntityNotFoundException(MessageFormat.format("News with id {0} not found", newsId)));
    }

    @Override
    public News save(News news) {
        return repository.save(news);
    }

    @Override
    public News update(News news) {
        News updatedNews = findById(news.getId());
        BeanUtils.copyNonNullProperties(news, updatedNews);
        return repository.save(updatedNews);
    }

    @Override
    public void deleteById(Long newsId) {
        repository.deleteById(newsId);
    }
}
