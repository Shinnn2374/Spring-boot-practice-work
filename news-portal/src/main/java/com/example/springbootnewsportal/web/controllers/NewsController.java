package com.example.springbootnewsportal.web.controllers;

import com.example.springbootnewsportal.mapper.NewsMapper;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.service.NewsService;
import com.example.springbootnewsportal.web.model.news.NewsListResponse;
import com.example.springbootnewsportal.web.model.news.NewsResponse;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController
{
    private final NewsService newsWithDataBaseService;
    private final NewsMapper mapper;

    @GetMapping
    public ResponseEntity<NewsListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.newsListToNewsResponseList(newsWithDataBaseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> findById(@PathVariable("id") Long newsId)
    {
        return ResponseEntity.ok(mapper.newsToResponse(newsWithDataBaseService.findById(newsId)));
    }

    @PostMapping
    public ResponseEntity<NewsResponse> create(@RequestBody UpsertNewsRequest request)
    {
        News newNews = newsWithDataBaseService.save(mapper.requestToNews(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.newsToResponse(newNews));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsResponse> update(@PathVariable("id") Long newsId, @RequestBody UpsertNewsRequest request)
    {
        News updatedNews = newsWithDataBaseService.update(mapper.requestToNews(newsId, request));
        return ResponseEntity.ok(mapper.newsToResponse(updatedNews));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long newsId)
    {
        newsWithDataBaseService.delete(newsId);
        return ResponseEntity.noContent().build();
    }
}
