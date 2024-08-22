package org.example;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@Component
@Getter
@Setter
public class Person
{
    private  String name;
    private  String surname;
    private  String phone;
    private  String email;

    List<Person> contacts = new ArrayList<>();

    String fileName = "/Users/mihail/Desktop/prog/java/first/src/main/resources/default-contacts.txt";

    public Person()
    {
    }

    public Person(String name, String surname, String phone, String email)
    {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
    }

    public void seeAll()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка при чтении файла: " + e.getMessage());
        }

    }
    public void addNewContact()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя контакта: ");
        name = scanner.nextLine();
        System.out.println("Введите фамилию контакта: ");
        surname = scanner.nextLine();
        System.out.println("Введите номер контакта в формате +7 ... : ");
        phone = scanner.nextLine();
        System.out.println("Введите email контакта: ");
        email = scanner.nextLine();
        if (email.contains("@mail.ru")) {
            Person person = new Person(name, surname, phone, email);
            contacts.add(person);

            String toFile = person.getName() + " " + person.getSurname() + ";" + person.getPhone() + ";" + person.getEmail();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName,true))) {
                writer.write(toFile);
                writer.newLine();
                System.out.println("Данные успешно записаны в файл.");
            } catch (IOException e) {
                System.err.println("Ошибка при записи в файл: " + e.getMessage());
            }
        }else {
            System.out.println("Введен некорректный email");
        }
    }

    public void delete()
    {
        Path filePath = Paths.get(fileName);
        Scanner scanner = new Scanner(System.in);
        String fragmentToRemove = scanner.nextLine();
        try {
            removeLinesContaining(filePath, fragmentToRemove);
            System.out.println("Строки с указанным фрагментом успешно удалены.");
        } catch (IOException e) {
            System.err.println("Ошибка при удалении строк: " + e.getMessage());
        }
    }

    public static void removeLinesContaining(Path filePath, String fragmentToRemove) throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        List<String> updatedLines = lines.stream()
                .filter(line -> !line.contains(fragmentToRemove))
                .collect(Collectors.toList());
        Files.write(filePath, updatedLines);
    }
}

