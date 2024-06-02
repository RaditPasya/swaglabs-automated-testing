package com.a10.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPageFactory {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @SuppressWarnings("deprecation")
    public CartPageFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "checkout")
    private WebElement checkoutButton;
    @FindBy(id = "continue-shopping")
    private WebElement continueShoppingButton;


    public void clickCheckout() {
        checkoutButton.click();
    }

    public void clickContinueShopping() {
        continueShoppingButton.click();

    }

    @SuppressWarnings("deprecation")
    public boolean isMessageDisplayedAfterButtonClick() {
        // Perform the action that triggers the message
        checkoutButton.click();
    
        // Wait for the message to be displayed using various locators
        try {
            new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.className("message-class")));
            return true; // Message is displayed
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            // Handle if message is not found using class name
            try {
                new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.id("message-id")));
                return true; // Message is displayed
            } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException ex) {
                // Handle if message is not found using ID
                try {
                    new WebDriverWait(driver, 3).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("css-selector-of-message-element")));
                    return true; // Message is displayed
                } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException exc) {
                    // Handle if message is not found using CSS selector
                    return false; // Message is not displayed
                }
            }
        }
    }


    
    
}
