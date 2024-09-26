package com.example.springbootnewsportal.mapper.delegate;

import com.example.springbootnewsportal.mapper.NewsMapper;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.service.impl.DBNewsService;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;

public abstract class NewsMapperDelegate implements NewsMapper
{
    private DBNewsService service;

    public News requestToNews(UpsertNewsRequest request)
    {
        News news = new News();
        news.setTitle(request.getTitle());
        news.setId(request.getId());
        news.setCreateTime(request.getCreateTime());
        news.setAuthor(service.findById(request.getAuthor().getId()).getAuthor());
        return news;
    }
    public News requestToNews(Long newsId, UpsertNewsRequest request)
    {
        News news = requestToNews(request);
        news.setId(newsId);
        return news;
    }
}
