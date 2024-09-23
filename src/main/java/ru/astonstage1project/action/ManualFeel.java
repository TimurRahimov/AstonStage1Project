package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.mapper.*;
import ru.astonstage1project.storage.Storage;

public class ManualFeel implements Action {
    private final Storage storage;

    public ManualFeel(Storage storage) {
        this.storage = storage;
    }

    private void load(Map<String, String> params) throws ValidationError {
        String type = params.get("type");
        switch (type) {
            case "animal" -> storage.add(AnimalMapper.fromMap(params));
            case "barrel" -> storage.add(BarrelMapper.fromMap(params));
            case "human" -> storage.add(HumanMapper.fromMap(params));
        }
    }

    @Override
    public String doing(Map<String, String> params) {
        try {
            this.load(params);
        } catch (ValidationError e) {
            return "-- Ошибка: " + e.getMessage();
        }
        return "";
    }
}
