package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.storage.Storage;
import ru.astonstage1project.util.ExtraTimSort;

public class ExtraSort implements Action{
	private final Storage storage;

	public ExtraSort(Storage storage) {
		this.storage = storage;
	}

	private void sort() {
		ExtraTimSort.extraSort(storage.animals, null);
		ExtraTimSort.extraSort(storage.barrels, b -> b.getVolume() % 2 == 0);
		ExtraTimSort.extraSort(storage.humans, h -> h.getAge() % 2 == 0);
	}

	// private <T> void extraSort(List<T> list) {
	// }

	@Override
	public String doing(Map<String,String> params) {
		this.sort();
		return "Отсортированы элементы с четными полями.";
	}
}
