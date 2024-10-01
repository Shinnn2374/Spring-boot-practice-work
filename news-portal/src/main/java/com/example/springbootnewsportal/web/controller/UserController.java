package com.example.springbootnewsportal.web.controller;

import com.example.springbootnewsportal.mapper.UserMapper;
import com.example.springbootnewsportal.model.User;
import com.example.springbootnewsportal.service.UserService;
import com.example.springbootnewsportal.web.model.user.UpsertUserRequest;
import com.example.springbootnewsportal.web.model.user.UserListResponse;
import com.example.springbootnewsportal.web.model.user.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController
{
    private final UserService dataBaseUserService;
    private final UserMapper userMapper;

    @GetMapping
    public ResponseEntity<UserListResponse> findAll()
    {
        return ResponseEntity.ok(userMapper.userListToUserResponseList(dataBaseUserService.findAll()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> findById(@PathVariable Long id)
    {
        return ResponseEntity.ok(userMapper.userToResponse(dataBaseUserService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UpsertUserRequest request)
    {
        User newUser = dataBaseUserService.save(userMapper.requestToUser(request));
        return ResponseEntity.status(HttpStatus.CREATED).body(userMapper.userToResponse(newUser));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @RequestBody UpsertUserRequest request)
    {
        User updatedUser = dataBaseUserService.update(userMapper.requestToUser(id, request));
        return ResponseEntity.ok(userMapper.userToResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id)
    {
        dataBaseUserService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
