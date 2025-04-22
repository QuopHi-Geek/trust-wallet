package pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.AppiumBy;

public class NotificationsPage extends BasePage {

    private static final Logger log = LoggerFactory.getLogger(NotificationsPage.class);

    private final By enableNotificationsButtonLocator = AppiumBy.xpath("//android.widget.TextView[@resource-id='buttonTitle']");
    private final By skipNotificationsButtonLocator = AppiumBy.xpath("//android.widget.TextView[@resource-id='secondaryAction']");

    public NotificationsPage() {
        super();
    }

    public DepositPage clickSkipNotificationsForNow() {
        //skip notifications
        click(skipNotificationsButtonLocator);
        log.info("Notifications skipped");
        return new DepositPage();
    }

    public DepositPage enableNotificationsForNow() {
        //enable notifications
        click(enableNotificationsButtonLocator);
        log.info("Notifications enabled");
        return new DepositPage();
    }

}
