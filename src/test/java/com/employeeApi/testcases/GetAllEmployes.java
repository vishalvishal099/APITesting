package com.employeeApi.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.employeeApi.base.TestBase;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;

public class GetAllEmployes extends TestBase {
   
	@BeforeClass
	public void getEmployee() {
		httpRequest = RestAssured.given();
		response = httpRequest.request(Method.GET, baseURI+"/employees");
		System.out.println(baseURI+"/employees");
	}
	
	@Test
	public void checkRespose() {
		String resposeBody = response.getBody().asString();
		Assert.assertTrue(resposeBody !=null);
		System.out.println(resposeBody);

		
//		//Leaning is pending need to extract data from json [1].id
//		JsonPath jsonpath = response.jsonPath();
//		 String data = jsonpath.getString("[1].id");
//	      System.out.println(data);
	
	}
	
	@Test
	public void checkStatusCode() {
		int responseCode = response.getStatusCode();
		System.out.println(responseCode);
		Assert.assertEquals(responseCode, 200);
	}
	
	@Test
	public void checkContentType() {
		Headers heaser =response.headers();
		Header contentss = heaser.get("Content-Type");
		System.out.println(contentss+ "    contentss");
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
	
	@Test
	public void checkresponseTime() {
		long responseTime = response.getTime();
		System.out.println(responseTime);
		Assert.assertTrue(responseTime < 5000);
	}
	
	@Test
	public void checkContentLength() {
		String contentLength = response.getHeader("Content-Length");
		System.out.println(contentLength + contentLength );
		//Assert.assertTrue(contentLength() >1);
		
	}
	
	@AfterClass
	public void tearDown() {
		System.out.println("Testing down!!!!!!");
	}
}
