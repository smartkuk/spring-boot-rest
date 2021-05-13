package com.smartkuk.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class HostInformation {

	private String address = "";
	private String hostname;

	public HostInformation() {
		try {
			InetAddress localhost = InetAddress.getLocalHost();
			address = localhost.getHostAddress();
			hostname = localhost.getHostName();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public HostInformation(String address, String hostname) {
		this.address = address;
		this.hostname = hostname;
	}

	public String getAddress() {
		return address;
	}

	public String getHostname() {
		return hostname;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HostInformation [address=");
		builder.append(address);
		builder.append(", hostname=");
		builder.append(hostname);
		builder.append("]");
		return builder.toString();
	}
}
