package com.example.springbootnewsportal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
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
public class News
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @OneToOne(cascade = CascadeType.ALL)
    private User author;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();
    private Category category;
    @CreationTimestamp
    private Instant createTime;
}
