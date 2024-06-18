package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.alerts_frame_windows.Frames_PO;

public class Frames_Test {

    private WebDriver driver;
    private Frames_PO framesPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        framesPo = new Frames_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {

        framesPo.accessFrames();
        framesPo.switchToFrame1();
        Assert.assertTrue(framesPo.validateFrame1());
        framesPo.switchToMainPage();
        Assert.assertTrue(framesPo.validateSwitchToMain());

        framesPo.switchToFrame2();
        Assert.assertTrue(framesPo.validateFrame2());
        framesPo.switchToMainPage();
        Assert.assertTrue(framesPo.validateSwitchToMain());

    }








}
