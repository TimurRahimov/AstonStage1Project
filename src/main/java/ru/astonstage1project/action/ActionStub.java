package ru.astonstage1project.action;


import java.util.Map;

import ru.astonstage1project.storage.Storage;

public class ActionStub implements Action {
    private Storage storage;

    public ActionStub(Storage storage) {
        this.storage = storage;
    }

    @Override
    public String doing(Map<String, String> params) {
        return params.toString();
    }
}
