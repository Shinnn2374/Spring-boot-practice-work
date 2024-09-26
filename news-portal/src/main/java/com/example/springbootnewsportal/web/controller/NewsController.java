package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.NewsMapper;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.service.NewsService;
import com.example.springbootnewsportal.web.model.news.NewsListResponse;
import com.example.springbootnewsportal.web.model.news.NewsResponse;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController
{
    @Autowired
    private NewsService service;
    @Autowired
    private NewsMapper mapper;

    @GetMapping
    public ResponseEntity<NewsListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.newsListToNewsListResponse(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(mapper.newsToResponse(service.findById(id)));
    }

    @PostMapping
    public ResponseEntity<NewsResponse> create(@RequestBody UpsertNewsRequest request)
    {
        News newNews = service.save(mapper.requestToNews(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.newsToResponse(newNews));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsResponse> update(@PathVariable("id") Long newsId, @RequestBody UpsertNewsRequest request)
    {
        News updatedNews = service.update(mapper.requestToNews(newsId, request));
        return ResponseEntity.ok(mapper.newsToResponse(updatedNews));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long newsId)
    {
        service.deleteById(newsId);
        return ResponseEntity.noContent().build();
    }
}
