package com.example.skillboxsevenapp.controller;

import com.example.skillboxsevenapp.Publisher.TaskPublisher;
import com.example.skillboxsevenapp.entity.Task;
import com.example.skillboxsevenapp.model.TaskModel;
import com.example.skillboxsevenapp.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;
    private final TaskPublisher publisher;

    @GetMapping
    public Flux<TaskModel> getTasks() {
        return taskService.findAll().map(TaskModel::from);
    }

    @GetMapping("/{id}")
    public Mono<ResponseEntity<TaskModel>> getTaskById(@PathVariable String id) {
        return taskService.findTaskById(id)
                .map(TaskModel::from)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Mono<ResponseEntity<TaskModel>> createTask(@RequestBody TaskModel taskModel) {
        return taskService.saveTask(Task.from(taskModel))
                .map(TaskModel::from)
                .doOnSuccess(publisher::publish)
                .map(ResponseEntity::ok);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<TaskModel>> updateTask(@PathVariable String id, @RequestBody TaskModel taskModel) {
        return taskService.updateTask(id,Task.from(taskModel))
                .map(TaskModel::from)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping("/stream")
    public Flux<ServerSentEvent<TaskModel>> getTasksStream() {
        return publisher.getUpdatesSink()
                .asFlux()
                .map(task -> ServerSentEvent.builder(task).build());
    }

    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<Void>> deleteTask(@PathVariable String id) {
        return taskService.deleteTaskById(id).then(Mono.just(ResponseEntity.noContent().build()));
    }
}
