package com.a10.pagefactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class YourInfoPageFactory {

    private final WebDriver driver;
    private final WebDriverWait wait;

    @SuppressWarnings("deprecation")
    public YourInfoPageFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@class='input_error form_input' and @data-test='firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@class='input_error form_input' and @data-test='lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@class='input_error form_input' and @data-test='postalCode']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//input[@class='submit-button btn btn_primary cart_button btn_action' and @data-test='continue']")
    private WebElement continueButton;

    @FindBy(className = "error-message-container")
    private WebElement errorMessage;

    public String getErrorMessage() {
        return errorMessage.getText();
    }


    public void serFirstname(String Firstname) {
        firstNameInput.sendKeys(Firstname);
    }

    public void setLastname(String lastname) {
        lastNameInput.sendKeys(lastname);
    }

    public void setZipcode(String zipcode) {
        postalCodeInput.sendKeys(zipcode);
    }

    public void clickContinue() {
        continueButton.click();
    }

    public boolean isContinueButtonClickable() {
        return continueButton.isEnabled();
    }

    public boolean isErrorMessageDisplayed(String message) {
        try {
            return driver.findElement(By.xpath("//h3[contains(text(), '" + message + "')]/parent::div[contains(@class, 'error-message-container')]")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.TimeoutException e) {
            return false;
        }
    }

    public String getErrorMessageText() {
        WebElement errorMessageElement = driver.findElement(By.xpath("//div[@class='error-message-container error']//h3[@data-test='error']"));
        return errorMessageElement.getText();
    }
    
    
    
}
