package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.elements.Buttons_PO;


public class Buttons_Test {
    private WebDriver driver;
    private Buttons_PO buttonsPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        buttonsPo = new Buttons_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        buttonsPo.accessButtons();

        buttonsPo.doubleClickOnDoubleClickButton();
        Assert.assertTrue(buttonsPo.validateDoubleClickButton());

        buttonsPo.rightClickOnRightClickButton();
        Assert.assertTrue(buttonsPo.validateRightClickButton());

        buttonsPo.clickOnClickMeButton();
        Assert.assertTrue(buttonsPo.validateClickMeButton());
    }
}
