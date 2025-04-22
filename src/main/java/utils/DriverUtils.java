package utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class DriverUtils {

    private static AppiumDriver driver;

    public static void initializeDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/test/resources/latest.apk");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "15.0");
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appPackage", "com.wallet.crypto.trustapp");
        capabilities.setCapability("appActivity", "com.wallet.crypto.trustapp.ui.app.AppActivity");
        capabilities.setCapability("skipUnlock", true);
        capabilities.setCapability("newCommandTimeout", 600);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("setAppWaitDuration", 3000);

        try {
            driver = new AppiumDriver(new URL("http://0.0.0.0:4725/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException("Appium server URL is invalid", e);
        }
    }

    public static AppiumDriver getDriver() {
        if (driver == null) {
            throw new IllegalStateException("Driver not initialized. Please call initializeDriver first.");
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
