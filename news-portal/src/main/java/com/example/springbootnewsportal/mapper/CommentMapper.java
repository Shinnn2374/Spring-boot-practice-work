package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.web.model.comment.CommentListResponse;
import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper
{
    Comment requestToOrder(UpsertCommentRequest request);

    @Mapping(source = "commentId", target = "id")
    Comment requestToOrder(Long commentId, UpsertCommentRequest request);

    CommentResponse commentToResponse(Comment comment);

    List<CommentResponse> orderListToResponseList(List<Comment> comments);

    default CommentListResponse commentListToResponse(List<Comment> comments)
    {
        CommentListResponse response = new CommentListResponse();
        response.setComments(orderListToResponseList(comments));
        return response;
    }
}
