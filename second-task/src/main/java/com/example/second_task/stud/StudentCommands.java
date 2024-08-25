package com.example.second_task.stud;

import com.example.second_task.event.StudentCreatedEvent;
import com.example.second_task.event.StudentDeletedEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class StudentCommands
{
    private final StudentService studentService;
    private final ApplicationEventPublisher eventPublisher;

    public StudentCommands(StudentService studentService, ApplicationEventPublisher eventPublisher) {
        this.studentService = studentService;
        this.eventPublisher = eventPublisher;
    }


    @ShellMethod(key = "add")
    public void add()
    {
        Student student = studentService.addStudent();
        eventPublisher.publishEvent(new StudentCreatedEvent(this, student));
    }

    @ShellMethod(key = "see -a")
    public void seeAll()
    {
        studentService.seeAllStudents();
    }

    @ShellMethod(key = "rm")
    public void removeStudent()
    {
        studentService.removeStudent();
        eventPublisher.publishEvent(new StudentDeletedEvent(this));
    }

    @ShellMethod(key = "rm -a")
    public void removeAll()
    {
        studentService.deleteAll();
    }
}
