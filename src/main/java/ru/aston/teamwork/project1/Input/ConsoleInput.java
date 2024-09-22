package ru.aston.teamwork.project1.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleInput {

    public List<List<String>> getConsolePerson() {
        List<List<String>> list = new ArrayList<>();
        List<String> strings;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            strings = new ArrayList<>();
            System.out.println("Введите имя: ");
            strings.add(scanner.next());
            while (true) {
                System.out.println("Введите пол (м/ж): ");
                String str = scanner.next();
                if (str.equals("ж") || str.equals("м")) {
                    strings.add(str.toLowerCase());
                    break;
                }
                System.out.println("Неверный формат пола. Нужно ввести {ж} или {м}. Попробуйте снова!");
            }
            while (true) {
                System.out.println("Введите возраст: ");
                String str = scanner.next();
                if (str.matches("-?\\d+")) {
                    int number = Integer.parseInt(str);
                    if (number > 0 && number <= 100) {
                        strings.add(str);
                        break;
                    }
                }
                System.out.println("Неверный формат возраста! Требуется ввести число от 1 до 100. Попробуйте ещё раз!");
            }
            list.add(strings);
            System.out.println("Ввести еще одну персону? Введи {нет}, если не нужно!");
            if (scanner.next().equalsIgnoreCase("нет")) {
                break;
            }
        }
        return list;
    }

    public List<List<String>> getConsoleAnimal() {
        List<List<String>> list = new ArrayList<>();
        List<String> strings;
        String str;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            strings = new ArrayList<>();
            System.out.println("Введите тип животного: ");
            strings.add(scanner.next());

            System.out.println("Введите цвет глаз животного: ");
            strings.add(scanner.next());
            while (true) {
                System.out.println("У животного есть шерсть?: (да/нет)");
                str = scanner.next();
                if (str.equalsIgnoreCase("да")) {
                    strings.add("true");
                    break;
                } else if (str.equalsIgnoreCase("нет")) {
                    strings.add("false");
                    break;
                } else {
                    System.out.println("Неверный формат ввода. Введите {да}, если у животного есть шерсть или {нет}," +
                            " если животное голое! ");
                }
            }
            list.add(strings);
            System.out.println("Ввести еще одно животное? Введи {нет}, если не нужно!");
            if (scanner.next().equalsIgnoreCase("нет")) {
                break;
            }
        }
        return list;
    }

    public List<List<String>> getConsoleBarrel() {
        List<List<String>> list = new ArrayList<>();
        List<String> strings;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            strings = new ArrayList<>();
            while (true) {
                System.out.println("Введите объем бочки: ");
                String str = scanner.next();
                if (str.matches("-?\\d+")) {
                    int number = Integer.parseInt(str);
                    if (number > 0 && number <= 1000) {
                        strings.add(str);
                        break;
                    }
                }
                System.out.println("Неверный формат! Требуется ввести число от 1 до 1000. Попробуйте ещё раз!");
            }
            System.out.println("Введите тип материала бочки: ");
            strings.add(scanner.next());
            System.out.println("Введите, что находится в бочке: ");
            strings.add(scanner.next());
            list.add(strings);
            System.out.println("Ввести еще одну бочку? Введи {нет}, если не нужно!");
            if (scanner.next().equalsIgnoreCase("нет")) {
                break;
            }
        }
        return list;
    }
}
