package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import pages.BasePage;

public class Helpers extends BasePage {

    protected AppiumDriver driver;
    protected WebDriverWait wait;

    protected void click(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    @Override
    protected void sendKeys(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    @Override
    protected String getText(By locator) {
        String text = waitForElementToBeVisible(locator).getText();
        return text;
    }

    @Override
    protected WebElement waitForElementToBeVisible(By locator) {
        try {

            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {

            throw e;
        }
    }

    @Override
    protected WebElement waitForElementToBeClickable(By locator) {
        try {

            WebElement element = waitForElementToBeVisible(locator);
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {

            throw e;
        }
    }

}
