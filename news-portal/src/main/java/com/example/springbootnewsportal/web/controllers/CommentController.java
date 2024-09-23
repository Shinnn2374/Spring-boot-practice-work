package com.example.springbootnewsportal.web.controllers;

import com.example.springbootnewsportal.mapper.CommentMapper;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.service.CommentService;
import com.example.springbootnewsportal.web.model.comment.CommentListResponse;
import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;
import com.example.springbootnewsportal.web.model.user.UpsertUserRequest;
import com.example.springbootnewsportal.web.model.user.UserListResponse;
import com.example.springbootnewsportal.web.model.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController
{
    private final CommentService commentWithDataBaseService;
    private final CommentMapper mapper;

    @GetMapping
    public ResponseEntity<CommentListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.userListToCommentResponseList(commentWithDataBaseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable("id") Long commentId)
    {
        return ResponseEntity.ok(mapper.commentToResponse(commentWithDataBaseService.findById(commentId)));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody UpsertCommentRequest request)
    {
        Comment newComment = commentWithDataBaseService.save(mapper.requestToComment(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.commentToResponse(newComment));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable("id") Long commentId, @RequestBody UpsertCommentRequest request)
    {
        Comment updatedComment = commentWithDataBaseService.update(mapper.requestToComment(commentId, request));
        return ResponseEntity.ok(mapper.commentToResponse(updatedComment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long userId)
    {
        commentWithDataBaseService.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}
