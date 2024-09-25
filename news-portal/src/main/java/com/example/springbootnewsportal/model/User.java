package com.example.springbootnewsportal.model;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private String userName;
    private List<Comment> comments = new ArrayList<>();
    private List<News> newsList = new ArrayList<>();
}
