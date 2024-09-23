package com.example.springbootnewsportal.web.controllers;

import com.example.springbootnewsportal.mapper.UserMapper;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.web.model.user.UserListResponse;
import com.example.springbootnewsportal.web.model.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userWithDataBaseService;
    private final UserMapper mapper;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll()
    {
        return ResponseEntity.ok(mapper.userListToUserResponseList(userWithDataBaseService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable("id") Long userId)
    {
        
    }
}
