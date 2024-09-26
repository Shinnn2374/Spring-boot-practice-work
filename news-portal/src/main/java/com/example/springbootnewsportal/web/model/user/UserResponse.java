package com.example.springbootnewsportal.web.model.user;

import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import com.example.springbootnewsportal.web.model.news.NewsResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse
{
    private Long id;
    private String username;
    private List<CommentResponse> comments = new ArrayList<>();
    private List<NewsResponse> news = new ArrayList<>();

}
