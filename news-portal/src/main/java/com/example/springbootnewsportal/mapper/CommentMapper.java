package com.example.springbootnewsportal.mapper;

import com.example.springbootnewsportal.mapper.delegate.CommentMapperDelegate;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.web.model.comment.CommentListResponse;
import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@DecoratedWith(CommentMapperDelegate.class)
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CommentMapper
{
    Comment requestToComment(UpsertCommentRequest request);

    @Mapping(source = "commentId", target = "id")
    Comment requestToComment(Long commentId, UpsertCommentRequest request);

    CommentResponse commentToResponse(Comment comment);

    List<CommentResponse> commentListToResponseList(List<Comment> comments);

    default CommentListResponse commentListToResponse(List<Comment> comments)
    {
        CommentListResponse response = new CommentListResponse();
        response.setComments(commentListToResponseList(comments));
        return response;
    }
}
