package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.mapper.delegate.NewsMapperDelegate;
import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.web.model.news.NewsListResponse;
import com.example.springbootnewsportal.web.model.news.NewsResponse;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@DecoratedWith(NewsMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsMapper
{
    News requestToNews(UpsertNewsRequest request);

    @Mapping(source = "newsId", target = "id")
    News requestToNews(Long newsId, UpsertNewsRequest request);

    NewsResponse newsToResponse(News news);

    default NewsListResponse newsListToNewsListResponse(List<News> newsList)
    {
        NewsListResponse response = new NewsListResponse();
        response.setNews(newsList.stream().map(this::newsToResponse)
                .collect(Collectors.toList()));
        return response;
    }
}