package ru.astonstage1project.action;


import ru.astonstage1project.storage.Storage;

import java.util.Map;

public class ActionStub implements Action {
    private Storage stor;

    public ActionStub(Storage stor) {
        this.stor = stor;
    }

    @Override
    public String doing(Map<String, String> params) {
        System.out.println(params.toString());
        return params.toString();
    }
}
