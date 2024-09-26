package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.storage.Storage;
import ru.astonstage1project.util.TimSort;

public class BaseSort implements Action{
	private final Storage storage;

	public BaseSort(Storage storage) {
		this.storage = storage;
	}

	private void sort() {
		TimSort.sort(storage.animals);
		TimSort.sort(storage.barrels);
		TimSort.sort(storage.humans);
	}

	@Override
	public String doing(Map<String,String> params) {
		this.sort();
		return "=== Коллекции успешно отсортированы ===";
	}
}
