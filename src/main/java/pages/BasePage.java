package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.DriverUtils;
import utils.Helpers;

public class BasePage {

    protected AppiumDriver driver;
    protected WebDriverWait wait;
    protected Helpers helpers;

    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    private static final int DEFAULT_TIMEOUT = 30;

    public BasePage() {
        this.driver = DriverUtils.getDriver();
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_TIMEOUT));

    }

    protected void click(By locator) {
        waitForElementToBeClickable(locator).click();
    }

    protected void sendKeys(By locator, String text) {
        WebElement element = waitForElementToBeVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        String text = waitForElementToBeVisible(locator).getText();
        return text;
    }

    protected WebElement waitForElementToBeVisible(By locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    protected WebElement waitForElementToBeClickable(By locator) {

        WebElement element = waitForElementToBeVisible(locator);
        return wait.until(ExpectedConditions.elementToBeClickable(element));

    }

}
