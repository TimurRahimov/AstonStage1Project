package ru.astonstage1project.action;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import ru.astonstage1project.storage.Storage;

public class ExtraSort implements Action{
	private Storage  stor;

	public ExtraSort(Storage stor) {
		this.stor = stor;
	}

	private void sort() {
		Collections.sort(stor.animals);
		Collections.sort(stor.barrels);
		Collections.sort(stor.humans);
	}

	private <T> void extraSort(List<T> list) {
	}

	@Override
	public String doing(Map<String,String> params) {
		this.sort();
		return "";
	}
}
