package com.example.springbootnewsportal.mapper.delegate;

import com.example.springbootnewsportal.mapper.CommentMapper;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.service.impl.DBUserService;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;

public abstract class CommentMapperDelegate implements CommentMapper
{
    private DBUserService service;

    @Override
    public Comment requestToComment(UpsertCommentRequest request) {
        Comment comment = new Comment();
        comment.setId(request.getId());
        comment.setTitle(request.getTitle());
        comment.setCreateTime(request.getCreateTime());
        comment.setAuthor(service.findById(request.getAuthor().getId()));
        return comment;
    }

    @Override
    public Comment requestToComment(Long commentId, UpsertCommentRequest request) {
        Comment comment = requestToComment(request);
        comment.setId(commentId);
        return comment;
    }
}
