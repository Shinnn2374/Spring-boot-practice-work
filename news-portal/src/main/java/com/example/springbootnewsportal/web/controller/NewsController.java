package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController
{
    private NewsService service;
}
