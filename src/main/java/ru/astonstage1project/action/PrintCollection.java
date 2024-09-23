package ru.astonstage1project.action;

import ru.astonstage1project.storage.Storage;

import java.util.Map;

public class PrintCollection implements Action {
    private final Storage storage;

    public PrintCollection(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String doing(Map<String, String> params) {
        if (this.storage.objects.isEmpty()) {
            return "=== Хранилище пусто ===";
        }
        StringBuilder stringBuilder = new StringBuilder();
        String typeOfCollection = this.storage.objects.getFirst().getClass().getSimpleName().toLowerCase();
        stringBuilder.append("=== Коллекция ").append(typeOfCollection).append(": ===\n");
        for (int i = 0; i < this.storage.objects.size(); i++) {
            stringBuilder.append(i + 1).append(": ").append(this.storage.objects.get(i)).append("\n");
        }
        return stringBuilder.toString();
    }
}
