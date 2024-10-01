package com.example.springbootnewsportal.web.model.news;

import com.example.springbootnewsportal.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpsertNewsRequest
{
    private Long id;
    private User author;
    private String title;
}
