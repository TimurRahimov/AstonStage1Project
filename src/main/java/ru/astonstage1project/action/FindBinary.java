package ru.astonstage1project.action;

import java.util.Collections;
import java.util.Map;

import ru.astonstage1project.model.Animal;
import ru.astonstage1project.model.Barrel;
import ru.astonstage1project.model.Human;
import ru.astonstage1project.storage.Storage;

public class FindBinary implements Action {
	private Storage stor;

	public FindBinary(Storage stor) {
		this.stor = stor;
	}

	private String find(Map<String,String> params) {
		int result;
		var animal = Animal.getBuilder().setSpecies(params.get("search"));
		result = Collections.binarySearch(stor.animals, animal, (x, y) -> {return x.toString().compareTo(y.toString());});
		if (result >= 0) {
			return "find animal" + stor.animals.get(result).toString();
		}
		var barrel = Barrel.getBuilder().setStoredMaterial(params.get("search"));
		result = Collections.binarySearch(stor.barrels, barrel, (x, y) -> {return x.toString().compareTo(y.toString());});
		if (result >= 0) {
			return "find barrel" + stor.barrels.get(result).toString();
		}
		var human = Human.getBuilder().setSurname(params.get("search"));
		result = Collections.binarySearch(stor.humans, human, (x, y) -> {return x.toString().compareTo(y.toString());});
		if (result >= 0) {
			return "find barrel" + stor.humans.get(result).toString();
		}

		return "not found";
	}

	@Override
	public String doing(Map<String,String> params) {
		return this.find(params);
	}

}
