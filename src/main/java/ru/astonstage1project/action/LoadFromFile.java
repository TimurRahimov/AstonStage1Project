package ru.astonstage1project.action;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.io.FileReader;


import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.mapper.AnimalMapper;
import ru.astonstage1project.mapper.BarrelMapper;
import ru.astonstage1project.mapper.HumanMapper;
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
            storage.add(loadJSON(type, path));
        }
    }

    private List<Object> loadJSON(String type, String path) throws ValidationError {
        Gson gson = new Gson();
        Type anotherType = new TypeToken<ArrayList<Map<String, String>>>() {
        }.getType();

        try (FileReader reader = new FileReader(path)) {
            List<Map<String, String>> list = gson.fromJson(reader, anotherType);
            List<Object> resultList = new ArrayList<>();
            for (Map<String, String> map : list) {
                switch (type) {
                    case "animal" -> resultList.add(AnimalMapper.fromMap(map));
                    case "barrel" -> resultList.add(BarrelMapper.fromMap(map));
                    case "human" -> resultList.add(HumanMapper.fromMap(map));
                }
            }
            return resultList;
        } catch (JsonSyntaxException e) {
            throw new ValidationError("Некорректный формат записи JSON-файла");
        } catch (IOException e) {
            throw new ValidationError("Ошибка чтения файла");
        }
    }

    @Override
    public String doing(Map<String, String> params) {
        try {
            this.load(params);
        } catch (ValidationError e) {
            return "-- Ошибка: " + e.getMessage();
        }
        return "Объекты из файла успешно добавлены";
    }
}
