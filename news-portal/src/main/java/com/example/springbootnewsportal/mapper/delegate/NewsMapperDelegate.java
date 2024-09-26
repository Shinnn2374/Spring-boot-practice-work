package com.example.springbootnewsportal.mapper.delegate;

import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;

public abstract class NewsMapperDelegate
{
    public News requestToNews(UpsertNewsRequest request)
    {
        News news = new News();
        news.setAuthor(request.getAuthor());
        news.setTitle(request.getTitle());
        news.setId(request.getId());
        news.setCreateTime(request.getCreateTime());
        return news;
    }
    public News requestToNews(Long newsId, UpsertNewsRequest request)
    {
        News news = requestToNews(request);
        news.setId(newsId);
        return news;
    }
}
