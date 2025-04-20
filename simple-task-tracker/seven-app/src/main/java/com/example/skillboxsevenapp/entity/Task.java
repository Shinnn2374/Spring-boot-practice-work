package com.example.skillboxsevenapp.entity;

import com.example.skillboxsevenapp.model.TaskModel;
import com.example.skillboxsevenapp.utils.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "task")
public class Task {
    @Id
    private String id;
    private String name;
    private String description;
    private Instant createdAt;
    private Instant updatedAt;
    private TaskStatus status;
    private String authorId;
    private String assigneeId;
    private Set<String> observerIds;
    @Transient
    private User author;
    @Transient
    private User assignee;
    @Transient
    private Set<User> observers;

    public static Task from(TaskModel taskModel) {
        return new Task(taskModel.getId(),
                taskModel.getDescription(),
                taskModel.getName(),
                taskModel.getCreatedAt(),
                taskModel.getUpdatedAt(),
                taskModel.getStatus(),
                taskModel.getAuthorId(),
                taskModel.getAssigneeId(),
                taskModel.getObserverIds(),
                taskModel.getAuthor(),
                taskModel.getAssignee(),
                taskModel.getObservers());
    }
}
