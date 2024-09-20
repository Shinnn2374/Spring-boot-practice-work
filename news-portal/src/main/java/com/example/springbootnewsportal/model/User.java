package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Scope
@Schema
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "user")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @OneToMany(mappedBy = "comment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<Comment> comments = new ArrayList<>();

    @OneToMany(mappedBy = "news", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @ToString.Exclude
    private List<News> createdNews = new ArrayList<>();

    public void addComment(Comment comment)
    {
        if (comments == null){ comments = new ArrayList<>();}
        comments.add(comment);
    }

    public void removeComment(Long commentId)
    {
        comments = comments.stream().filter(o -> o.getId().equals(commentId)).collect(Collectors.toList());
    }
}
