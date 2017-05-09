package com.planb.additional;

public class HttpClientConfig {
	private static String targetAddress = null;
	private static int targetPort = 80;

	private static int readTimeout = 3000;
	private static int connectTimeout = 3000;

	void setTargetAddress(String address) {
		HttpClientConfig.targetAddress = address;
	}

	String getTargetAddress() {
		return targetAddress;
	}

	void setTargetPort(int port) {
		HttpClientConfig.targetPort = port;
	}

	int getTargetPort() {
		return targetPort;
	}

	void setReadTimeout(int readTimeout) {
		HttpClientConfig.readTimeout = readTimeout;
	}

	int getReadTimeout() {
		return readTimeout;
	}

	void setConnectTimeout(int connectTimeout) {
		HttpClientConfig.connectTimeout = connectTimeout;
	}

	int getConnectTimeout() {
		return connectTimeout;
	}
}