package com.a10.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class A10WebDriverManager {

    private static WebDriver driver;

    private A10WebDriverManager() {
        // Private constructor to prevent instantiation
    }

    public static synchronized WebDriver getWebDriver() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        return driver;
    }

    public static synchronized void quitWebDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
