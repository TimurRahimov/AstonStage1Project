package ru.astonstage1project.validator;

import java.util.Arrays;

public class InputValidator {
    public static boolean validateType(String type) {
        return (Arrays.asList("animal", "barrel", "human").contains(type));
    }

    public static boolean validateInputMethod(String inputMethod) {
        return (Arrays.asList("manual", "file", "random").contains(inputMethod));
    }

}
