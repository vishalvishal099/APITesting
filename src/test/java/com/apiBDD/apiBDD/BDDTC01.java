package com.apiBDD.apiBDD;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

/*
 * given(): Set cookies, set headers, add param , add auth etc
 * when(): get(), post(), put(),delete()
 * then(): validate status code 
 *          extract response
 *          extract headers, cookies, and response body
 */

public class BDDTC01 {
	
	@Test
	public void testWheather() {
		given()
	   .when()
		    .get("http://restapi.demoqa.com/utilities/weather/city/Mirzapur")
             .then()
		     .statusCode(200)
	         .statusLine("HTTP/1.1 200 OK")
    	     .assertThat().body("City", equalTo("Mirzapur"))
	         .header("Content-Type", "application/json");
		     
		   
	}

}
