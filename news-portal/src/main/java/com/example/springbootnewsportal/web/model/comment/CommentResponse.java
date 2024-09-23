package com.example.springbootnewsportal.web.model.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse
{
    private Long userId;
    private String content;
    private String title;
}
