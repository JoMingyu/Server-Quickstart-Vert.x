package com.planb.additional;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

public class NetworkingHelper {
	private static String validateUri(Config config, String uri) {
		if(config.getTargetAddress().endsWith("/") && uri.startsWith("/")) {
			// Escape double slash
			uri = uri.substring(1, uri.length());
		} else if(!config.getTargetAddress().endsWith("/") && !uri.startsWith("/")) {
			// Escape no slash
			uri = "/" + uri;
		}
		// ������ URI ����
		
		if(uri.endsWith("/")) {
			// Escape end with slash
			uri = uri.substring(0, uri.length() - 1);
		}
		
		if(config.getTargetPort() == 80) {
			return config.getTargetAddress() + uri;
		} else {
			return config.getTargetAddress() + ":" + config.getTargetPort() + uri;
		}
	}
	
	static String createRequestAddress(Config config, String uri) {
		// POST ��û �Ǵ� �Ķ���Ͱ� ���� GET ��û������ request address
		
		return validateUri(config, uri);
	}
	
	static String createRequestAddress(Config config, String uri, Map<String, Object> params) {
		/*
		 * �Ķ���Ͱ� �ִ� GET ��û������ request address
		 * URI?key=value&key=value ����
		 */
		
		StringBuilder requestAddress = new StringBuilder();
		requestAddress.append(validateUri(config, uri)).append("?");
		for(String key : params.keySet()) {
			String value = (String) params.get(key);
			try {
				requestAddress.append(key).append("=").append(URLEncoder.encode(value, "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		String requestAddressStr = requestAddress.toString();
		requestAddressStr = requestAddressStr.substring(0, requestAddressStr.length() - 1);
		return requestAddressStr;
	}
	
	static byte[] createParamBytes(Map<String, Object> params) {
		// POST �޼ҵ忡�� ����ϴ� byte Ÿ���� body ������
		StringBuilder requestData = new StringBuilder();
		
		for(String key : params.keySet()) {
			String value = String.valueOf(params.get(key));
			try {
				requestData.append(key).append("=").append(URLEncoder.encode(value, "UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		
		String requestAddressStr = requestData.toString();
		requestAddressStr = requestAddressStr.substring(0, requestAddressStr.length() - 1);
		return requestAddressStr.getBytes();
	}
	
	static String getResponse(InputStream in) {
		if(in == null) {
			return null;
		}
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		
		byte[] buf = new byte[1024 * 16];
		int length;
		try {
			while((length = in.read(buf)) != -1) {
				out.write(buf, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			return new String(out.toByteArray(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
