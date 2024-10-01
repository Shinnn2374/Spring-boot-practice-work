package com.example.springbootnewsportal.mapper.delegate;

import com.example.springbootnewsportal.mapper.NewsMapper;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class NewsMapperDelegate implements NewsMapper
{
    @Autowired
    private UserService dataBaseClientService; //

    @Override
    public News requestToNews(UpsertNewsRequest request) {
        News news = new News();
        news.setAuthor(request.getAuthor());
        news.setTitle(request.getTitle());
        news.setId(dataBaseClientService.findById(request.getAuthor().getId()).getId());
        return news;
    }

    @Override
    public News requestToNews(Long newsId, UpsertNewsRequest request) {
        News news = requestToNews(request);
        news.setId(newsId);
        return news;
    }
}
