package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.web.model.comment.CommentListResponse;
import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper
{
    Comment requestToComment(UpsertCommentRequest request);
    Comment requestToComment(Long commentId, UpsertCommentRequest request);
    CommentResponse commentToResponse(Comment comment);

    default CommentListResponse userListToCommentResponseList(List<Comment> comments)
    {
        CommentListResponse response = new CommentListResponse();
        response.setComments(comments.stream().map(this::commentToResponse)
                .collect(Collectors.toList()));
        return response;
    }
}
