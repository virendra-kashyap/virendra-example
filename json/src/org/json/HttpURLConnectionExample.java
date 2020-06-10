package org.json;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class HttpURLConnectionExample {
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String POST_PARAMS = "5eda1eacf9695400173d9002";

	private static void sendGet() throws Exception {
		String url = "https://jsonbox.io/box_e08730ae0ba32768e2a5";
		HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
		connection.setRequestMethod("GET");
		connection.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = connection.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
				response.append(inputLine);
			}
			reader.close();
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}
	}

	private static void sendAdd() throws Exception {
		URL url = new URL("https://jsonbox.io/box_e08730ae0ba32768e2a5");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();

		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		JSONObject obj = new JSONObject();
		obj.put("name", "dainy");
		obj.put("age", new Integer(27));
		obj.put("salary", new Double(5000));
		System.out.println(obj);

		OutputStream os = conn.getOutputStream();
		os.write(obj.toString().getBytes());
		os.flush();
		int responseCode = conn.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer buffer = new StringBuffer();
			while ((inputLine = reader.readLine()) != null) {
				buffer.append(inputLine);
			}
			reader.close();
			System.out.println(buffer.toString());
		} else {
			System.out.println("POST Request Not Work");
		}
	}
	
	private static void delete() throws Exception {
		String url = "https://jsonbox.io/box_e08730ae0ba32768e2a5";
		HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
		
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setDoOutput(true);
	
		
	}

	public static void main(String[] args) {
		try {
			HttpURLConnectionExample.sendGet();
			// HttpURLConnectionExample.sendAdd();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}