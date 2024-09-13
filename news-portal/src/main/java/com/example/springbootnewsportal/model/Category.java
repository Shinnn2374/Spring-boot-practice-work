package com.example.springbootnewsportal.model;

import lombok.Data;

import java.util.List;

@Data
public class Category
{
    private Long id;
    private String categoryName;
    private List<News> newsWithThatCategory;
}
