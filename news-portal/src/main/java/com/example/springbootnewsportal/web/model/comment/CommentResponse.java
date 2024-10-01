package com.example.springbootnewsportal.web.model.comment;

import com.example.springbootnewsportal.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentResponse
{
    private String title;
    private User author;
    private Long id;
}
