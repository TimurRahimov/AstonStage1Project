package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.storage.Storage;

public class LoadFromFile implements Action {
	private Storage stor;

	public LoadFromFile(Storage stor) {
		this.stor = stor;
	}

	private String load(String fileName, String format) {
		return "";
	}

	@Override
	public String doing(Map<String,String> params) {
		return this.load(params.get("fileName"), params.get("format"));
	}
}
