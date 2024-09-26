package ru.astonstage1project.mapper;

import java.util.Map;

import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.model.Animal;

import static ru.astonstage1project.validator.InputValidator.validateAnimal;

public class AnimalMapper {

    public static Animal fromMap(Map<String, String> map) throws ValidationError {
        Animal.AnimalBuilder animalBuilder = Animal.getBuilder();

        validateAnimal(map);

        String speciesString = map.get("species");
        animalBuilder.setSpecies(speciesString);

        String eyesColorString = map.get("eyesColor");
        animalBuilder.setEyesColor(eyesColorString);

        boolean wool = Boolean.parseBoolean(map.get("wool").toLowerCase());
        animalBuilder.setWool(wool);

        return animalBuilder.build();
    }

}
