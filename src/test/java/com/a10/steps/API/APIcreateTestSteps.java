package com.a10.steps.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import java.util.UUID;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIcreateTestSteps {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/";
    private String requestBody;
    private Response response;
    private io.restassured.specification.RequestSpecification request;

    @Given("the request body is")
    public void theRequestBodyIs(String docString) {
        requestBody = docString;
        request = given().body(requestBody).contentType("application/json");
    }

    @Given("the header {string} is {string}")
    public void theHeaderIs(String headerName, String headerValue) {
        request.header(headerName, headerValue);
    }

    @Given("the request body with random email is")
    public void theRequestBodyWithRandomEmailIs(String docString) {
        String uniqueEmail = "user_" + UUID.randomUUID().toString() + "@examples.com";
        requestBody = docString.replace("{randomEmail}", uniqueEmail);
        request = given().body(requestBody).contentType("application/json");
    }

    @When("I make a POST request to {string}")
    public void iMakeAPostRequestTo(String endpoint) {
        response = request.post(BASE_URL + endpoint);
    }

    @Then("the status code should be {int}")
    public void theStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the response should contain {string} with value {string}")
    public void theResponseShouldContainWithValue(String key, String value) {
        response.then().body(key, equalTo(value));
    }
}
