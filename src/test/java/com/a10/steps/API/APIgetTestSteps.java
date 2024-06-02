package com.a10.steps.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIgetTestSteps {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/user/";
    private Response response;
    private io.restassured.specification.RequestSpecification request;

    @Given("the GET header {string} is {string}")
    public void theGETHeaderIs(String headerName, String headerValue) {
        request = given().header(headerName, headerValue);
    }

    @When("I make a GET request to {string}")
    public void iMakeAGetRequestTo(String endpoint) {
        
        response = request.get(BASE_URL + endpoint);
    }

    @Then("the GET status code should be {int}")
    public void theGETStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the GET response should contain {string} with value {string}")
    public void theGETResponseShouldContainWithValue(String key, String value) {
        response.then().body(key, equalTo(value));
    }
}
