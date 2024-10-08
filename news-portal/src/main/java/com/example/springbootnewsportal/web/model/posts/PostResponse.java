package com.example.springbootnewsportal.web.model.posts;

import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostResponse
{
    private Long id;
    private User author;
    private List<Comment> comments = new ArrayList<>();
}
