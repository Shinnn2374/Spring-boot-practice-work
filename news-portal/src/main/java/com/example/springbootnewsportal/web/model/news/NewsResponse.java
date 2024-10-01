package com.example.springbootnewsportal.web.model.news;

import com.example.springbootnewsportal.model.Comment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsResponse
{
    private Long id;
    private String title;
    private List<Comment> comments = new ArrayList<>();
}
