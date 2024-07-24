package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.alerts_frame_windows.NestedFramesPage;

public class NestedFrames_Test extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private AlertsWindowsPage alertsWindowsPage = new AlertsWindowsPage(driver);
    private NestedFramesPage nestedFramesPo = new NestedFramesPage(driver);


    ///     Data        ///

    private String childFrameTextValue = "Child Iframe";
    private String parentFrameTextValue = "Parent frame";

    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        homePage.navigateToAlertsFrameWindows();
        alertsWindowsPage.navigateToNestedFrames();

        nestedFramesPo.switchToParentFrame();
        Assert.assertTrue(nestedFramesPo.validateParentFrame(parentFrameTextValue));

        nestedFramesPo.switchToChildFrame();
        Assert.assertTrue(nestedFramesPo.validateChildFrame(childFrameTextValue));

        nestedFramesPo.switchToMainPage();

    }







}
