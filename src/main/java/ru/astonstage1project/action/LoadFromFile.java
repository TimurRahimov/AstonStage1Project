package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.storage.Storage;

public class LoadFromFile implements Action {
    private final Storage storage;

    public LoadFromFile(Storage storage) {
        this.storage = storage;
    }

    private void load(Map<String, String> params) throws ValidationError {
        String type = params.get("type");
        String path = params.get("path");

    }

    @Override
    public String doing(Map<String, String> params) {
        try {
            this.load(params);
        } catch (ValidationError e) {
            return e.getMessage();
        }
        return "";
    }
}
