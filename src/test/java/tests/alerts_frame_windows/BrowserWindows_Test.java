package tests.alerts_frame_windows;

import helperMethods.MultipleWindows_Methods;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.alerts_frame_windows.BrowserWindowsPage;

public class BrowserWindows_Test extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private  AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
    private BrowserWindowsPage browserWindowsPage = new BrowserWindowsPage(driver);
    private MultipleWindows_Methods multipleWindows_methods = new MultipleWindows_Methods(driver);


    ///     Data        ///

    String newTabConfirmationValue = "This is a sample page";
    String newWindowConfirmationValue = "This is a sample page";


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
