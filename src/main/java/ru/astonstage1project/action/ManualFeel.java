package ru.astonstage1project.action;

import java.util.Map;

import ru.astonstage1project.storage.Storage;

public class ManualFeel implements Action {
	private Storage stor;

	public ManualFeel(Storage stor) {
		this.stor = stor;
	}

	private String load(Map<String,String> params) {
		return "";
	}

	@Override
	public String doing(Map<String,String> params) {
		return this.load(params);
	}
}
