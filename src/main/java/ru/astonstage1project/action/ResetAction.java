package ru.astonstage1project.action;

import ru.astonstage1project.storage.Storage;

import java.util.Map;

public class ResetAction implements Action {
    private final Storage storage;

    public ResetAction(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String doing(Map<String, String> params) {
        if (params == null) {
            this.storage.reset();
            return "";
        }
        String type = params.get("type");
        this.storage.reset(type);
        return "";
    }

}
