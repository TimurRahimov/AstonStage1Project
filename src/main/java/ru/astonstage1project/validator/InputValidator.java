package ru.astonstage1project.validator;

import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.util.Arrays;

public class InputValidator {

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
