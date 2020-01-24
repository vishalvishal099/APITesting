package com.employeeApi.base;

import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestBase {
	
	public static RequestSpecification httpRequest;
	public static Response response;
	public static String baseURI="http://dummy.restapiexample.com/api/v1";
	public static String empId="1"; 
	
   public static String getBody() {
	   return "";
   }

	
	@BeforeClass
	public void setUp() {
		
	}

}
