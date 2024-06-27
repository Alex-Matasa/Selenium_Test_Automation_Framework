package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.ButtonsPage;


public class Buttons_Test {
    private WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private ButtonsPage buttonsPage;


    private String doubleClickMeMessageConfirmationValue = "You have done a double click";
    private String rightClickMeMessageConfirmationValue = "You have done a right click";
    private String clickMeMessageConfirmationValue = "You have done a dynamic click";

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        buttonsPage = new ButtonsPage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {

        driver.get("https://demoqa.com/");
        homePage.navigateToElements();
        elementsPage.navigateToButtons();

        buttonsPage.doubleClickOnDoubleClickButton();
        Assert.assertTrue(buttonsPage.validateDoubleClickButton(doubleClickMeMessageConfirmationValue));

        buttonsPage.rightClickOnRightClickButton();
        Assert.assertTrue(buttonsPage.validateRightClickButton(rightClickMeMessageConfirmationValue));

        buttonsPage.clickOnClickMeButton();
        Assert.assertTrue(buttonsPage.validateClickMeButton(clickMeMessageConfirmationValue));
    }
}
