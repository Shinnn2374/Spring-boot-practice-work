package com.example.springbootnewsportal.web.model.comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentListResponse
{
    private List<CommentResponse> commentResponses = new ArrayList<>();
}
