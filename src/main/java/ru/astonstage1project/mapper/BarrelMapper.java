package ru.astonstage1project.mapper;

import java.util.Map;

import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.model.Barrel;

import static ru.astonstage1project.validator.InputValidator.validateBarrel;


public class BarrelMapper {

    public static Barrel fromMap(Map<String, String> map) throws ValidationError {
        Barrel.BarrelBuilder barrelBuilder = Barrel.getBuilder();

        validateBarrel(map);

        int volume = Integer.parseInt(map.get("volume"));
        barrelBuilder.setVolume(volume);

        String storedMaterialString = map.get("storedMaterial");
        barrelBuilder.setStoredMaterial(storedMaterialString);

        String barrelMaterialString = map.get("barrelMaterial");
        barrelBuilder.setBarrelMaterial(barrelMaterialString);

        return barrelBuilder.build();
    }

}
