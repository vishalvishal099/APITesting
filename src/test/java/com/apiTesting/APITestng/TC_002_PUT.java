package com.apiTesting.APITestng;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_002_PUT {
	
	@Test
	public void registeUser() {
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer/register";
		
		RequestSpecification request = RestAssured.given();
		
		JSONObject requestParam = new JSONObject();
		requestParam.put("FirstName", "Test_Data2");
		requestParam.put("LastName", "Test_Data2");
		requestParam.put("UserName", "Test_Data2");
		requestParam.put("Password", "Test_Data2");
		requestParam.put("Email", "Test_Data2");
		
		//System.out.println(((JSONObject) request).toJSONString());
		
		request.header("content-type","application/json");
		request.body(requestParam.toJSONString());
		
		Response response = request.post();
		
		System.out.println(response.getBody().asString());
		//resepose body for allready exist users
		
		System.out.println("Body contans");
		Assert.assertTrue(response.getBody().asString().contains("User already exists"));
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 201);
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS");
		Assert.assertEquals(successCode, "OPERATION_SUCCESS", "Correct Success code was returned");
		
		Headers allheaders = response.getHeaders();
		for(Header header: allheaders) {
			
			System.out.println(" key  " +header.getName() +"          value "+header.getValue());
		}


	}

}
