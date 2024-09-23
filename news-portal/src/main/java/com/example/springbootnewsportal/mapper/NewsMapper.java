package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.web.model.news.NewsListResponse;
import com.example.springbootnewsportal.web.model.news.NewsResponse;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NewsMapper
{
    News requestToNews(UpsertNewsRequest request);
    @Mapping(source = "user_id", target = "id")
    News requestToNews(Long newsId, UpsertNewsRequest request);
    NewsResponse categoryToResponse(News news);

    default NewsListResponse newsListToNewsResponseList(List<News> news)
    {
        NewsListResponse response = new NewsListResponse();
        response.setNews(news.stream().map(this::categoryToResponse)
                .collect(Collectors.toList()));
        return response;
    }
}
