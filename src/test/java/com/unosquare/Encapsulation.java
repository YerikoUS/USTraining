package com.unosquare;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import java.io.IOException;
import java.text.ParseException;

import org.testng.Assert;
import org.testng.annotations.BeforeSuite;

public class Encapsulation {
  @Test
  public void PostLogin() throws IOException, ParseException{
	  
	  Response test = apiCore.PostLogin ("src/test/java/json/Register.json", "/login");
	  Assert.assertEquals(200, test.statusCode());
  }
  @BeforeSuite
  public void beforeSuite() {
	  ApiCore apiCore = new ApiCore();
  }

}
