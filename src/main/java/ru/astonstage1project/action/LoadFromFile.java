package ru.astonstage1project.action;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.io.FileReader;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.model.Animal;
import ru.astonstage1project.model.Barrel;
import ru.astonstage1project.model.Human;
import ru.astonstage1project.storage.Storage;

public class LoadFromFile implements Action {
    private final Storage storage;

    public LoadFromFile(Storage storage) {
        this.storage = storage;
    }

    private void load(Map<String, String> params) throws ValidationError {
        String type = params.get("type");
        String path = params.get("path");
        String extension = path.substring(path.lastIndexOf('.') + 1).toLowerCase();

        if (extension.equals("json")) {
            switch (type) {
                case "animal" -> storage.add(loadJSON(Animal.class, path));
                case "barrel" -> storage.add(loadJSON(Barrel.class, path));
                case "human" -> storage.add(loadJSON(Human.class, path));
            }
        } else if (extension.equals("csv")) {
            loadCSV(type, path);
        }
    }

    private <T> List<Object> loadJSON(Class<T> type, String path) throws ValidationError {
        Gson gson = new Gson();
        Type objectsType = TypeToken.getParameterized(List.class, type).getType();

        try (FileReader reader = new FileReader(path)) {
            return gson.fromJson(reader, objectsType);
        } catch (JsonSyntaxException e) {
            throw new ValidationError("Некорректный формат записи JSON-файла");
        } catch (IOException e) {
            throw new ValidationError("Ошибка чтения файла");
        }
    }

    private void loadCSV(String type, String path) {

    }

    @Override
    public String doing(Map<String, String> params) {
        try {
            this.load(params);
        } catch (ValidationError e) {
            return e.getMessage();
        }
        return "Объекты из файла успешно добавлены";
    }
}
