package org.example;

import java.util.Scanner;

public class ApplicationInterface
{
    public void start()
    {
        int value;

        System.out.println("Выберите операцию: (Вставьте цифру)");
        System.out.println("1. Показать все контакты");
        System.out.println("2. Добавить контакт");
        System.out.println("3. Удалить контакт");
        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            value = scanner.nextInt();

            switch (value){
                case 1:
                    System.out.println("hui");
                case 2:
                    System.out.println("pizda");
                case 3:
                    System.out.println("close");
                default:
                    System.out.println("ОШИБКА! Данной операции нет в списке");
            }
        }
    }
}
