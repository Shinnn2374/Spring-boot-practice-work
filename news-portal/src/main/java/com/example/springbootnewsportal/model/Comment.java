package com.example.springbootnewsportal.model;

import java.time.Instant;

public class Comment
{
    private Long id;
    private String title;
    private String content;
    private User author;
    private Instant createTime;
}
