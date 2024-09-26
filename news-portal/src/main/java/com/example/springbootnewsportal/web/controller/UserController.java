package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.UserMapper;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.web.model.user.UpsertUserRequest;
import com.example.springbootnewsportal.web.model.user.UserListResponse;
import com.example.springbootnewsportal.web.model.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController
{
    @Autowired
    private UserService service;
    @Autowired
    private UserMapper mapper;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.userListToUserResponseList(service.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long userId)
    {
        return ResponseEntity.ok(mapper.userToResponse(service.findById(userId)));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UpsertUserRequest request)
    {
        User newUser = service.save(mapper.requestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.userToResponse(newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable("id") Long userId, @RequestBody UpsertUserRequest request)
    {
        User updatedUser = service.update(mapper.requestToUser(userId, request));
        return ResponseEntity.ok(mapper.userToResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long userId)
    {
        service.deleteById(userId);
        return ResponseEntity.noContent().build();
    }
}
