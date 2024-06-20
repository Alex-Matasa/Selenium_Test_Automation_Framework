package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.alerts_frame_windows.Frames_PO;
import pageObjects.alerts_frame_windows.NestedFrames_PO;

public class NestedFrames_Test {

    private WebDriver driver;
    private NestedFrames_PO nestedFramesPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        nestedFramesPo = new NestedFrames_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {

        nestedFramesPo.accessNestedFrames();
        nestedFramesPo.switchToParentFrame();
        Assert.assertTrue(nestedFramesPo.validateParentFrame());
        nestedFramesPo.switchToMainPage();
        Assert.assertTrue(nestedFramesPo.validateSwitchToMain());

        nestedFramesPo.switchToChildFrame();
        Assert.assertTrue(nestedFramesPo.validateChildFrame());
        nestedFramesPo.switchToMainPage();
        Assert.assertTrue(nestedFramesPo.validateSwitchToMain());

        nestedFramesPo.switchToChildFrame();
        Assert.assertTrue(nestedFramesPo.validateChildFrame());
        nestedFramesPo.switchToParentFrame();
        Assert.assertTrue(nestedFramesPo.validateParentFrame());
        nestedFramesPo.switchToMainPage();
        nestedFramesPo.validateSwitchToMain();


    }







}
