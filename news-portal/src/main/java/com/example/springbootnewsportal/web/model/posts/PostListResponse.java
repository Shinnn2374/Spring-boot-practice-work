package com.example.springbootnewsportal.web.model.posts;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PostListResponse
{
    private List<PostResponse> postResponses = new ArrayList<>();
}
