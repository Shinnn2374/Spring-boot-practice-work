package com.example.second_task.listner;

import com.example.second_task.event.StudentCreatedEvent;
import com.example.second_task.event.StudentDeletedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class StudentEventListener
{
    @EventListener
    public void onStudentCreated(StudentCreatedEvent event) {
        System.out.println("Создан студент с id: " + event.getStudent());
    }

    @EventListener
    public void onStudentDeleted(StudentDeletedEvent event) {
        System.out.println("Удаление студента");
    }
}
