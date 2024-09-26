package ru.astonstage1project.action;

import ru.astonstage1project.storage.Storage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class ShuffleCollection implements Action {
    private final Storage storage;

    public ShuffleCollection(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String doing(Map<String, String> params) {
        String type = params.get("type");

        Collections.shuffle(switch (type) {
            case "animal" -> storage.animals;
            case "barrel" -> storage.barrels;
            case "human" -> storage.humans;
            default -> new ArrayList<>();
        });
        return "=== Коллекция " + type + " успешно перемешана ===";
    }

}
