package ru.astonstage1project.action;

import ru.astonstage1project.storage.Storage;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class PrintCollection implements Action {
    private final Storage storage;

    public PrintCollection(Storage storage) {
        this.storage = storage;
    }

    private static String printObjects(List<Object> objects) {
        if (objects.isEmpty()) {
            return "=== Хранилище пусто ===";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String typeOfCollection = objects.getFirst().getClass().getSimpleName().toLowerCase();
        stringBuilder.append("=== Коллекция ").append(typeOfCollection).append(": ===\n");
        int collectionSize = objects.size();
        for (int i = 0; i < collectionSize; i++) {
            stringBuilder.append(i + 1).append(": ").append(objects.get(i));
            if (i != collectionSize - 1)
                stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    @Override
    public String doing(Map<String, String> params) {
        return (params != null) ? switch (params.get("type")) {
            case "animal" -> printObjects(Arrays.asList(this.storage.animals.toArray()));
            case "barrel" -> printObjects(Arrays.asList(this.storage.barrels.toArray()));
            case "human" -> printObjects(Arrays.asList(this.storage.humans.toArray()));
            default -> null;
        } : printObjects(this.storage.objects);
    }
}
