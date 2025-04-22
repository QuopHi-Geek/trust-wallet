package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumBy;

public class DepositPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(NotificationsPage.class);

    private final By skipDepositButtonLocator = AppiumBy.xpath("//android.widget.TextView[@text=\"Skip, I'll do it later\"]");

    private final By depositButtonLocator = AppiumBy.xpath("//android.widget.TextView[@resource-id='buttonTitle' and @text='Buy Crypto']");

    public DepositPage() {
        super();
    }

    public MainWalletPage clickSkipDepositForNow() {
        //click skip deposit for now
        waitForElementToBeClickable(skipDepositButtonLocator);
        click(skipDepositButtonLocator);
        log.info("Initial Deposit skipped");
        return new MainWalletPage();
    }

    public MainWalletPage depositWallet() {
        //click add deposit 
        waitForElementToBeClickable(depositButtonLocator);
        click(depositButtonLocator);
        return new MainWalletPage();
    }

}
