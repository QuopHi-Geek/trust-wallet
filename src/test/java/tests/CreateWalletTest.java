package tests;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import data.TestData;
import pages.DepositPage;
import pages.HomePage;
import pages.MainWalletPage;
import pages.NotificationsPage;
import pages.PassCodePage;

public class CreateWalletTest extends BaseTest {

    private static final Logger log = LoggerFactory.getLogger(CreateWalletTest.class);

    HomePage homePage;
    PassCodePage passCodePage;
    NotificationsPage notificationsPage;
    DepositPage depositPage;
    MainWalletPage mainWalletPage;

    @Test(description = "Create New wallet",priority=1)
    public void createWalletTest() {

        log.info("Starting create wallet test");

        homePage = new HomePage();
        log.info("Initialized Get Started Page");

        // click Create Wallet
        passCodePage = homePage.clickCreateNewWallet();
        log.info("Navigated to passcode setup");

        //  enter passcode using TestData
        log.info("Entering initial passcode");
        passCodePage.enterPasscode(TestData.VALID_PASSCODE);

        // confirm passcode using TestData
        log.info("Confirming passcode");
        passCodePage.enterPasscode(TestData.VALID_PASSCODE);

        // enable notifications
        notificationsPage = new NotificationsPage();
        notificationsPage.enableNotificationsForNow(); 
        log.info("Enabled notifications");

        // skip deposit
        depositPage = new DepositPage();
        depositPage.clickSkipDepositForNow();
        log.info("Skipped initial deposit");

        //verify on main wallet page
        mainWalletPage = new MainWalletPage();
        mainWalletPage.verifyOnMainWalletPage();

        log.info("Create Wallet test completed successfully");
    }



     @Test(description = "Verify Passcode Validity",priority=2)
    public void verifyPasscodeTest() {

        log.info("Starting verify passcode test");

        homePage = new HomePage();
        log.info("Initialized Get Started Page");

        // click Create Wallet
        passCodePage = homePage.clickCreateNewWallet();
        log.info("Navigated to passcode setup");

         //  enter passcode
        log.info("Entering initial passcode");
        passCodePage.enterPasscode(TestData.VALID_PASSCODE);

        // enter invalid matching passcode 
        log.info("Entering wrong matching passcode");
        passCodePage.enterPasscode(TestData.INVALID_PASSCODE);

        //validate error message
        passCodePage.verifyErrorMessageIsDisplayed();

        //re-enter valid passcode
        passCodePage.enterPasscode(TestData.VALID_PASSCODE);

        passCodePage.enterPasscode(TestData.VALID_PASSCODE);

        // skip notifications
        notificationsPage = new NotificationsPage();
        notificationsPage.clickSkipNotificationsForNow();
        log.info("Skipped notifications");

        // skip deposit
        depositPage = new DepositPage();
        depositPage.clickSkipDepositForNow();
        log.info("Skipped initial deposit");

        //verify on main wallet page
        mainWalletPage = new MainWalletPage();
        mainWalletPage.verifyOnMainWalletPage();

        log.info("Verify Passcode test completed successfully");

    }


     @Test(description = "Verify Existing Wallet",priority=3)
    public void verifyExistingWalletTest() {

        log.info("Starting existing wallet test");

        homePage = new HomePage();
        log.info("Initialized Get Started Page");

        // click "already have wallet" 
        passCodePage = homePage.clickAlreadyHaveWallet();
        log.info("Navigated to passcode setup for existing wallet");

        //  enter passcode
        log.info("Entering passcode"); 
        passCodePage.enterPasscode(TestData.VALID_PASSCODE);

        // confirm passcode
        log.info("Confirming passcode");
        passCodePage.enterPasscode(TestData.VALID_PASSCODE);

    
        notificationsPage = new NotificationsPage();
        notificationsPage.enableNotificationsForNow();
        log.info("Enabled notifications");

        //verify on add existing wallet page
        mainWalletPage = new MainWalletPage();
        mainWalletPage.verifyOnAddExistingWalletPage();

        log.info("Existing wallet test completed successfully");

    }


}
