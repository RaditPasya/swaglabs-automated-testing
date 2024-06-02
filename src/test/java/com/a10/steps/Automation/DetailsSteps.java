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

public class DetailsSteps {

    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private HomePageFactory homePage;
    private DetailsPageFactory detailsPageFactory;
    private CartPageFactory cart;
    private YourInfoPageFactory YInfo;
    private OverviewPageFactory OVW;

    public DetailsSteps() {
        driver = A10WebDriverManager.getWebDriver();
        loginPageFactory = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);
        detailsPageFactory = new DetailsPageFactory(driver);
        cart = new CartPageFactory(driver);
        YInfo = new YourInfoPageFactory(driver);
        OVW = new OverviewPageFactory(driver);
    }
    
    @When("I click the backpack photo")
    public void clickphoto() {
        homePage.clickbackpackPhoto();
    }
    @When("I look at the badge after backpack")
    public void checkBadgeinDetails() {
        boolean look = detailsPageFactory.checkBadgeV2();
        Assert.assertTrue("see if there's 6 items", look);
    }
    @When("i remove it dawg")
    public void removeClick() {
        detailsPageFactory.begoneProduct();
    }

    
    
}
