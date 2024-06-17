package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.alerts_frame_windows.Alerts_PO;

public class Alerts_Test {

    private WebDriver driver;
    private Alerts_PO alertsPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        alertsPo = new Alerts_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        alertsPo.accessAlerts();

        alertsPo.clickOnStandardAlertButton();
        Assert.assertTrue(alertsPo.verifyStandardAlertIsDisplayed());
        alertsPo.closeAlert();
        Assert.assertTrue(alertsPo.confirmStandardAlertIsClosed());

        alertsPo.clickOnFiveSecondAlertButton();
        Assert.assertTrue(alertsPo.verifyFiveSecondsAlertIsDisplayed());
        alertsPo.closeAlert();
        Assert.assertTrue(alertsPo.confirmFiveSecondsAlertIsClosed());

        alertsPo.clickOnConfirmBoxAlertButton();
        Assert.assertTrue(alertsPo.verifyConfirmBoxAlertIsDisplayed());
        alertsPo.confirmAction();
        Assert.assertTrue(alertsPo.verifyConfirmBoxAlertIsConfirmed());

        alertsPo.clickOnConfirmBoxAlertButton();
        Assert.assertTrue(alertsPo.verifyConfirmBoxAlertIsDisplayed());
        alertsPo.cancelAction();
        Assert.assertTrue(alertsPo.verifyConfirmBoxAlertIsCanceled());

        alertsPo.clickOnPromptBoxAlertButton();
        Assert.assertTrue(alertsPo.verifyPromptBoxAlertIsDisplayed());
        alertsPo.cancelAction();
        Assert.assertTrue(alertsPo.confirmPromptBoxAlertIsClosed());

        alertsPo.clickOnPromptBoxAlertButton();
        Assert.assertTrue(alertsPo.verifyPromptBoxAlertIsDisplayed());
        alertsPo.enterName();
        alertsPo.confirmAction();
        Assert.assertTrue(alertsPo.verifyEnteredDataInPromptBoxAlert());

    }
}
