package ru.astonstage1project.mapper;

import java.util.Map;

import ru.astonstage1project.exception.ValidationError;
import ru.astonstage1project.model.Human;

import static ru.astonstage1project.validator.InputValidator.validateHuman;

public class HumanMapper {

    public static Human fromMap(Map<String, String> map) throws ValidationError {
        Human.HumanBuilder humanBuilder = Human.getBuilder();

        validateHuman(map);

        Human.Sex sex = Human.Sex.valueOf(map.get("sex").toUpperCase());
        humanBuilder.setSex(sex);

        int age = Integer.parseInt(map.get("age"));
        humanBuilder.setAge(age);

        String surname = map.get("surname");
        humanBuilder.setSurname(surname);

        return humanBuilder.build();
    }
}
