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

public class HomepageTestingSteps {

    private WebDriver driver;
    private LoginPageFactory loginPageFactory;
    private HomePageFactory homePage;
    private DetailsPageFactory detailsPageFactory;
    private CartPageFactory cart;
    private YourInfoPageFactory YInfo;
    private OverviewPageFactory OVW;

    public HomepageTestingSteps() {
        driver = A10WebDriverManager.getWebDriver();
        loginPageFactory = new LoginPageFactory(driver);
        homePage = new HomePageFactory(driver);
        detailsPageFactory = new DetailsPageFactory(driver);
        cart = new CartPageFactory(driver);
        YInfo = new YourInfoPageFactory(driver);
        OVW = new OverviewPageFactory(driver);
    }

    @When("I add 6 items")
    public void add_six_items() {
        homePage.add6items();
    }

    @When("I look at the badge")
    public void look_at_badge() {

        boolean look = homePage.isShoppingCartBadgeValueEqualToSix();
        Assert.assertTrue("see if there's 6 items", look);
    }

    @When("I remove all items")
    public void removeAll() {

        homePage.clickAllRemoveButtons();
    }
    
    @When("the badge is gone")
    public void badgeisGone() {

        boolean isBadgePresent = homePage.isShoppingCartBadgePresent();
        Assert.assertTrue("Shopping cart badge is not present", isBadgePresent);
    }

    @When("the badge is gone SIKE")
    public void badgeisGonehehe() {

        boolean isBadgePresent = homePage.isShoppingCartBadgePresent();
        Assert.assertFalse("Shopping cart badge is not present", isBadgePresent);
    }

    @When("I sorted it")
    public void SortHilo() {

        homePage.selectPriceHighToLow();
    }
    
    @When("i checked the sort")
    public void checkSort() {

        boolean isSorted = homePage.isPriceListSorted();
        Assert.assertTrue("Price is not sorted", isSorted);
    }

    
    
}
