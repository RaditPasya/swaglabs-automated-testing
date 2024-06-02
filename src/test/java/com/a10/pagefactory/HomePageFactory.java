package com.a10.pagefactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HomePageFactory {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutLink;

    @FindBy(className = "bm-menu-wrap")
    private WebElement menuWrap;

    @FindBy(xpath = "//a[@id='item_4_title_link' and @data-test='item-4-title-link']")
    private WebElement sauceLabsBackpack;


    @FindBy(xpath = "//a[@class='shopping_cart_link' and @data-test='shopping-cart-link']")
    private WebElement shoppingCartLink;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addToCartSauceLabsBackpackButton;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addToCartSauceLabsBikeLightButton;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement addToCartSauceLabsBoltTShirtButton;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    private WebElement addToCartSauceLabsFleeceJacketButton;

    @FindBy(id = "add-to-cart-sauce-labs-onesie")
    private WebElement addToCartSauceLabsOnesieButton;

    @FindBy(id = "add-to-cart-test.allthethings()-t-shirt-(red)")
    private WebElement addToCartTestAllTheThingsRedTShirtButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge' and @data-test='shopping-cart-badge']")
    private WebElement shoppingCartBadge;

    @FindBy(xpath = "//button[starts-with(@id, 'remove-') and contains(@id, '-button')]")
    private List<WebElement> removeButtons;

    @FindBy(css = "a[data-test='item-4-img-link']")
    private WebElement sauceLabsBackpackAnchor;


    @SuppressWarnings("deprecation")
    public HomePageFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void clickBurgerMenuButton() {
        burgerMenuButton.click();
    }

    public void clickLogoutLink() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutLink)).click();
    }

    public void clickBackpack() {
        sauceLabsBackpack.click();
    }

    public void clickcart() {
        shoppingCartLink.click();
    }

    public void clickbackpackPhoto() {
        sauceLabsBackpackAnchor.click();
    }

    public void add6items() {
        addToCartSauceLabsBackpackButton.click();
        addToCartSauceLabsBikeLightButton.click();
        addToCartSauceLabsBoltTShirtButton.click();
        addToCartSauceLabsFleeceJacketButton.click();
        addToCartSauceLabsOnesieButton.click();
        addToCartTestAllTheThingsRedTShirtButton.click();
    }

    public boolean isShoppingCartBadgeValueEqualToSix() {
        String badgeValue = shoppingCartBadge.getText();
        return "6".equals(badgeValue);
    }


    public boolean isMenuVisible() {
        // Check if the aria-hidden attribute is set to false
        String ariaHiddenValue = menuWrap.getAttribute("aria-hidden");
        return ariaHiddenValue != null && ariaHiddenValue.equals("false");
    }

    public void clickAllRemoveButtons() {
        

        for (WebElement button : removeButtons) {
            button.click();
        }
    }

    public boolean isShoppingCartBadgePresent() {
        try {
            return shoppingCartBadge.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isPriceListSorted() {
        WebElement firstItem = driver.findElement(By.cssSelector(".inventory_list .inventory_item:first-child"));
        WebElement itemNameElement = firstItem.findElement(By.cssSelector(".inventory_item_name"));
        String itemName = itemNameElement.getText();
        return itemName.equals("Sauce Labs Fleece Jacket");
}

public void selectPriceHighToLow() {
    Select sortBy = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
    sortBy.selectByValue("hilo");

}
}