package ru.astonstage1project;

import ru.astonstage1project.action.*;
import ru.astonstage1project.input.ConsoleUI;
import ru.astonstage1project.storage.Storage;

import java.util.HashMap;
import java.util.Map;

public class App {
    private final Map<ActionType, Action> actionsContainer = new HashMap<>();
    private final Storage storage = new Storage();

    public void addAction(ActionType type, Action action) {
        actionsContainer.put(type, action);
    }

    public void run() {
        ConsoleUI consoleUI = new ConsoleUI(actionsContainer);
        consoleUI.run();
    }

    public static void main(String[] args) {
        App app = new App();

        app.addAction(ActionType.FILE_DATA, new ActionStub(app.storage));
        app.addAction(ActionType.RANDOM_DATA, new RandomGen(app.storage));
        app.addAction(ActionType.MANUAL_DATA, new ManualFeel(app.storage));
        app.addAction(ActionType.SORT_BASE, new BaseSort(app.storage));
        app.addAction(ActionType.FIND, new FindBinary(app.storage));
        app.addAction(ActionType.SORT_EXTRA, new BaseSort(app.storage));
        app.addAction(ActionType.PRINT_COLLECTION, new PrintCollection(app.storage));

        app.run();
    }

}