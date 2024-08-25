package com.example.second_task.stud;

import com.example.second_task.SecondTaskApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class StudentAppApplication implements CommandLineRunner
{
    private final StudentService studentService;
    private final Environment environment;

    public StudentAppApplication(StudentService studentService, Environment environment) {
        this.studentService = studentService;
        this.environment = environment;
    }
    public static void main(String[] args) {
        SpringApplication.run(SecondTaskApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception
    {
        boolean createOnStartup = environment.getProperty("app.create-students-on-start", Boolean.class, true);
        if (createOnStartup) {
            studentService.addStudent();
        }
    }
}