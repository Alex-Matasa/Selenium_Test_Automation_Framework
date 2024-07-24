package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.alerts_frame_windows.FramesPage;

public class Frames_Test extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private AlertsWindowsPage  alertsWindowsPage = new AlertsWindowsPage(driver);
    private FramesPage framesPage = new FramesPage(driver);


    ///     Data        ///

    private String frameTextValue = "This is a sample page";

    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        homePage.navigateToAlertsFrameWindows();
        alertsWindowsPage.navigateToFrames();

        framesPage.switchToFrame1();
        Assert.assertTrue(framesPage.validateFrame1(frameTextValue));
        framesPage.switchToMainPage();

        framesPage.switchToFrame2();
        Assert.assertTrue(framesPage.validateFrame2(frameTextValue));
        framesPage.switchToMainPage();
    }





}
