package ru.astonstage1project.input;

import ru.astonstage1project.action.Action;
import ru.astonstage1project.action.ActionType;

import java.util.*;

public class ConsoleUI {
    private final Scanner scanner = new Scanner(System.in);
    private final ConsoleDataRequester dataRequester = new ConsoleDataRequester(scanner);
    private final Map<ActionType, Action> actionsContainer;
    private String command = "";

    public ConsoleUI(Map<ActionType, Action> actionsContainer) {
        this.actionsContainer = actionsContainer;
    }

    private void add() {
        String inputMethod = dataRequester.getInputMethod();
        if (inputMethod == null)
            return;

        add(inputMethod);
    }

    private void add(String inputMethod) {
        if (!Arrays.asList("manual", "file", "random").contains(inputMethod)) {
            System.out.println("-- Вы ввели неверную команду (для подсказки введите help, для выхода - exit)");
            return;
        }

        String type = dataRequester.getType();
        if (type == null)
            return;

        switch (inputMethod) {
            case "manual" -> addManual(type);
            case "file" -> addFile(type);
            case "random" -> addRandom(type);
        }
    }

    private void addManual(String type) {
        Integer count = dataRequester.getCount();
        if (count == null)
            return;

        for (int i = 1; i <= count; i++) {
            System.out.printf("=== Ввод данных %s №%d ===\n", type, i);
            Map<String, String> model = dataRequester.getModel(type);
            String response = actionsContainer.get(ActionType.MANUAL_DATA).doing(model);
            System.out.println(response);
        }

    }

    private void addFile(String type) {
        String path = dataRequester.getFilePath();
        if (path == null)
            return;

        Map<String, String> doingParams = new HashMap<>(Map.of("type", type, "path", path));
        String response = actionsContainer.get(ActionType.FILE_DATA).doing(doingParams);
        System.out.println(response);
    }

    private void addRandom(String type) {
        Integer count = dataRequester.getCount();
        if (count == null)
            return;

        Map<String, String> doingParams = new HashMap<>(Map.of("type", type, "count", String.valueOf(count)));
        String response = actionsContainer.get(ActionType.FILE_DATA).doing(doingParams);
        System.out.println(response);
    }

    private void find() {
        String type = dataRequester.getType();
        if (type == null)
            return;

        System.out.printf("=== Ввод данных %s ===\n", type);
        Map<String, String> model = dataRequester.getModel(type);
        String response = actionsContainer.get(ActionType.FIND).doing(model);
        System.out.println(response);
    }

    private void help() {
        System.out.println("=== Список команд ===");
        System.out.println("1. add - Общая команда добавления коллекций");
        System.out.println("2. add manual - Добавить коллекцию вручную");
        System.out.println("3. add file - Добавить коллекцию из файла");
        System.out.println("4. add random - Добавить коллекцию со случайными значениями");
        System.out.println("5. find - Найти элемент в отсортированной коллекции");
        System.out.println("6. sort - Отсортировать коллекцию");
        System.out.println("7. exit - Завершение программы");
    }

    private void sort() {
        String response = actionsContainer.get(ActionType.SORT_BASE).doing(new HashMap<>());
        System.out.println(response);
    }

    public void run() {
        while (!command.strip().equalsIgnoreCase("exit")) {
            System.out.print(">> ");
            command = scanner.nextLine().strip().toLowerCase();
            String[] command_args = command.split(" ");

            switch (command_args[0]) {
                case "add" -> {
                    if (command_args.length == 1) {
                        add();
                    } else {
                        add(command_args[1]);
                    }
                }
                case "find" -> find();
                case "help" -> help();
                case "sort" -> sort();
                case "exit" -> {
                }
                default -> System.out.println("-- Вы ввели неверную команду " +
                        "(для подсказки введите help, для выхода - exit)");
            }
        }
    }
}
