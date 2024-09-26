package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController
{
    private UserService service;
}
