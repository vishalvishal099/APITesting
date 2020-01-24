package com.apiTesting.APITestng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataProviderTC {
	
	@Test(dataProvider="dataFormExcel")
	public void verifyMultipleEmpCreation(String name, String salary, String age) {
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification request = RestAssured.given();
		JSONObject parameter = new JSONObject();
		
		parameter.put("name", name);
		parameter.put("salary", salary);
		parameter.put("age",age);

		
		request.header("content-type","application/json");
		request.body(parameter.toString());
		
		Response response = request.request(Method.POST, "/create");
		String responseBody = response.getBody().asString();
		
		Assert.assertEquals(response.getStatusCode(), 200); 
		Assert.assertTrue(responseBody.contains(name)); 
		Assert.assertTrue(responseBody.contains(salary)); 
		Assert.assertTrue(responseBody.contains(age)); 



	}
	  @DataProvider(name="userdata")
	  String [] [] testData() {
		String [][] userData = { { "usr_1","12345","23"},{"usr_2","123345","23"},
				{"usr_3","123445363","23"} };
		return userData;
		}
	  
	  @DataProvider(name="dataFormExcel")
	  public Iterator<Object []> getExcelData() throws IOException {
		  ArrayList<Object[]> al = ExcelUtility.excelData();
		  return al.iterator();
	  }
	}


