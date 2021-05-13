package com.smartkuk.controller;

import java.util.HashMap;
import java.util.Map;

public class ExecutedResponse {
	private Map<String, String> responseMap = new HashMap<String, String>();

	public void addResponse(String url, String res) {
		responseMap.put(url, res);
	}

	public Map<String, String> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, String> responseMap) {
		this.responseMap = responseMap;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExecutedResponse [responseMap=");
		builder.append(responseMap);
		builder.append("]");
		return builder.toString();
	}

}
