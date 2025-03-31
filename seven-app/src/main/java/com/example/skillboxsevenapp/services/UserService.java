package com.example.skillboxsevenapp.services;

import com.example.skillboxsevenapp.entity.User;
import com.example.skillboxsevenapp.repositoryes.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findUserByID(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> saveUser(User user) {
        return userRepository.save(user);
    }

    public Mono<User> updateUser(String id, User user) {
        return findUserByID(id).flatMap(itemForUpdate ->{
            if (StringUtils.hasText(user.getUsername())) {
                itemForUpdate.setUsername(user.getUsername());
            }
            if (StringUtils.hasText(user.getEmail())) {
                itemForUpdate.setEmail(user.getEmail());
            }
            return userRepository.save(itemForUpdate);
        });
    }

    public Mono<Void> deleteUserById(String id) {
        return userRepository.deleteById(id);
    }
}
