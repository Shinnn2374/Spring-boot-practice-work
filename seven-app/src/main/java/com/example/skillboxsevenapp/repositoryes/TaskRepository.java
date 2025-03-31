package com.example.skillboxsevenapp.repositoryes;

import com.example.skillboxsevenapp.entity.Task;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TaskRepository extends ReactiveMongoRepository<Task, String> {
}
