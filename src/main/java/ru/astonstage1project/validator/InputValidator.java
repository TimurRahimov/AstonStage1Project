package ru.astonstage1project.validator;

import ru.astonstage1project.exception.ValidationError;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;

public class InputValidator {

    public static boolean validateModel(String type, Map<String, String> model) throws ValidationError {
        return switch (type) {
            case "animal" -> validateAnimal(model);
            case "barrel" -> validateBarrel(model);
            case "human" -> validateHuman(model);
            default -> false;
        };
    }

    public static boolean validateAnimal(Map<String, String> model) throws ValidationError {
        String speciesString = model.get("species");
        if (speciesString == null)
            throw new ValidationError("Объект должен содержать поле species");
        else if (speciesString.isEmpty())
            throw new ValidationError("Поле species не должно быть пустым");

        String eyesColorString = model.get("eyesColor");
        if (eyesColorString == null)
            throw new ValidationError("Объект должен содержать поле eyesColor");
        else if (eyesColorString.isEmpty())
            throw new ValidationError("Поле eyesColor не должно быть пустым");

        String woolString = model.get("wool");
        if (woolString == null)
            throw new ValidationError("Объект должен содержать поле woolString");
        if (!Arrays.asList("true", "false").contains(woolString.toLowerCase()))
            throw new ValidationError("Некорректный признак наличия шерсти (необходимо: true/false)");

        return true;
    }

    public static boolean validateBarrel(Map<String, String> model) throws ValidationError {
        String volumeString = model.get("volume");
        if (volumeString == null)
            throw new ValidationError("Объект должен содержать поле volumeString");
        if (!volumeString.matches("[-+]?\\d+"))
            throw new ValidationError("Некорректный формат объема бочки (необходимо число)");
        int volume = Integer.parseInt(volumeString);
        if (volume <= 0 | volume > 1000)
            throw new ValidationError("Некорректный объем бочки (необходима величина от 1 до 1000)");

        String storedMaterialString = model.get("storedMaterial");
        if (storedMaterialString == null)
            throw new ValidationError("Объект должен содержать поле storedMaterialString");
        else if (storedMaterialString.isEmpty())
            throw new ValidationError("Поле storedMaterialString не должно быть пустым");

        String barrelMaterialString = model.get("barrelMaterial");
        if (barrelMaterialString == null)
            throw new ValidationError("Объект должен содержать поле barrelMaterialString");
        else if (barrelMaterialString.isEmpty())
            throw new ValidationError("Поле barrelMaterialString не должно быть пустым");

        return true;
    }

    public static boolean validateHuman(Map<String, String> model) throws ValidationError {
        String sexString = model.get("sex");
        if (sexString == null)
            throw new ValidationError("Объект должен содержать поле sexString");
        if (!Arrays.asList("MALE", "FEMALE").contains(sexString.toUpperCase()))
            throw new ValidationError("Некорректный пол человека (необходимо: male/female)");

        String ageString = model.get("age");
        if (ageString == null)
            throw new ValidationError("Объект должен содержать поле ageString");
        if (!ageString.matches("[-+]?\\d+"))
            throw new ValidationError("Некорректный формат возраста человека (необходимо число)");
        int age = Integer.parseInt(ageString);
        if (age <= 0 | age > 100)
            throw new ValidationError("Некорректный возраст человека (необходима величина от 1 до 100)");

        String surname = model.get("surname");
        if (surname == null)
            throw new ValidationError("Объект должен содержать поле surname");
        else if (surname.isEmpty())
            throw new ValidationError("Поле surname не должно быть пустым");

        return true;
    }

    public static boolean validateType(String type) {
        return (Arrays.asList("animal", "barrel", "human").contains(type));
    }

    public static boolean validateInputMethod(String inputMethod) {
        return (Arrays.asList("manual", "file", "random").contains(inputMethod));
    }

    public static boolean validateFilePath(String filePath) {
        try {
            return Files.isRegularFile(Paths.get(filePath));
        } catch (InvalidPathException e) {
            return false;
        }
    }

}
