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

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void add(Barrel barrel) {
        barrels.add(barrel);
    }

    public void add(Human human) {
        humans.add(human);
    }

    public void add(Object object) {
        if (object instanceof Animal)
            add((Animal) object);
        else if (object instanceof Barrel)
            add((Barrel) object);
        else if (object instanceof Human)
            add((Human) object);
    }

    public void add(List<Object> list) {
        list.forEach(this::add);
    }

    public void reset() {
        this.animals.clear();
        this.barrels.clear();
        this.humans.clear();
    }

    public void reset(String type) {
        switch (type) {
            case "all" -> this.reset();
            case "animal", "animals" -> this.animals.clear();
            case "barrel", "barrels" -> this.barrels.clear();
            case "human", "humans" -> this.humans.clear();
        }
    }
}
