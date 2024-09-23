package ru.astonstage1project.mapper;

import ru.astonstage1project.model.Animal;

import java.util.Arrays;
import java.util.Map;

public class AnimalMapper {

    public static Animal fromMap(Map<String, String> map) throws ValidationError {
        Animal.AnimalBuilder animalBuilder = Animal.getBuilder();

        String speciesString = map.get("species");
        animalBuilder.setSpecies(speciesString);

        String eyesColorString = map.get("eyesColor");
        animalBuilder.setEyesColor(eyesColorString);

        String woolString = map.get("wool").toLowerCase();
        if (!Arrays.asList("true", "false").contains(woolString))
            throw new ValidationError("Некорректный признак наличия шерсти (необходимо: true или false)");

        boolean wool = Boolean.parseBoolean(woolString);
        animalBuilder.setWool(wool);

        return animalBuilder.build();
    }

}
