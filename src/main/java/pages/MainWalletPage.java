package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumBy;

public class MainWalletPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(MainWalletPage.class);
    private final By mainBalanceSelectorLocator = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"mainBalance\"]");
    private final By amountSelectorLocator = AppiumBy.xpath("//android.widget.EditText[@resource-id='amountSelector']");
    private final By buyNowSelectorLocator = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"buttonTitle\"]");
    private final By manageCryptoSelectorLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Manage crypto\"]");
    private final By secretsConfigLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Secret phrase\"]");

    public MainWalletPage() {
        super();
    }

    public void verifyOnMainWalletPage() {

        //verify on wallet page
        log.info("Verifying navigation to Main Wallet Page");
        WebElement mainBalanceElement = waitForElementToBeVisible(mainBalanceSelectorLocator);
        WebElement manageCryptoElement = waitForElementToBeVisible(manageCryptoSelectorLocator);

        // assert that the elements are displayed 
        Assert.assertTrue(mainBalanceElement.isDisplayed(), "Main balance element not displayed");
        Assert.assertTrue(manageCryptoElement.isDisplayed(), "'Manage crypto element not displayed");

    }

    public void verifyOnAddExistingWalletPage() {

        //verify on add existing wallet page 
        log.info("Verifying navigation to the Secret Phrase import page.");
        WebElement secretPhraseElement = waitForElementToBeVisible(secretsConfigLocator);

        // Assert element visible
        Assert.assertNotNull(secretPhraseElement, "Secret phrase element not found");
        String actualText = secretPhraseElement.getText();

        Assert.assertEquals(actualText, "Secret phrase", "Element not found");

    }

}
