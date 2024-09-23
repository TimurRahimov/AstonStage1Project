package ru.astonstage1project.mapper;

import ru.astonstage1project.model.Human;

import java.util.Arrays;
import java.util.Map;

public class HumanMapper {

    public static Human fromMap(Map<String, String> map) throws ValidationError {
        Human.HumanBuilder humanBuilder = Human.getBuilder();

        String sexString = map.get("sex").toUpperCase();
        if (!Arrays.asList("MALE", "FEMALE").contains(sexString))
            throw new ValidationError("Некорректный пол человека (необходимо: male или female)");

        Human.Sex sex = Human.Sex.valueOf(sexString);
        humanBuilder.setSex(sex);

        String ageString = map.get("age");
        if (!ageString.matches("[-+]?\\d+"))
            throw new ValidationError("Некорректный формат возраста человека (необходимо число)");

        int age = Integer.parseInt(ageString);
        if (age <= 0 | age > 100)
            throw new ValidationError("Некорректный возраст человека (необходима величина от 1 до 100)");

        humanBuilder.setAge(age);

        String surname = map.get("surname");
        humanBuilder.setSurname(surname);

        return humanBuilder.build();
    }
}
