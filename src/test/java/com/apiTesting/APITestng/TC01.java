package com.apiTesting.APITestng;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC01 {
	
	@Test
	public void cityWhether() {
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";
		RequestSpecification httpRequest =RestAssured.given();
		Response respose = httpRequest.request(Method.GET,"Mirzapur");
		
		String responsebody = respose.getBody().asString();
		System.out.println(responsebody);
		
		int resposeCode = respose.getStatusCode();
		Assert.assertEquals(resposeCode, 200);
		
		JsonPath jsonPath = respose.jsonPath();
		System.out.println(jsonPath.get("Temperature"));
		
	}

}
