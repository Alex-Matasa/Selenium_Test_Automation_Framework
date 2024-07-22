package tests.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.AlertsWindowsPage;
import pages.HomePage;
import pages.alerts_frame_windows.AlertsPage;

public class Alerts_Test {

    private WebDriver driver;
    private HomePage homePage;
    private AlertsWindowsPage alertsWindowsPage;
    private AlertsPage alertsPage;


    private String acceptedAlertMessage = "You selected Ok";
    private String declinedAlertMessage = "You selected Cancel";
    private String name = "Popescu";
    private String promptBoxAlertValidationMesageValue = "You entered " + name;



    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        alertsWindowsPage = new AlertsWindowsPage(driver);
        alertsPage = new AlertsPage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        System.out.println("bla");

        homePage.navigateToAlertsFrameWindows();
        alertsWindowsPage.navigateToAlerts();

        alertsPage.clickOnStandardAlertButton();
        alertsPage.acceptAlert();

        alertsPage.clickOnFiveSecondAlertButton();
        alertsPage.acceptAlert();

        alertsPage.clickOnConfirmBoxAlertButton();
        alertsPage.confirmAction();
        Assert.assertTrue(alertsPage.verifyConfirmBoxAlertIsConfirmed(acceptedAlertMessage));

        alertsPage.clickOnConfirmBoxAlertButton();
        alertsPage.cancelAction();
        Assert.assertTrue(alertsPage.verifyConfirmBoxAlertIsCanceled(declinedAlertMessage));

        alertsPage.clickOnPromptBoxAlertButton();
        alertsPage.cancelAction();

        alertsPage.clickOnPromptBoxAlertButton();
        alertsPage.enterName(name);
        alertsPage.confirmAction();
        Assert.assertTrue(alertsPage.verifyEnteredDataInPromptBoxAlert(promptBoxAlertValidationMesageValue));
    }


}
