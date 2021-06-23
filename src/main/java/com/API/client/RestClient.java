package com.API.client;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	
	//create GET method
	public CloseableHttpResponse get(String url) throws ClientProtocolException, IOException {
		
		CloseableHttpClient htttpClient = HttpClients.createDefault();
		HttpGet httpget= new HttpGet(url);    // http get request
		CloseableHttpResponse httpResponse = htttpClient.execute(httpget);   //actual execution/sending of get request
		
		return httpResponse;
		
	}

}
