package com.example.skillboxsevenapp.services;


import com.example.skillboxsevenapp.entity.User;
import com.example.skillboxsevenapp.repositoryes.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Flux<User> findAll() {
        return userRepository.findAll();
    }

    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }

    public Mono<User> save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Mono<User> update(String id, User user) {
        return userRepository.findById(id)
                .flatMap(existingUser -> {
                    if (user.getPassword() != null) {
                        existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
                    }
                    if (user.getUsername() != null) {
                        existingUser.setUsername(user.getUsername());
                    }
                    if (user.getRoles() != null) {
                        existingUser.setRoles(user.getRoles());
                    }
                    return userRepository.save(existingUser);
                });
    }

    public Mono<Void> delete(String id) {
        return userRepository.deleteById(id);
    }
}
