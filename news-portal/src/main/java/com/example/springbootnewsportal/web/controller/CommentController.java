package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.CommentMapper;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.service.CommentService;
import com.example.springbootnewsportal.web.model.comment.CommentListResponse;
import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import com.example.springbootnewsportal.web.model.comment.UpsertCommentRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController
{
    private CommentService service;
    private CommentMapper mapper;

    @GetMapping
    public ResponseEntity<CommentListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.commentListToCommentListResponse(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable("id") Long commentId)
    {
        return ResponseEntity.ok(mapper.commentToResponse(service.findById(commentId)));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody UpsertCommentRequest request)
    {
        Comment comment = service.save(mapper.requestToComment(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.commentToResponse(comment));
    }

    @PutMapping
    public ResponseEntity<CommentResponse> update(@PathVariable("id") Long commentId, @RequestBody UpsertCommentRequest request)
    {
        Comment updatedComment = service.update(mapper.requestToComment(commentId, request));
        return ResponseEntity.ok(mapper.commentToResponse(updatedComment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long commentId)
    {
        service.deleteById(commentId);
        return ResponseEntity.noContent().build();
    }
}
