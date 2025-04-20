package com.example.skillboxsevenapp.model;

import com.example.skillboxsevenapp.entity.Task;
import com.example.skillboxsevenapp.entity.User;
import com.example.skillboxsevenapp.utils.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {
    private String id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private TaskStatus status;
    private String authorId;
    private String assigneeId;
    private Set<String> observerIds;
    private User author;
    private User assignee;
    private Set<User> observers;

    public static TaskModel from(Task task) {
        var model = new TaskModel();
        model.setId(task.getId());
        model.setName(task.getName());
        model.setDescription(task.getDescription());
        model.setCreatedAt(task.getCreatedAt());
        model.setUpdatedAt(task.getUpdatedAt());
        model.setStatus(task.getStatus());
        model.setAuthorId(task.getAuthor().getId());
        model.setAssigneeId(task.getAssignee().getId());
        model.setAuthor(task.getAuthor());
        model.setAssignee(task.getAssignee());
        if (task.getObservers() != null) {
            model.setObserverIds(task.getObservers().stream()
                    .map(User::getId).collect(Collectors.toSet()));
        }
        if (task.getObservers() != null) {
            model.setObserverIds(task.getObservers().stream()
                    .map(User::getId).collect(Collectors.toSet()));
        }
        return model;
    }
}
