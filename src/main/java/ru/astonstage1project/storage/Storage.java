package ru.astonstage1project.storage;

import java.util.List;

import ru.astonstage1project.models.Animal;
import ru.astonstage1project.models.Barrel;
import ru.astonstage1project.models.Human;

public class Storage {
	public List<Animal> animals;
	public List<Barrel> barrels;
	public List<Human> humans;

	public Storage(
		List<Animal> animals,
		List<Barrel> barrels,
		List<Human> humans
	) {
		this.animals = animals;
		this.barrels = barrels;
		this.animals = animals;
	}
}
