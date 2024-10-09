package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.CommentMapper;
import com.example.springbootnewsportal.model.Comment;
import com.example.springbootnewsportal.services.CommentService;
import com.example.springbootnewsportal.web.model.comment.CommentListResponse;
import com.example.springbootnewsportal.web.model.comment.CommentRequest;
import com.example.springbootnewsportal.web.model.comment.CommentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController
{
    private final CommentService commentService;
    private final CommentMapper commentMapper;

    @GetMapping
    public ResponseEntity<CommentListResponse> findAll()
    {
        return ResponseEntity.ok(commentMapper.commentListToResponse(commentService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommentResponse> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(commentMapper.commentToResponse(commentService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<CommentResponse> create(@RequestBody @Valid CommentRequest request)
    {
        Comment newClient = commentService.save(commentMapper.requestToComment(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(commentMapper.commentToResponse(newClient));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable Long id, @RequestBody @Valid CommentRequest request)
    {
        Comment updatedComment = commentService.update(commentMapper.requestToComment(id, request));
        return ResponseEntity.ok(commentMapper.commentToResponse(updatedComment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        commentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
