package com.planb.additional;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class Firebase {
	private static final String SERVER_KEY = "AAAAhndBTOE:APA91bENhBImmt3bwwPvNYMcCanS5bl55zQ9W3-rpVJiCwPhSssuUyBWcbqL4FstfU8hhlMSmXS4qixQtaClDcT_0RJ5dh2q2pAVjM0pk8P8SyRPi0gC3xlRZbFXmpRE_FvaP4LjTizD";

	public Firebase() {
		
	}
	
	public static void send(String title, String body, String registrationId) {
		// Send by registration id
		HttpClient client = new HttpClient("https://fcm.googleapis.com/fcm/send");

		JSONObject noti = new JSONObject();
		noti.put("title", title);
		noti.put("body", body);

		JSONObject requestObject = new JSONObject();
		requestObject.put("notification", noti);
		requestObject.put("to", registrationId);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Authorization", "key=" + SERVER_KEY);
		headers.put("Content-Type", "application/json");

		client.post("/", headers, requestObject);
	}

	public static void sendByTopic(String title, String body, String topicName) {
		// Send by registration id
		HttpClient client = new HttpClient("https://fcm.googleapis.com/fcm/send");

		JSONObject noti = new JSONObject();
		noti.put("title", title);
		noti.put("body", body);

		JSONObject requestObject = new JSONObject();
		requestObject.put("notification", noti);
		requestObject.put("to", "/topics/" + topicName);

		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Authorization", "key=" + SERVER_KEY);
		headers.put("Content-Type", "application/json");

		client.post("/", headers, requestObject);
	}

	public static void sendToGroup() {
		// 아마도 클라이언트에서 처리
	}
	// sendByNotificationKey
}