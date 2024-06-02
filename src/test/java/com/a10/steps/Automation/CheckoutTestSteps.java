package com.a10.steps.Automation;



import com.a10.helper.A10WebDriverManager;
import com.a10.pagefactory.CartPageFactory;
import com.a10.pagefactory.DetailsPageFactory;
import com.a10.pagefactory.HomePageFactory;
import com.a10.pagefactory.LoginPageFactory;
import com.a10.pagefactory.OverviewPageFactory;
import com.a10.pagefactory.YourInfoPageFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;

public class CheckoutTestSteps {

    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private HomePageFactory homePage;
    private DetailsPageFactory detailsPageFactory;
    private CartPageFactory cart;
    private YourInfoPageFactory YInfo;
    private OverviewPageFactory OVW;

    public CheckoutTestSteps() {
        driver = A10WebDriverManager.getWebDriver();
        loginPageFactory = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);
        detailsPageFactory = new DetailsPageFactory(driver);
        cart = new CartPageFactory(driver);
        YInfo = new YourInfoPageFactory(driver);
        OVW = new OverviewPageFactory(driver);
    }

    @Then("the button should be grey and error message {string} shows up")
    public void i_should_see_a_button_and_message_saying(String expectedMessage) {
        

        boolean buttonAvailability = YInfo.isContinueButtonClickable();
        assertFalse(buttonAvailability);

        YInfo.clickContinue();

        if (!buttonAvailability) {
            String actualMessage = YInfo.getErrorMessageText();
            assertTrue(actualMessage.contains(expectedMessage));
        }
        
        
    }

    @Then("shows up error message {string}")
    public void i_should_see_a_message_saying(String expectedMessage) {

        YInfo.clickContinue();
        String actualMessage = YInfo.getErrorMessageText();
        System.out.println("Actual Error Message: " + actualMessage);
        assertTrue(actualMessage.contains(expectedMessage));
    }

    
}
