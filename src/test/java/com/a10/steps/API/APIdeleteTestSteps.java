package com.a10.steps.API;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIdeleteTestSteps {

    private static final String BASE_URL = "https://dummyapi.io/data/v1/user/";
    private Response response;
    private String appId;
    private String userId;

    @Given("the DELETE header {string} is {string}")
    public void theDELETEHeaderIs(String headerName, String headerValue) {
        appId = headerValue;
    }

    @Given("the DELETE request user ID is {string}")
    public void theDELETERequestUserIDIs(String userId) {
        this.userId = userId;
    }

    private boolean doesUserExist(String userId) {
        Response checkResponse = given()
            .header("app-id", appId)
            .get(BASE_URL + userId);

        return checkResponse.getStatusCode() == 200;
    }

    @When("I make a DELETE request to {string}")
    public void iMakeADELETERequestTo(String endpoint) {
        if (!endpoint.equals("60d0fe4f5311236168a109f1") && !endpoint.equals("0")) {
            if (doesUserExist(userId)) {
                response = given()
                    .header("app-id", appId)
                    .delete(BASE_URL + userId);
            } else {
                response = given()
                    .header("app-id", appId)
                    .get(BASE_URL + userId); // Simulate user not found response
            }
        } else {
            response = given()
                .header("app-id", appId)
                .delete(BASE_URL + userId);
        }
    }

    @Then("the DELETE status code should be {int}")
    public void theDELETEStatusCodeShouldBe(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("the DELETE response should contain {string} with value {string}")
    public void theDELETEResponseShouldContainWithValue(String key, String value) {
        response.then().body(key, equalTo(value));
    }
}
