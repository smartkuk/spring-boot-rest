package com.smartkuk.controller;

import java.util.ArrayList;
import java.util.List;

public class ExecuteRequest {
	private List<String> remoteUrls = new ArrayList<String>();

	public List<String> getRemoteUrls() {
		return remoteUrls;
	}

	public void setRemoteUrls(List<String> remoteUrls) {
		this.remoteUrls = remoteUrls;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ExecuteRequest [remoteUrls=");
		builder.append(remoteUrls);
		builder.append("]");
		return builder.toString();
	}

}
