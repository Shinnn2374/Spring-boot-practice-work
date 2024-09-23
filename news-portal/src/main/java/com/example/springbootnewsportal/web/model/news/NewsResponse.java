package com.example.springbootnewsportal.web.model.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse
{
    private Long id;
    private String title;
    private String content;
}
