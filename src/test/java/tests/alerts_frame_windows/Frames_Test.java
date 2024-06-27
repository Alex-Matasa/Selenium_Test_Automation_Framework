package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.alerts_frame_windows.FramesPage;

public class Frames_Test {

    private WebDriver driver;
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;
    private FramesPage framesPage;


    ///     Data        ///

    private String frameTextValue = "This is a sample page";


    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        alertsWindowsPage = new AlertsWindowsPage(driver);
        framesPage = new FramesPage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

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
