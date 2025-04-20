package com.example.skillboxsevenapp.Publisher;

import com.example.skillboxsevenapp.model.TaskModel;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Sinks;

@Component
public class TaskPublisher {
    private final Sinks.Many<TaskModel> taskModelUpdatesSink;

    public TaskPublisher() {
        this.taskModelUpdatesSink = Sinks.many().multicast().onBackpressureBuffer();
    }

    public void publish(TaskModel model) {
        taskModelUpdatesSink.tryEmitNext(model);
    }

    public Sinks.Many<TaskModel> getUpdatesSink() {
        return taskModelUpdatesSink;
    }
}
