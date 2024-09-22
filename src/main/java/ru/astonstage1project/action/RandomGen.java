package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.storage.Storage;

public class RandomGen implements Action {
	private Storage stor;

	public RandomGen(Storage stor) {
		this.stor = stor;
	}

	private String generate(String type, String count) {
		return "";
	}

	@Override
	public String doing(Map<String,String> params) {
		return this.generate(params.get("type"), params.get("count"));
	}
}
