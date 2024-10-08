package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.PostMapper;
import com.example.springbootnewsportal.model.Posts;
import com.example.springbootnewsportal.services.PostsService;
import com.example.springbootnewsportal.web.model.posts.PostListResponse;
import com.example.springbootnewsportal.web.model.posts.PostRequest;
import com.example.springbootnewsportal.web.model.posts.PostResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController
{
    private final PostsService postsService;
    private final PostMapper postMapper;

    @GetMapping
    public ResponseEntity<PostListResponse> findAll()
    {
        return ResponseEntity.ok(postMapper.postsListToResponse(postsService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(postMapper.postToResponse(postsService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<PostResponse> create(@RequestBody PostRequest request)
    {
        Posts posts = postsService.save(postMapper.requestToPost(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(postMapper.postToResponse(posts));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> update(@PathVariable Long id, @RequestBody PostRequest request)
    {
        Posts updatedPost = postsService.update(postMapper.requestToPost(id, request));
        return ResponseEntity.ok(postMapper.postToResponse(updatedPost));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        postsService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
