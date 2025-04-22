package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumBy;

public class HomePage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(HomePage.class);



    private final By createNewWalletButton = AppiumBy.xpath("//android.view.View[@resource-id='CreateNewWalletButton']");
    private final By existingWalletButton = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"buttonTitle\" and @text=\"I already have a wallet\"]");

    public HomePage() {
        super();
    }

    public PassCodePage clickCreateNewWallet() {
        //click create new wallet
        log.info("Clicking 'Create a new wallet' button");
       click(createNewWalletButton);
        return new PassCodePage();
    }

    public PassCodePage clickAlreadyHaveWallet() {
        //click existing wallet
        log.info("Clicking 'Already have a wallet' button");
        click(existingWalletButton);
        return new PassCodePage();
    }
}
