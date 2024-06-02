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

public class CartTestSteps {

    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private HomePageFactory homePage;
    private DetailsPageFactory detailsPageFactory;
    private CartPageFactory cart;
    private YourInfoPageFactory YInfo;
    private OverviewPageFactory OVW;

    public CartTestSteps() {
        driver = A10WebDriverManager.getWebDriver();
        loginPageFactory = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);
        detailsPageFactory = new DetailsPageFactory(driver);
        cart = new CartPageFactory(driver);
        YInfo = new YourInfoPageFactory(driver);
        OVW = new OverviewPageFactory(driver);
    }

    
    @When("I continue shopping")
    public void should_be_finished() {

        cart.clickContinueShopping();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", currentUrl);
    }

    @When("i check if i really got that dawg in me")
    public void IYKYK() {

        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-step-one.html", currentUrl);
    }

    @When("i check if i really dont got that dawg in me")
    public void IYKYK2() {

        boolean ong = cart.isMessageDisplayedAfterButtonClick();

        assertTrue("It dont gotta show up dawg",ong);

    }
    
    
}
