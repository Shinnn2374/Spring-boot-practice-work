package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.web.model.comment.CommentListResponse;
import com.example.springbootnewsportal.web.model.comment.CommentRequest;
import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface CommentMapper
{
    Comment requestToComment(CommentRequest request);

    @Mapping(source = "commentId", target = "id")
    Comment requestToComment(Long commentId, CommentRequest request);

    CommentResponse commentToResponse(Comment comment);

    List<CommentResponse> commentListToResponseList(List<Comment> comments);

    default CommentListResponse commentListToResponse(List<Comment> comments)
    {
        CommentListResponse response = new CommentListResponse();
        response.setCommentResponses(commentListToResponseList(comments));
        return response;
    }
}
