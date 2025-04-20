package com.example.skillboxsevenapp.controller;

import com.example.skillboxsevenapp.entity.User;
import com.example.skillboxsevenapp.model.UserModel;
import com.example.skillboxsevenapp.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public Flux<UserModel> getAllUsers() {
        return userService.findAll().map(UserModel::from);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<UserModel>> getUserById(@PathVariable String id) {
        return userService.findUserById(id)
                .map(UserModel::from)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<UserModel>> createUser(@RequestBody UserModel userModel) {
        return userService.saveUser(User.from(userModel))
                .map(UserModel::from)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<UserModel>> updateUser(@PathVariable String id, @RequestBody UserModel userModel) {
        return userService.updateUser(id, User.from(userModel))
                .map(UserModel::from)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    public Mono<ResponseEntity<Void>> deleteUser(@PathVariable String id) {
        return userService.deleteUserById(id).then(Mono.just(ResponseEntity.noContent().build()));
    }
}
