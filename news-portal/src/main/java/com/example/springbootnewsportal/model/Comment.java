package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@Schema
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "comments")
public class Comment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
    @ManyToOne
    @ToString.Exclude
    private News commentToNews;
    private String title;
    private String content;
}
