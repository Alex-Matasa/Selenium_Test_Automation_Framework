package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.ButtonsPage;


public class Buttons_Test extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private ElementsPage elementsPage = new ElementsPage(driver);
    private ButtonsPage buttonsPage = new ButtonsPage(driver);


            ///     Data        ///

    private String doubleClickMeMessageConfirmationValue = "You have done a double click";
    private String rightClickMeMessageConfirmationValue = "You have done a right click";
    private String clickMeMessageConfirmationValue = "You have done a dynamic click";


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
