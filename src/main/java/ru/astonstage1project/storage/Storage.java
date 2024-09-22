package ru.astonstage1project.storage;

import java.util.ArrayList;
import java.util.List;

import ru.astonstage1project.model.Animal;
import ru.astonstage1project.model.Barrel;
import ru.astonstage1project.model.Human;

public class Storage {
    public List<Animal> animals;
    public List<Barrel> barrels;
    public List<Human> humans;

    public Storage(List<Animal> animals,
                   List<Barrel> barrels,
                   List<Human> humans) {
        this.animals = animals;
        this.barrels = barrels;
        this.humans = humans;
    }

    public Storage() {
        this.animals = new ArrayList<>();
        this.barrels = new ArrayList<>();
        this.humans = new ArrayList<>();
    }

    public void reset(String type) {
        switch (type) {
            case "animals" -> this.animals = new ArrayList<>();
            case "barrels" -> this.barrels = new ArrayList<>();
            case "humans" -> this.humans = new ArrayList<>();
        }
    }
}
