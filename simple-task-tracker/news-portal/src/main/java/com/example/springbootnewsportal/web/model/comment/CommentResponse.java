package com.example.springbootnewsportal.web.model.comment;

import com.example.springbootnewsportal.model.Posts;
import com.example.springbootnewsportal.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse
{
    private Long id;
    private User author;
    private Posts posts;
    private Instant createTime;
}
