package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Schema
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "user")
public final class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<News> newsList = new ArrayList<>();

    public void addComment(Comment comment)
    {
        if (comment == null){comments = new ArrayList<>();}else {comments.add(comment);}
    }
    public void rmComment(Long commentId)
    {
        comments = comments.stream().filter(o -> o.getId().equals(commentId)).collect(Collectors.toList());
    }

    public void addNews(News news)
    {
        if (newsList == null){newsList = new ArrayList<>();}else {newsList.add(news);}
    }
    public void rmNews(Long newsId)
    {
        newsList = newsList.stream().filter(o -> o.getId().equals(newsId)).collect(Collectors.toList());
    }
}
