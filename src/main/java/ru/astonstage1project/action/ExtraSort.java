package ru.astonstage1project.action;

import java.util.Collections;
import java.util.Map;

import ru.astonstage1project.storage.Storage;

public class ExtraSort implements Action{
	private Storage  storage;

	public ExtraSort(Storage storage) {
		this.storage = storage;
	}

	private void sort() {
		Collections.sort(storage.animals);
		Collections.sort(storage.barrels);
		Collections.sort(storage.humans);
	}

	// private <T> void extraSort(List<T> list) {
	// }

	@Override
	public String doing(Map<String,String> params) {
		this.sort();
		return "";
	}
}
