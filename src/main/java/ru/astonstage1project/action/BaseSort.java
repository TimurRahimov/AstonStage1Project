package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.storage.Storage;
import ru.astonstage1project.util.TimSort;

public class BaseSort implements Action{
	private Storage stor;

	public BaseSort(Storage stor) {
		this.stor = stor;
	}

	private void sort() {
		TimSort.sort(stor.animals);
		TimSort.sort(stor.barrels);
		TimSort.sort(stor.humans);
	}

	@Override
	public String doing(Map<String,String> params) {
		this.sort();
		return "";
	}
}
