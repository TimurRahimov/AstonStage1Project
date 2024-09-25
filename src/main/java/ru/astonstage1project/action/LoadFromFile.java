package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.storage.Storage;

public class LoadFromFile implements Action {
	private Storage storage;

	public LoadFromFile(Storage storage) {
		this.storage = storage;
	}

	private String load(String fileName, String format) {
		return "";
	}

	@Override
	public String doing(Map<String,String> params) {
		return this.load(params.get("fileName"), params.get("format"));
	}
}
