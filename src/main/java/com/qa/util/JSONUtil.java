package com.qa.util;

import com.google.gson.Gson;

public class JSONUtil {

	private Gson gson;

	public JSONUtil() {
		this.gson = new Gson();
	}

	public String convertObjectToJSON(Object obj) {
		return gson.toJson(obj);
	}

	public <T> T convertJSONToObject(String jsonString, Class<T> object) {
		return gson.fromJson(jsonString, object);
	}

}