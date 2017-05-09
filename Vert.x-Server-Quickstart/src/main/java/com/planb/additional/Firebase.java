package com.planb.additional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class Firebase {
	private static final String SERVER_KEY = "";
	private static final String API_URL = "https://fcm.googleapis.com/fcm/send";
	private static HttpClientConfig config = null;
	private static HttpClient client = null;
	
	public Firebase() {
		config = new HttpClientConfig();
		config.setTargetAddress(API_URL);
		config.setReadTimeout(10000);
		config.setConnectTimeout(10000);
		client = new HttpClient();
		
		FirebaseOptions options;
		try {
			options = new FirebaseOptions.Builder()
				  .setServiceAccount(new FileInputStream("path/to/serviceAccountCredentials.json"))
				  .setDatabaseUrl("https://databaseName.firebaseio.com/")
				  .build();
			FirebaseApp.initializeApp(options);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void send(String message, String target) {
		JSONObject body = new JSONObject();
		body.put("body", message);
		
		JSONObject requestObject = new JSONObject();
		requestObject.put("notification", body);
		requestObject.put("to", target);
		
		Map<String, Object> headers = new HashMap<String, Object>();
		headers.put("Authorization", "key=" + SERVER_KEY);
		headers.put("Content-Type", "application/json");
		
		client.post("/", headers, requestObject);
	}
	
	public static void sendByTopic() {
		
	}
}
