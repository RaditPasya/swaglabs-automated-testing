package com.a10.pagefactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPageFactory {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @SuppressWarnings("deprecation")
    public OverviewPageFactory(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@class='btn btn_action btn_medium cart_button' and @data-test='finish']")
    private WebElement finishButton;

    public void clickFinish() {
        finishButton.click();
    }

    
}
