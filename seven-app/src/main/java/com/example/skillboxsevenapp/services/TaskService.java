package com.example.skillboxsevenapp.services;

import com.example.skillboxsevenapp.entity.Task;
import com.example.skillboxsevenapp.repositoryes.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Flux<Task> findAll() {
        return taskRepository.findAll();
    }

    public Mono<Task> findTaskById(String id) {
        return taskRepository.findById(id);
    }

    public Mono<Task> saveTask(Task task) {
        return taskRepository.save(task);
    }

    public Mono<Task> updateTask(String id, Task task) {
        return taskRepository.findById(id).flatMap(existingTask -> {
            if (StringUtils.hasText(task.getName())) {
                existingTask.setName(task.getName());
            }
            if (StringUtils.hasText(task.getDescription())) {
                existingTask.setDescription(task.getDescription());
            }
            if (task.getStatus() != null) {
                existingTask.setStatus(task.getStatus());
            }
            if (StringUtils.hasText(task.getAuthorId())) {
                existingTask.setAuthorId(task.getAuthorId());
            }
            if (StringUtils.hasText(task.getAssigneeId())) {
                existingTask.setAssigneeId(task.getAssigneeId());
            }
            if (task.getObserverIds() != null && !task.getObserverIds().isEmpty()) {
                existingTask.setObserverIds(task.getObserverIds());
            }
            existingTask.setUpdatedAt(Instant.now());
            existingTask.setAuthor(task.getAuthor());
            existingTask.setAssignee(task.getAssignee());
            existingTask.setObservers(task.getObservers());
            return taskRepository.save(existingTask);
        });
    }

    public Mono<Void> deleteTaskById(String id) {
        return taskRepository.deleteById(id);
    }

    
}
