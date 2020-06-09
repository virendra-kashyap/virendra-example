package com.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;

public class EmployeeService {
	URL url = null;
	private static final String USER_AGENT = "Mozilla/5.0";

	public EmployeeService() throws Exception {
		url = new URL("https://jsonbox.io/box_e08730ae0ba32768e2a5");
	}

	public void add(JSONObject requestBody) throws Exception {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setDoOutput(true);
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");

		OutputStream os = conn.getOutputStream();
		os.write(requestBody.toString().getBytes());
		os.flush();
		os.close();
		int responseCode = conn.getResponseCode();
		System.out.println("POST Response Code :: " + responseCode);

	}

	public void get() throws Exception {
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setDoOutput(true);
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		int responseCode = conn.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
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

	public void delete(String id) throws Exception {
		URL deleteURL = new URL("https://jsonbox.io/box_e08730ae0ba32768e2a5/"+id);
		HttpURLConnection conn = (HttpURLConnection) deleteURL.openConnection();
		conn.setRequestProperty("User-Agent", USER_AGENT);
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestMethod("DELETE");
		int responseCode = conn.getResponseCode();
		System.out.println("Response Code : " + responseCode);
	}
}
