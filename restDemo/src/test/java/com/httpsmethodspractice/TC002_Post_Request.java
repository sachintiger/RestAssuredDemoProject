package com.httpsmethodspractice;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC002_Post_Request {
	
	public void registration_Successful()
	{
		//Specify base URI
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		//Request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request payload along with post request
		JSONObject requestParam = new JSONObject();
		
		requestParam.put("FirstName", "Sumit");
		requestParam.put("LastName", "Chute");
		requestParam.put("UserName", "Sum@2108");
		requestParam.put("Password", "Test@123");
		requestParam.put("Email", "sumitchute1@gmail.com");
		
		//Add header
		httpRequest.header("content-Type","application/json");
		
		//convert payload into json format
		httpRequest.body(requestParam.toJSONString());  //attach data to the request
		
		//Send Request to the database (response object)
		Response response=httpRequest.request(Method.POST,"/register");
		
		//Print response in the console window
		 
		String responseBody = response.getBody().asString();
		System.out.println("Response body is :- " + responseBody);
		
		//Status code validation
		 int statusCode = response.getStatusCode();
		 System.out.println("Status code is :- "+ statusCode);
		 Assert.assertEquals(statusCode, 201);
		 
		 //success code validation
		 String successCode=response.jsonPath().get("SuccessCode");
		 Assert.assertEquals(successCode, "OPERATION_SUCCESS");
	}

}
