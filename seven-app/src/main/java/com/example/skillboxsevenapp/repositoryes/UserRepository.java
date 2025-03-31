package com.example.skillboxsevenapp.repositoryes;

import com.example.skillboxsevenapp.entity.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
