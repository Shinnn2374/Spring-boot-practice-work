package com.example.springbootnewsportal.web.model.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse
{
    private Long id;
    private String title;
    private Instant createTime;
}
