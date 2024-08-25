package com.example.second_task.stud;

import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

@Service
public class StudentService
{
    private final Map<Integer, Student> students = new HashMap<>();


    public Student addStudent()
    {
        int id = students.size() + 1;
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя студента - ");
        String name = scanner.nextLine();
        student.setFirstName(name);
        System.out.println("Введите фамилию студента - ");
        String surname = scanner.nextLine();
        student.setSurname(surname);
        System.out.println("Введите возраст студента - ");
        int age = scanner.nextInt();
        student.setAge(age);
        student.setId(id);
        students.put(id,student);
        System.out.println(MessageFormat.format("Студент: {0} {1}, был добавлен в список", name, surname));
        return student;
    }

    public void seeAllStudents()
    {
        if (students.isEmpty()){
            System.out.println("Список пуст");
        }
        else
        {
            System.out.println("Список студентов:");
            for (Student student : students.values()) {
                System.out.println(student.toString());
            }
        }
    }

    public void removeStudent()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите id студента которого необходимо удалить - ");
        int id = scanner.nextInt();
        students.remove(id);
        System.out.println("Актуальный список студентов: ");
        for (Student student : students.values()){
            System.out.println(student.toString());
        }
    }

    public void deleteAll()
    {
        students.clear();
    }
}
