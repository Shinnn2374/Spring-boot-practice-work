package com.example.springbootnewsportal.mapper.delegate;

import com.example.springbootnewsportal.mapper.CommentMapper;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class CommentMapperDelegate implements CommentMapper
{
    @Autowired
    private UserService dataBaseClientService; //

    @Override
    public Comment requestToComment(UpsertCommentRequest request) {
        Comment comment = new Comment();
        comment.setUser(request.getAuthor());
        comment.setTitle(request.getTitle());
        comment.setId(dataBaseClientService.findById(request.getAuthor().getId()).getId());
        return comment;
    }

    @Override
    public Comment requestToComment(Long commentId, UpsertCommentRequest request) {
        Comment comment = requestToComment(request);
        comment.setId(commentId);
        return comment;
    }
}
