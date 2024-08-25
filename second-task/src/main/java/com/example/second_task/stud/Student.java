package com.example.second_task.stud;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Student
{
    private String firstName;
    private String surname;
    private int age;
    private int id;

    public String toString()
    {
        return id + " " + firstName + " " + surname + " " + age;
    }
}
