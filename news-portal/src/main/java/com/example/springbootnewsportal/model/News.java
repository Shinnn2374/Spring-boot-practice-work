package com.example.springbootnewsportal.model;

import java.util.ArrayList;
import java.util.List;

public class News
{
    private Long id;
    private String title;
    private String content;
    private User author;
    private List<Comment> comments = new ArrayList<>();
    private Category category;
}
