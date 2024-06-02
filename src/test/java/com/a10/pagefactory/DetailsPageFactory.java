package com.a10.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DetailsPageFactory {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @SuppressWarnings("deprecation")
    public DetailsPageFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn_primary btn_small btn_inventory' and @data-test='add-to-cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//button[@class='btn btn_secondary back btn_large inventory_details_back_button' and @data-test='back-to-products']")
    private WebElement backToProductsButton;

    @FindBy(xpath = "//span[@class='shopping_cart_badge' and @data-test='shopping-cart-badge']")
    private WebElement shoppingCartBadge;


    public void clickaddtocartbutton() {
        addToCartButton.click();
    }

    public void clickbackproduct() {
        backToProductsButton.click();
    }

    @FindBy(id = "remove")
    private WebElement removeButton;


    public boolean checkBadgeV2() {
        String badgeValue = shoppingCartBadge.getText();
        return "1".equals(badgeValue);
    }

    public void begoneProduct() {
        removeButton.click();
    }
}
