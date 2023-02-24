package com.unosquare;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
//

import io.restassured.RestAssured;

public class FirstPut {

	  @Test
	  public void f() {
		  RestAssured.baseURI = "https://reqres.in/api/";
  	
  	String requestBody = "{\"name\" : \"JohnAPI\", \"job\" : \"QA\"}";
  	
  	String result = given().log().all()
  		.contentType("application/json")
  		.body(requestBody)
  	.when()
  		.put("/users/2")
  	.then()
  		.statusCode(200)
  	.extract().response().asString();
  	
  	System.out.println(result);
	  }
	

}
