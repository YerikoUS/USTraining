package com.unosquare;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.FileReader;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.io.IOException;

public class ApiCore {

	
	Response PostLogin(String data, String endPoint) throws IOException, ParseException {
		 Object respuesta = Parseador.Parsea(data);

		  
		  RestAssured.baseURI = "https://reqres.in/api/";
		  
			Response result = given().log().all()
					.contentType("application/json")
					.body(respuesta.toString())
				.when()
					.post(endPoint)
				.then()
					//.statusCode(200)
				.extract().response();
		
		
		return result;		
	}
	
	Response GetMethod(String endPoint) throws IOException, ParseException {
		RestAssured.baseURI = "https://reqres.in/api/";
		
		Response result = given()
		.when()
			.get(endPoint)
		.then()//.statusCode(200)
		.extract().response();
		return result;
		}
	
	Response PostMethod(String data ,String endPoint) throws IOException, ParseException {
		  RestAssured.baseURI = "https://reqres.in/api/";

		Object respuesta = Parseador.Parsea(data);
		Response result = given().log().all()
				.contentType("application/json")
				.body(respuesta.toString())
			.when()
				.post(endPoint)
			.then()
				//.statusCode(201)
			.extract().response();
		
		return result;
	}
	
	Response PutMethod(String data, String endPoint)throws IOException, ParseException {
		  RestAssured.baseURI = "https://reqres.in/api/";
		  
			Object respuesta = Parseador.Parsea(data);
			Response result = given().log().all()
					.contentType("application/json")
					.body(respuesta.toString())
				.when()
					.put(endPoint)
				.then()
					//.statusCode(201)
				.extract().response();
			
			return result;

	
	}

	
	
}
