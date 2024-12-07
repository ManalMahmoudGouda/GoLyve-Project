package com.GoLyve.automation.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Duration DEFAULT_WAIT_TIME = Duration.ofSeconds(10);

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Set an explicit wait
    }

    public void enterText(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)); // Wait for visibility
        element.clear();
        element.sendKeys(text);
    }

    public WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void scrollToElementAndWaitToVisible(WebDriver driver, WebElement element) {
        // Scroll to the element using JavaScript
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);

        // Wait for the element to be visible
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // **New Method**: Check if an element is visible
    public boolean isElementVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_TIME);
            WebElement visibleElement = wait.until(ExpectedConditions.visibilityOf(element));
            return visibleElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }}
