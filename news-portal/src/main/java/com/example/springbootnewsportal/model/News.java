package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Schema
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "news")
public class News
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @OneToOne
    @ToString.Exclude
    private User author;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Comment> commentsToNews;
    @OneToOne
    private Category category;
}
