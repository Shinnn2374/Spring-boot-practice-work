package com.example.springbootnewsportal.model;

import lombok.Data;

import java.time.Instant;

@Data
public class Comment
{
    private Long id;
    private String content;
    private Instant createTime;
    private User author;
}
