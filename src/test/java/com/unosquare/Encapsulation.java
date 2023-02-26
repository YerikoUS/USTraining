package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class Encapsulation {
	ApiCore apiCore;
  @Test
  public void PostLogin() throws IOException, ParseException, org.json.simple.parser.ParseException{
	  
	  Response test = apiCore.PostLogin ("src/test/java/json/Register.json", "/login");
	  Assert.assertEquals(200, test.statusCode());
  }
  
  @Test
  public void Gets() throws IOException, org.json.simple.parser.ParseException {
	  for (int n = 1; n <= 4; n++) {
		  Response r1 = apiCore.GetMethod("/users/"+n);
		  Assert.assertEquals(200, r1.statusCode());
	  }
 }
  
  @Test
  public void Posts() throws IOException, org.json.simple.parser.ParseException {
	  for (int n = 1; n <= 4; n++) {
		  Response r1 = apiCore.PostMethod("src/test/java/json/newUser"+n+".json" ,"/api/users");
		  Assert.assertEquals(201, r1.statusCode());
	  }
}
  
  @Test
  public void Puts() throws IOException, org.json.simple.parser.ParseException {

		  Response r1 = apiCore.PutMethod("src/test/java/json/putUser.json" ,"/api/users/2");
		  Assert.assertEquals(200, r1.statusCode());
	  
}
  
  @BeforeSuite
  public void beforeSuite() {
	   apiCore = new ApiCore();
  }

}