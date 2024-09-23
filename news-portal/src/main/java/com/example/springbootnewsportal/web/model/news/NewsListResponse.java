package com.example.springbootnewsportal.web.model.news;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class NewsListResponse
{
    private List<NewsResponse> news = new ArrayList<>();
}
