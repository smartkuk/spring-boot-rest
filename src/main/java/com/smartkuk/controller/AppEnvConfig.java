package com.smartkuk.controller;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("app")
public class AppEnvConfig {
	private String name;

	public AppEnvConfig() {

	}

	public AppEnvConfig(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AppEnvConfig [name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
}
