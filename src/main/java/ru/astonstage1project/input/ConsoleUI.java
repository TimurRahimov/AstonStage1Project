package ru.astonstage1project.input;

import static ru.astonstage1project.validator.InputValidator.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ru.astonstage1project.action.Action;
import ru.astonstage1project.action.ActionType;

/**
 * The {@code ConsoleUI} class implements
 * console interaction with the user.<br>
 * This class contains the run() method,
 * which polls the user in a loop, as
 * well as methods for processing user
 * commands. <br>
 * When processing commands, the required
 * {@code Action} are called. <br>
 * The container with {@code Action}s is
 * passed in the constructor.
 */
public class ConsoleUI {

    // User poll Scanner
    private final Scanner scanner = new Scanner(System.in);

    // Data requester in console
    private final ConsoleDataRequester dataRequester = new ConsoleDataRequester(scanner);

    // Map of added actions with a key in the form of action type
    private final Map<ActionType, Action> actionsContainer;

    public ConsoleUI(Map<ActionType, Action> actionsContainer) {
        this.actionsContainer = actionsContainer;
    }

    /**
     * This method {@code add()} creates a chain
     * of user polls to add models to the program
     */
    private void add() {
        String inputMethod = dataRequester.getInputMethod();
        if (inputMethod == null)
            return;

        add(inputMethod);
    }

    /**
     * This method {@code add()} creates a chain
     * of user polls to add models to the program
     *
     * @param inputMethod Input method
     */
    private void add(String inputMethod) {
        if (!validateInputMethod(inputMethod)) {
            System.out.println("-- Вы ввели неверную команду (для подсказки введите help, для выхода - exit)");
            return;
        }

        String type = dataRequester.getType();
        if (type == null)
            return;

        add(inputMethod, type);
    }

    private void add(String inputMethod, String type) {
        if (!validateInputMethod(inputMethod) | !validateType(type)) {
            System.out.println("-- Вы ввели неверную команду (для подсказки введите help, для выхода - exit)");
            return;
        }

        switch (inputMethod) {
            case "manual" -> addManual(type);
            case "file" -> addFile(type);
            case "random" -> addRandom(type);
        }
    }

    private void add(String inputMethod, String type, String count) {
        if (!validateInputMethod(inputMethod) | !validateType(type)) {
            System.out.println("-- Вы ввели неверную команду (для подсказки введите help, для выхода - exit)");
            return;
        }

        if (!count.matches("[-+]?\\d+")) {
            return;
        }
        int intCount = Integer.parseInt(count);

        switch (inputMethod) {
            case "manual" -> addManual(type, intCount);
            case "file" -> addFile(type);
            case "random" -> addRandom(type, intCount);
        }
    }

    /**
     * This method {@code addManual(String type)} creates a chain
     * of user polls to manually add models to the program
     *
     * @param type Type of models to be added
     */
    private void addManual(String type) {
        Integer count = dataRequester.getCount();
        if (count == null)
            return;

        addManual(type, count);
    }

    /**
     * This method {@code addManual(String type)} creates a chain
     * of user polls to manually add models to the program
     *
     * @param type  Type of models to be added
     * @param count Count of models to be added
     */
    private void addManual(String type, int count) {
        for (int i = 1; i <= count; ) {
            System.out.printf("=== Ввод данных %s №%d ===\n", type, i);
            Map<String, String> model = dataRequester.getModel(type);
            String response = actionsContainer.get(ActionType.MANUAL_DATA).doing(model);
            if (!response.isEmpty()) {
                System.out.println(response);
            } else {
                i++;
            }
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

        addRandom(type, count);
    }

    private void addRandom(String type, int count) {
        Map<String, String> doingParams = new HashMap<>(Map.of("type", type, "count", String.valueOf(count)));
        String response = actionsContainer.get(ActionType.RANDOM_DATA).doing(doingParams);
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
        System.out.println("add - Общая команда добавления коллекций");
        System.out.println("add manual - Добавить коллекцию вручную");
        System.out.println("add manual <type> - Добавить коллекцию определённого типа вручную");
        System.out.println("add manual <type> <count> - Добавить коллекцию определённого размера и типа вручную");
        System.out.println("add file - Добавить коллекцию из файла");
        System.out.println("add random - Добавить коллекцию со случайными значениями");
        System.out.println("find - Найти элемент в отсортированной коллекции");
        System.out.println("print - Вывести коллекцию в консоль");
        System.out.println("print <type> - Вывести коллекцию определённого типа в консоль");
        System.out.println("reset - Очистить коллекцию");
        System.out.println("sort - Отсортировать коллекцию");
        System.out.println("shuffle - Перемешать коллекцию");
        System.out.println("exit - Завершение программы");
    }

    private void print() {
        String type = dataRequester.getType();
        if (type == null)
            return;

        print(type);
    }

    private void print(String type) {
        if (!validateType(type)) {
            System.out.println("-- Вы ввели неверную команду (для подсказки введите help, для выхода - exit)");
            return;
        }

        String response = actionsContainer.get(ActionType.PRINT_COLLECTION).doing(
                new HashMap<>(Map.of("type", type)));
        System.out.println(response);
    }

    private void reset() {
        String type = dataRequester.getType();
        if (type == null)
            return;

        reset(type);
    }

    private void reset(String type) {
        if (!validateType(type)) {
            System.out.println("-- Вы ввели неверную команду (для подсказки введите help, для выхода - exit)");
            return;
        }

        String response = actionsContainer.get(ActionType.RESET_COLLECTION).doing(new HashMap<>(Map.of("type", type)));
        System.out.println(response);
    }

    private void sort() {
        String response = actionsContainer.get(ActionType.SORT_BASE).doing(null);
        System.out.println(response);
    }

    private void shuffle() {
        String type = dataRequester.getType();
        if (type == null)
            return;

        shuffle(type);
    }

    private void shuffle(String type) {
        if (!validateType(type)) {
            System.out.println("-- Вы ввели неверную команду (для подсказки введите help, для выхода - exit)");
            return;
        }

        String response = actionsContainer.get(ActionType.SHUFFLE_COLLECTION).doing(new HashMap<>(Map.of("type", type)));
        System.out.println(response);
    }

    public void run() {
        String command = "";
        help();
        while (!command.strip().equalsIgnoreCase("exit")) {
            System.out.print(">> ");
            command = scanner.nextLine().strip().toLowerCase();
            String[] command_args = command.split(" ");

            switch (command_args[0]) {
                case "add" -> {
                    if (command_args.length == 1) {
                        add();
                    } else if (command_args.length == 2) {
                        add(command_args[1]);
                    } else if (command_args.length == 3) {
                        add(command_args[1], command_args[2]);
                    } else if (command_args.length == 4) {
                        add(command_args[1], command_args[2], command_args[3]);
                    }
                }
                case "find" -> find();
                case "help" -> help();
                case "print" -> {
                    if (command_args.length == 1) {
                        print();
                    } else if (command_args.length == 2) {
                        print(command_args[1]);
                    }
                }
                case "reset" -> {
                    if (command_args.length == 1) {
                        reset();
                    } else if (command_args.length == 2) {
                        reset(command_args[1]);
                    }
                }
                case "sort" -> sort();
                case "shuffle" -> {
                    if (command_args.length == 1) {
                        shuffle();
                    } else if (command_args.length == 2) {
                        shuffle(command_args[1]);
                    }
                }
                case "exit" -> {
                }
                default -> System.out.println("-- Вы ввели неверную команду " +
                        "(для подсказки введите help, для выхода - exit)");
            }
        }
    }
}
