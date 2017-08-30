package com.self.learning.steps;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.json.JSONObject;

import cucumber.api.java.en.Then;

public class CaseSteps {
	static String url;

	@Then("^I execute my RestFul service$")
	public void i_execute_my_RestFul_service() throws Throwable {
		url = "http://localhost:8080/FirstRESTfulWebservice/rest/helloworld";
		System.out.println(url);

		HttpClient httpClient = new HttpClient();
		PostMethod mPost = new PostMethod(url);

		JSONObject input = new JSONObject();
		input.put("val1", "Source");
		input.put("val2", "");

		Header methodHeader = new Header();
		methodHeader.setName("content-type");
		methodHeader.setValue("application/json");
		methodHeader.setName("accept");
		methodHeader.setValue("application/json");
		RequestEntity entity = new StringRequestEntity(input.toString(), "application/json", "ISO-8859-1");
		mPost.addRequestHeader(methodHeader);
		mPost.setRequestEntity(entity);

		int statusCode = 0;
		try {
			statusCode = httpClient.executeMethod(mPost);
			System.out.println("Status Code: " + statusCode);
			if (statusCode == 200) {
				System.out.println("Web service request: " + input);
				System.out.println("Web service response: " + mPost.getResponseBodyAsString());
			} else {
				System.out.println("other error");
				System.out.println(mPost.getResponseBodyAsString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (mPost != null) {
				mPost.releaseConnection();
			}
		}
		assertTrue(statusCode == 200);
	}
}