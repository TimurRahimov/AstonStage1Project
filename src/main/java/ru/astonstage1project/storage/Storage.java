package ru.astonstage1project.storage;

import java.util.ArrayList;
import java.util.List;

import ru.astonstage1project.model.Animal;
import ru.astonstage1project.model.Barrel;
import ru.astonstage1project.model.Human;

public class Storage {
    public List<Object> objects;
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
        this.objects = new ArrayList<>();
        this.animals = new ArrayList<>();
        this.barrels = new ArrayList<>();
        this.humans = new ArrayList<>();
    }

    public void add(Animal animal) {
        objects.add(animal);
        animals.add(animal);
    }

    public void add(Barrel barrel) {
        objects.add(barrel);
        barrels.add(barrel);
    }

    public void add(Human human) {
        objects.add(human);
        humans.add(human);
    }

    public void reset() {
        this.objects.clear();
        this.animals.clear();
        this.barrels.clear();
        this.humans.clear();
    }

    public void reset(String type) {
        switch (type) {
            case "all" -> this.reset();
            case "object", "objects" -> this.objects.clear();
            case "animal", "animals" -> this.animals.clear();
            case "barrel", "barrels" -> this.barrels.clear();
            case "human", "humans" -> this.humans.clear();
        }
    }
}
