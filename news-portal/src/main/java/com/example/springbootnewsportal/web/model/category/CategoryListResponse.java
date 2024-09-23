package com.example.springbootnewsportal.web.model.category;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryListResponse
{
    private List<CategoryResponse> categoryResponses = new ArrayList<>();
}
