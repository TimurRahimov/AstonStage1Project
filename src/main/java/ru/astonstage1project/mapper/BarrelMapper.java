package ru.astonstage1project.mapper;

import java.util.Map;

import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.model.Barrel;

public class BarrelMapper {

    public static Barrel fromMap(Map<String, String> map) throws ValidationError {
        Barrel.BarrelBuilder barrelBuilder = Barrel.getBuilder();

        String volumeString = map.get("volume");
        if (!volumeString.matches("[-+]?\\d+"))
            throw new ValidationError("Некорректный формат объема бочки (необходимо число)");

        int volume = Integer.parseInt(volumeString);
        if (volume <= 0 | volume > 1000)
            throw new ValidationError("Некорректный объем бочки (необходима величина от 1 до 1000)");

        barrelBuilder.setVolume(volume);

        String storedMaterialString = map.get("storedMaterial");
        barrelBuilder.setStoredMaterial(storedMaterialString);

        String barrelMaterialString = map.get("barrelMaterial");
        barrelBuilder.setBarrelMaterial(barrelMaterialString);

        return barrelBuilder.build();
    }

}
