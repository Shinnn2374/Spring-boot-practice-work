package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.context.annotation.Scope;

import java.util.List;

@Getter
@Setter
@Scope
@Schema
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity(name = "news")
public class News
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @ManyToOne
    private User author;
    @ManyToOne
    private Category category;
    @ManyToMany
    private List<Comment> comments;

}
