package com.smartkuk.controller;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class HostMetrics {

	private String appName;
	private Map<String, AtomicInteger> metric;

	public HostMetrics(String appName, Map<String, AtomicInteger> metric) {
		this.appName = appName;
		this.metric = metric;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Map<String, AtomicInteger> getMetric() {
		return metric;
	}

	public void setMetric(Map<String, AtomicInteger> metric) {
		this.metric = metric;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HostMetrics [appName=");
		builder.append(appName);
		builder.append(", metric=");
		builder.append(metric);
		builder.append("]");
		return builder.toString();
	}
}
