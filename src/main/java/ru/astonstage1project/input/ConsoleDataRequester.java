package ru.astonstage1project.input;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConsoleDataRequester {
    private final Scanner scanner;

    public ConsoleDataRequester(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getType() {
        System.out.print("Выберите тип объектов (animal, barrel, human): ");
        String command = scanner.nextLine().strip().toLowerCase();
        if (Arrays.asList("animal", "barrel", "human").contains(command))
            return command;
        else if (command.equals("break"))
            return null;
        System.out.println("-- Вы ввели неверный тип объекта (для выхода введите break)");
        return getType();
    }

    public String getInputMethod() {
        System.out.print("Выберите метод ввода (manual, file, random): ");
        String command = scanner.nextLine().strip().toLowerCase();
        if (Arrays.asList("manual", "file", "random").contains(command))
            return command;
        else if (command.equals("break"))
            return null;
        System.out.println("-- Вы ввели неверный метод ввода (для выхода введите break)");
        return getInputMethod();
    }

    public Integer getCount() {
        System.out.print("Введите количество объектов: ");
        int count = Integer.parseInt(scanner.nextLine().strip().toLowerCase());
        if (count > 0)
            return count;
        else if (count == -1)
            return null;
        System.out.println("-- Вы ввели неверное количество объектов (для выхода введите -1)");
        return getCount();
    }

    public String getFilePath() {
        System.out.print("Введите путь к файлу: ");
        String command = scanner.nextLine().strip().toLowerCase();
        if (Files.isRegularFile(Paths.get(command)))
            return command;
        else if (command.equals("break"))
            return null;

        System.out.println("-- Указанный файл не существует  (для выхода введите break)");
        return getFilePath();
    }

    public Map<String, String> getModel(String type) {
        return switch (type) {
            case "animal" -> getAnimal();
            case "barrel" -> getBarrel();
            case "human" -> getHuman();
            default -> null;
        };
    }

    public Map<String, String> getAnimal() {
        Map<String, String> animal = new HashMap<>();
        animal.put("type", "animal");

        System.out.print("Введите вид животного: ");
        String command = scanner.nextLine().strip();
        animal.put("species", command);

        System.out.print("Введите цвет глаз животного: ");
        command = scanner.nextLine().strip();
        animal.put("eyesColor", command);

        System.out.print("Введите наличие шерсти животного (true, false): ");
        command = scanner.nextLine().strip();
        animal.put("wool", command);

        return animal;
    }

    public Map<String, String> getBarrel() {
        Map<String, String> barrel = new HashMap<>();
        barrel.put("type", "barrel");

        System.out.print("Введите объем бочки: ");
        String command = scanner.nextLine().strip();
        barrel.put("volume", command);

        System.out.print("Введите хранимый материал: ");
        command = scanner.nextLine().strip();
        barrel.put("storedMaterial", command);

        System.out.print("Введите материал, из которого изготовлена бочка: ");
        command = scanner.nextLine().strip();
        barrel.put("barrelMaterial", command);

        return barrel;
    }

    public Map<String, String> getHuman() {
        Map<String, String> human = new HashMap<>();
        human.put("type", "human");

        System.out.print("Введите пол человека: ");
        String command = scanner.nextLine().strip();
        human.put("sex", command);

        System.out.print("Введите возраст человека: ");
        command = scanner.nextLine().strip();
        human.put("age", command);

        System.out.print("Введите фамилию человека: ");
        command = scanner.nextLine().strip();
        human.put("surname", command);

        return human;
    }

}
