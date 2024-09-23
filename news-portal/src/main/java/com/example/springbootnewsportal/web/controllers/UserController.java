package com.example.springbootnewsportal.web.controllers;

import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.web.model.user.UserListResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController
{
    private final UserService userWithDataBaseService;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll()
    {
        return ResponseEntity.ok()
    }
}
