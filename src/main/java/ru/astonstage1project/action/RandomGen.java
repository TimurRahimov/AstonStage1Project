package ru.astonstage1project.action;

import java.util.Map;
import java.util.Random;

import ru.astonstage1project.model.Animal;
import ru.astonstage1project.model.Barrel;
import ru.astonstage1project.model.Human;
import ru.astonstage1project.storage.Storage;

public class RandomGen implements Action {
    private static final String[] Species = new String[]{
            "Cat", "Dog", "Horse", "Lion", "Chicken", "Rabbit", "Snake", "Bear", "Hamster", "Crow"};
    private static final String[] Colors = new String[]{
            "Red", "Green", "Blue", "White", "Black", "Cyan", "Magenta", "Yellow", "", ""};
    private static final String[] StoredMaterials = new String[]{
            "Water", "Oil", "Powder", "Milk", "Money"};
    private static final String[] BarrelMaterials = new String[]{
            "Oak", "Beech", "Linden", "Aspen", "Aluminum", "Copper", "Steel"};
    private static final String[] Surnames = new String[]{
            "Rakhimov", "Timoshenko", "Khrapov", "Smith", "Cooper", "Horne", "Palmer", "Johnson", "Brigs", "Packard"};
    private static final String[] Sex = new String[]{"MALE", "FEMALE"};

    private final Random random = new Random();
    private final Storage storage;

    public RandomGen(Storage storage) {
        this.storage = storage;
    }

    private String generate(String type, int count) {
        for (int i = 0; i < count; i++) {
            switch (type) {
                case "animal" -> storage.add(generateRandomAnimal());
                case "barrel" -> storage.add(generateRandomBarrel());
                case "human" -> storage.add(generateRandomHuman());
            }
        }
        return "";
    }

    private Animal generateRandomAnimal() {
        Animal.AnimalBuilder animalBuilder = Animal.getBuilder();
        animalBuilder.setSpecies(Species[random.nextInt(Species.length)]);
        animalBuilder.setEyesColor(Colors[random.nextInt(Colors.length)]);
        animalBuilder.setWool(random.nextBoolean());
        return animalBuilder.build();
    }

    private Barrel generateRandomBarrel() {
        Barrel.BarrelBuilder barrelBuilder = Barrel.getBuilder();
        barrelBuilder.setVolume(random.nextInt(1, 1000));
        barrelBuilder.setStoredMaterial(StoredMaterials[random.nextInt(StoredMaterials.length)]);
        barrelBuilder.setBarrelMaterial(BarrelMaterials[random.nextInt(BarrelMaterials.length)]);
        return barrelBuilder.build();
    }

    private Human generateRandomHuman() {
        Human.HumanBuilder humanBuilder = Human.getBuilder();
        humanBuilder.setSex(Human.Sex.valueOf(Sex[random.nextInt(2)]));
        humanBuilder.setAge(random.nextInt(1, 100));
        humanBuilder.setSurname(Surnames[random.nextInt(Surnames.length)]);
        return humanBuilder.build();
    }

    @Override
    public String doing(Map<String, String> params) {
        String type = params.get("type");
        String count = params.get("count");
        return this.generate(type, Integer.parseInt(count));
    }
}
