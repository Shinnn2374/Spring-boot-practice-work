package com.example.springbootnewsportal.web.model.news;

import lombok.Data;

@Data
public class UpsertNewsRequest
{
    private Long id;
    private String title;
    private String content;
}
