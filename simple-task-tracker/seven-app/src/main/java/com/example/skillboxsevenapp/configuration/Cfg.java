package com.example.skillboxsevenapp.configuration;

import com.example.skillboxsevenapp.entity.User;
import com.example.skillboxsevenapp.repositoryes.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;

@Configuration
public class Cfg {
    @Bean
    public CommandLineRunner initData(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Очистка и создание тестовых пользователей
            userRepository.deleteAll().block();

            User user = new User();
            user.setUsername("user");
            user.setPassword(passwordEncoder.encode("password"));
            user.setRoles(Set.of("ROLE_USER"));
            userRepository.save(user).block();

            User manager = new User();
            manager.setUsername("manager");
            manager.setPassword(passwordEncoder.encode("password"));
            manager.setRoles(Set.of("ROLE_MANAGER"));
            userRepository.save(manager).block();
        };
    }
}
