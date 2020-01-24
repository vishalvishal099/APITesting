package com.employeeApi.testcases;

import org.apache.http.HttpRequest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;

public class PostCreateEmployee extends TestBase {
	
	@BeforeClass
    public void createEmployee() {
		httpRequest = RestAssured.given();
		httpRequest.auth().basic("","");
		httpRequest.given().pathParam("", "parameterValue");
		
		httpRequest.header("content-type","application/json");
		JSONObject bodyAdded = new JSONObject();
		bodyAdded.put("name", "data_emp1");
		bodyAdded.put("salary","213");
		bodyAdded.put("age","23");
		
		httpRequest.body(bodyAdded.toJSONString());
		
		response = httpRequest.request(Method.POST, baseURI+"/create");	
	}
	
	@Test
	public void checkStatusCode() {
		int responseCode = response.getStatusCode();
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200);
	}
	
	@Test
	public void checkBodyData() {
		String bodyData = response.getBody().asString();
		System.out.println(bodyData);
		Assert.assertEquals(bodyData.contains("data_emp1"), true);
	}

	@Test
	public void checkContentType() {
		Headers heaser = response.headers();
		Header contentss = heaser.get("Content-Type");
		System.out.println(contentss + "    contentss");
		String contentType = response.getHeader("Content-Type");
		System.out.println(contentType);
		Assert.assertEquals(contentType, "text/html; charset=UTF-8");
	}

	@Test
	public void checkServr() {

		String server = response.getHeader("Server");
		System.out.println(server);
		Assert.assertEquals(server, "nginx/1.16.0");
	}



	@AfterClass
	public void tearDown() {
		System.out.println("Testing down!!!!!!");
	}


}
