package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Schema
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_name")
    private String userName;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<News> newsList = new ArrayList<>();

    public void addComment(Comment comment)
    {
        if (comments == null){comments = new ArrayList<>();}
        comments.add(comment);
    }
    public void rmComment(Comment comment)
    {
        comments.remove(comment);
    }
    public void createNews(News news)
    {
        if (newsList == null){newsList = new ArrayList<>();}
        newsList.add(news);
    }
    public void rmNews(News news)
    {
        newsList.remove(news);
    }
}
