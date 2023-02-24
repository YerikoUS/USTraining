package com.unosquare;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class FirstPostClass {
  @Test
  public void f() throws IOException, ParseException {
	  RestAssured.baseURI = "https://reqres.in/api/";
		
	  //First Post
	  JSONParser json = new JSONParser();
	  FileReader reader = new FileReader("src/test/java/json/user13.json");
	  Object obj = json.parse(reader);
	
	  //System.out.println(obj);
	  
	String result = given().log().all()
		.contentType("application/json")
		.body(obj.toString())
	.when()
		.put("/users/2")
	.then()
		.statusCode(200)
	.extract().response().asString();
	
	  //Second Post
	  reader = new FileReader("src/test/java/json/user14.json");
	  obj = json.parse(reader);
	
	  //System.out.println(obj);
	  
	result = given().log().all()
		.contentType("application/json")
		.body(obj.toString())
	.when()
		.put("/users/2")
	.then()
		.statusCode(200)
	.extract().response().asString();
  }
  
}
