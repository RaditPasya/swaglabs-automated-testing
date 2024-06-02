package com.a10.steps.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIputTestSteps {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/user/";
    private Response response;
    private String requestBody;
    private io.restassured.specification.RequestSpecification request;

    @Given("the PUT request body is")
    public void thePUTRequestBodyIs(String docString) {
        requestBody = docString;
    }

    @Given("the PUT header {string} is {string}")
    public void thePUTHeaderIs(String headerName, String headerValue) {
        request = given().header(headerName, headerValue);
    }

    @When("I make a PUT request to {string}")
    public void iMakeAPUTRequestTo(String endpoint) {
        response = request
                .body(requestBody)
                .contentType("application/json")
                .put(BASE_URL + endpoint);
    }

    @Then("the PUT status code should be {int}")
    public void thePUTStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the PUT response should contain {string} with value {string}")
    public void thePUTResponseShouldContainWithValue(String key, String value) {
        response.then().body(key, equalTo(value));
    }
}
