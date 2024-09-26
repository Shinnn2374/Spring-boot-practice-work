package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController
{
    private CommentService service;
}
