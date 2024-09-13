package com.example.springbootnewsportal.repository.impl;

import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.repository.CommentRepository;
import com.example.springbootnewsportal.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryNewsRepository
{
    private CommentRepository commentRepository;
    private NewsRepository newsRepository;
    private final Map<Long, News> newsMap = new ConcurrentHashMap<>();

    @Autowired
    public void setNewsRepository(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }
    @Autowired
    public void setCommentRepository(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
}
