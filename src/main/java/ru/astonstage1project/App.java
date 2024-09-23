package ru.astonstage1project;

import ru.astonstage1project.model.Animal;
import ru.astonstage1project.storage.Storage;
import ru.astonstage1project.util.TimSort;

public class App {
    private static final Storage storage = new Storage();


    public static void main(String[] args) {
        storage.animals.add(Animal.getBuilder()
                            .setSpecies("кот")
                            .setEyesColor("зеленые")
                            .setWool(true)
                            .build());
        storage.animals.add(Animal.getBuilder()
                            .setSpecies("кошка")
                            .setEyesColor("зеленые")
                            .setWool(true)
                            .build());
        storage.animals.add(Animal.getBuilder()
                            .setSpecies("собака")
                            .setEyesColor("коричневые")
                            .setWool(true)
                            .build());
        storage.animals.add(Animal.getBuilder()
                            .setSpecies("египетский кот")
                            .setEyesColor("зеленые")
                            .setWool(false)
                            .build());

        System.out.println("до сортировки:");
        for( Animal a : storage.animals) {
            System.out.println(a.toString());
        }

        TimSort.sort(storage.animals);
        //Collections.sort(storage.animals);

        System.out.println("после сортировки:");
        for( Animal a : storage.animals) {
            System.out.println(a.toString());
        }
    }

}