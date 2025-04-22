package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;

public class PassCodePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(PassCodePage.class);

    private By getPassCodeButton(int digit) {
        return AppiumBy.xpath(String.format("//android.widget.TextView[@text='%d']", digit));
    }

    private final By createNewWalletButton = AppiumBy.xpath("//android.widget.TextView[@text='Create a new wallet']");
    private final By createPasscodeLocator = AppiumBy.xpath("//android.widget.TextView[@text='Create a new wallet']");
    private final By wrongPasscodeTextLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Those passwords didn’t match!\"]");

    public PassCodePage() {
        super();
    }

    public void enterPasscode(String passcode) {
        log.info("Entering passcode sequence");
        // waits for numpad to show
        waitForElementToBeClickable(getPassCodeButton(1));

        for (char digit : passcode.toCharArray()) {
            int num = Character.getNumericValue(digit);
            click(getPassCodeButton(num));

        }
    }

    public void verifyErrorMessageIsDisplayed() {
        log.info("Verifying that the wrong passcode error message is displayed.");
        WebElement errorMessage = waitForElementToBeVisible(wrongPasscodeTextLocator);
        Assert.assertTrue(errorMessage.isDisplayed(), "Error message not displayed");
    }

}
