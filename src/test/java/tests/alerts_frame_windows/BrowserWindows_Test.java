package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.alerts_frame_windows.BrowserWindows_PO;

public class BrowserWindows_Test {

    private WebDriver driver;
    private BrowserWindows_PO browserWindowsPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        browserWindowsPo = new BrowserWindows_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        browserWindowsPo.accessBrowserWindows();

        browserWindowsPo.clickOnNewTabButton();
        Assert.assertTrue(browserWindowsPo.validateNewTab());

        browserWindowsPo.clickOnNewWindowButton();
        Assert.assertTrue(browserWindowsPo.validateNewWindow());
    }
}
