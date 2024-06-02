package com.a10.steps.Automation;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.a10.helper.A10WebDriverManager;
import com.a10.pagefactory.HomePageFactory;
import com.a10.pagefactory.LoginPageFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

public class LogoutSteps {
    private WebDriver driver;
    private LoginPageFactory loginPage;
    private HomePageFactory homePage;

    @Given("the user is logged in and on the dashboard page with {string} username and {string} password")
    public void the_user_is_logged_in_and_on_the_dashboard_page(String username, String password) {
        driver = A10WebDriverManager.getWebDriver();
        loginPage = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);

        driver.get("https://www.saucedemo.com/");
        loginPage.login(username, password);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
    }

    @When("they press the logout button")
    public void they_press_the_logout_button() {
        homePage.clickBurgerMenuButton();
        homePage.clickLogoutLink();
    }

    @Then("they should be navigated back to the login page")
    public void they_should_be_navigated_back_to_the_login_page() {
        Assert.assertTrue("Not navigated to login page", driver.getCurrentUrl().contains("www.saucedemo.com"));
    }

    @After
    public void closeBrowser() {
        A10WebDriverManager.quitWebDriver();
    }
}
