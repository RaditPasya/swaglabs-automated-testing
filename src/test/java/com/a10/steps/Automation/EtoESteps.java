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

public class EtoESteps{

    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private HomePageFactory homePage;
    private DetailsPageFactory detailsPageFactory;
    private CartPageFactory cart;
    private YourInfoPageFactory YInfo;
    private OverviewPageFactory OVW;

    public EtoESteps() {
        driver = A10WebDriverManager.getWebDriver();
        loginPageFactory = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);
        detailsPageFactory = new DetailsPageFactory(driver);
        cart = new CartPageFactory(driver);
        YInfo = new YourInfoPageFactory(driver);
        OVW = new OverviewPageFactory(driver);
    }


    @When("I click the sauce labs backpack")
    public void i_click_the_backpack_button() {
        homePage.clickBackpack();
    }

    @When("I click the add to cart button")
    public void click_add_to_cart() {
        detailsPageFactory.clickaddtocartbutton();;
    }
    
    @When("I go back to products")
    public void go_back_to_products() {
        detailsPageFactory.clickbackproduct();;
    }

    @When("i go to cart")
    public void go_to_cart() {
        homePage.clickcart();;
    }

    @When("i checkout")
    public void checkout_click() {
        cart.clickCheckout();
    }

    @When("i continued")
    public void click_continue() {
        YInfo.clickContinue();
    }

    

    @When("I enter my firstname {string} and lastname {string} and zipcode {string}")
    public void enter_information(String firstName, String lastname, String zipcode) {
        YInfo.serFirstname(firstName);
        YInfo.setLastname(lastname);
        YInfo.setZipcode(zipcode);
    }
    @When("i finished the transaction")
    public void click_finish_transaction() {
        OVW.clickFinish();
    }

    @When("i should be finished")
    public void should_be_finished() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("https://www.saucedemo.com/checkout-complete.html", currentUrl);
    }

   
    
    
    
   

    
}
