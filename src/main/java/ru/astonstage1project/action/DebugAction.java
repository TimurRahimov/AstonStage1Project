package ru.astonstage1project.action;


import ru.astonstage1project.storage.Storage;

import java.util.Map;

public class DebugAction implements Action {

    public DebugAction(Storage storage) {
    }

    @Override
    public String doing(Map<String, String> params) {
        return params.toString();
    }
}
