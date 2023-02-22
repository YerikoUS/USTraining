package com.unosquare;

import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.*;
public class FirstAPITest {
  @Test
  public void f() {
	  RestAssured.baseURI = "https://reqres.in/api/";
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get("/users/2");
		
		int statusCode = response.getStatusCode();

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode,200);
		Reporter.log("Sucess 200 validation");
		System.out.println(response.prettyPrint());
		
		////Assert First Name and Last Name
		String result = given()//.log().all()
		.when().get("https://reqres.in/api/users/2")
		.then().statusCode(200).body("data.first_name", equalTo("Janet"))
		.body("data.last_name", equalTo("Weaver"))
		.extract().response().asString();
		
		//System.out.println(result);
		
		
		//JsonPath js = new JsonPath(response);
		//String placeId = js.getString("place_id");
		
		////
  }
  @BeforeMethod
  public void beforeMethod() {
  }

}
