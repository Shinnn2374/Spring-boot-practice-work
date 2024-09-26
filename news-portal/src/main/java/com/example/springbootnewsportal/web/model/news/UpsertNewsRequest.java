package com.example.springbootnewsportal.web.model.news;

import com.example.springbootnewsportal.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertNewsRequest
{
    private Long id;
    private String title;
    private Instant createTime;
    private User author;
}
