package com.example.springbootnewsportal.model;

import ch.qos.logback.core.net.server.Client;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class News
{
    private Long id;
    private Client author;
    private String title;
    private String content;
    private Instant publishTime;
    private Category category;
    private List<Comment> comments;
}
