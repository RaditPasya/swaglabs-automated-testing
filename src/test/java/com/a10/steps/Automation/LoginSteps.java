package com.a10.steps.Automation;



import com.a10.helper.A10WebDriverManager;
import com.a10.pagefactory.CartPageFactory;
import com.a10.pagefactory.DetailsPageFactory;
import com.a10.pagefactory.HomePageFactory;
import com.a10.pagefactory.LoginPageFactory;
import com.a10.pagefactory.OverviewPageFactory;
import com.a10.pagefactory.YourInfoPageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

public class LoginSteps {
    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private HomePageFactory homePage;
    private DetailsPageFactory detailsPageFactory;
    private CartPageFactory cart;
    private YourInfoPageFactory YInfo;
    private OverviewPageFactory OVW;

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        driver = A10WebDriverManager.getWebDriver();
        driver.get("https://www.saucedemo.com/");
        loginPageFactory = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);
        detailsPageFactory = new DetailsPageFactory(driver);
        cart = new CartPageFactory(driver);
        YInfo = new YourInfoPageFactory(driver);
        OVW = new OverviewPageFactory(driver);

    }

    @When("I enter my username {string} and password {string}")
    public void i_enter_my_username_and_password(String username, String password) {
        loginPageFactory.setUserName(username);
        loginPageFactory.setPassword(password);
    }

    @When("I click the login button")
    public void i_click_the_login_button() {
        loginPageFactory.clickLogin();
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @Then("I should be logged in successfully and view the menu")
    public void i_should_be_logged_in_successfully_menu() {
        String currentUrl = driver.getCurrentUrl();
        homePage.clickBurgerMenuButton();

        // Check if the menu is visible
        boolean isMenuVisible = homePage.isMenuVisible();
        Assert.assertTrue("Menu is not visible after successful login", isMenuVisible);
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @Then("I should see a message saying {string}")
    public void i_should_see_a_message_saying(String expectedMessage) {
        String actualMessage = loginPageFactory.getErrorMessage();
        Assert.assertTrue("Expected error message : '" + expectedMessage + "' not found. Found: " + actualMessage,
                actualMessage.contains(expectedMessage));
    }

    @After
    public void closeBrowser() {
        A10WebDriverManager.quitWebDriver();
    }
}