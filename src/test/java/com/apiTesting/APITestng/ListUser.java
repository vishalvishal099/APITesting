package com.apiTesting.APITestng;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.sun.xml.xsom.impl.scd.Iterators.Map;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ListUser {
	
	@Test
	public void listUser() throws JsonParseException, JsonMappingException, IOException {
		RestAssured.baseURI="https://reqres.in/api/users?page=2";
		RequestSpecification request = RestAssured.given(); 
		Response response = request.get();
		
		String responsebody =response.getBody().asString();
		
	      JsonPath jsonpath = response.jsonPath();
	      ObjectMapper mapper = new ObjectMapper();
	      
	      String data = jsonpath.getString("data");
	      System.out.println(data);
	      
	      HashMap<String,Object> result = new ObjectMapper().readValue(data, HashMap.class);
         // Map<String, String> map = mapper.readValue(responsebody, new TypeReference<Map<String, String>>() {});

	      System.out.println(result);
	      System.out.println(jsonpath.get("data"));
	        for (Entry<String, Object> entry : result.entrySet()) {
	        	System.out.println("Key = " + entry.getKey() + 
                        ", Value = " + entry.getValue());
	        	
	        }
	    
	}
	
	
	

}
