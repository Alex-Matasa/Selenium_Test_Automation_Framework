package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.alerts_frame_windows.NestedFramesPage;

public class NestedFrames_Test {

    private WebDriver driver;
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;
    private NestedFramesPage nestedFramesPo;


    ///     Data        ///

    private String childFrameTextValue = "Child Iframe";
    private String parentFrameTextValue = "Parent frame";


    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        alertsWindowsPage = new AlertsWindowsPage(driver);
        nestedFramesPo = new NestedFramesPage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

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
