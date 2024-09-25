package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.mapper.AnimalMapper;
import ru.astonstage1project.mapper.BarrelMapper;
import ru.astonstage1project.mapper.HumanMapper;
import ru.astonstage1project.model.Animal;
import ru.astonstage1project.model.Barrel;
import ru.astonstage1project.model.Human;
import ru.astonstage1project.storage.Storage;
import ru.astonstage1project.util.Search;

public class FindBinary implements Action {
    private Storage storage;

    public FindBinary(Storage storage) {
        this.storage = storage;
    }

    private String find(Map<String, String> params) {
        int result;
        String type = params.get("type");

        switch (type) {
            case "animal" -> {
                try {
                    Animal animal = AnimalMapper.fromMap(params);
                    result = Search.binary(storage.animals, animal);
                } catch (ValidationError e) {
                    result = -1;
                }
                if (result >= 0) {
                    return storage.animals.get(result).toString();
                }
            }
            case "barrel" -> {
                try {
                    Barrel barrel = BarrelMapper.fromMap(params);
                    result = Search.binary(storage.barrels, barrel);
                } catch (ValidationError e) {
                    result = -1;
                }
                if (result >= 0) {
                    return storage.barrels.get(result).toString();
                }
            }
            case "human" -> {
                try {
                    Human human = HumanMapper.fromMap(params);
                    result = Search.binary(storage.humans, human);
                } catch (ValidationError e) {
                    result = -1;
                }
                if (result >= 0) {
                    return storage.humans.get(result).toString();
                }
            }
        }

        return "not found";
    }

    @Override
    public String doing(Map<String, String> params) {
        return this.find(params);
    }

}
