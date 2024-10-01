package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.News;
import com.example.springbootnewsportal.web.model.news.NewsLIstResponse;
import com.example.springbootnewsportal.web.model.news.NewsResponse;
import com.example.springbootnewsportal.web.model.news.UpsertNewsRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CommentMapper.class, UserMapper.class})
public interface NewsMapper
{
    News requestToNews(UpsertNewsRequest request);
    @Mapping(source = "newsId", target = "id")
    News requestToNews(Long newsId, UpsertNewsRequest request);
    NewsResponse newsToResponse(News news);
    default NewsLIstResponse newsListToNewsResponseList(List<News> news)
    {
        NewsLIstResponse response = new NewsLIstResponse();
        response.setNews(news.stream().map(this::newsToResponse)
                .collect(Collectors.toList()));
        return response;
    }
}
