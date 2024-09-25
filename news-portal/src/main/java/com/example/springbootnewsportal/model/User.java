package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
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
@Entity(name = "clients")
public class User
{
    private Long id;
    private String userName;
    private List<Comment> comments = new ArrayList<>();
    private List<News> newsList = new ArrayList<>();
}
