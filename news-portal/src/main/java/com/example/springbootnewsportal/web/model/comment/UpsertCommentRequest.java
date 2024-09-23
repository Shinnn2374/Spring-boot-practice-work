package com.example.springbootnewsportal.web.model.comment;

import lombok.Data;

@Data
public class UpsertCommentRequest
{
    private Long userId;
    private String content;
    private String title;
}
