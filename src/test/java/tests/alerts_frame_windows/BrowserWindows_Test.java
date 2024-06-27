package tests.alerts_frame_windows;

import helperMethods.MultipleWindows_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.alerts_frame_windows.BrowserWindowsPage;

public class BrowserWindows_Test {

    private WebDriver driver;
    private HomePage homePage;
    private BrowserWindowsPage browserWindowsPage;
    private AlertsWindowsPage alertsWindowsPage;
    private MultipleWindows_Methods multipleWindows_methods;


    ///     Data        ///

    String newTabConfirmationValue = "This is a sample page";
    String newWindowConfirmationValue = "This is a sample page";


    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        alertsWindowsPage = new AlertsWindowsPage(driver);
        browserWindowsPage = new BrowserWindowsPage(driver);
        multipleWindows_methods = new MultipleWindows_Methods(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        homePage.navigateToAlertsFrameWindows();
        alertsWindowsPage.navigateToBrowserWindows();

        browserWindowsPage.clickOnNewTabButton();
        multipleWindows_methods.switchToChildWindow();
        Assert.assertTrue(browserWindowsPage.validateNewTab(newTabConfirmationValue));
        driver.close();
        multipleWindows_methods.switchToParentWindow();

        browserWindowsPage.clickOnNewWindowButton();
        multipleWindows_methods.switchToChildWindow();
        Assert.assertTrue(browserWindowsPage.validateNewWindow(newWindowConfirmationValue));
        driver.close();
        multipleWindows_methods.switchToParentWindow();
    }
}
