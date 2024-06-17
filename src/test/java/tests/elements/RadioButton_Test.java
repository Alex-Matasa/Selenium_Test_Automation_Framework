package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.elements.RadioButton_PO;


public class RadioButton_Test {

    private WebDriver driver;
    private RadioButton_PO radioButtonPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        radioButtonPo = new RadioButton_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        radioButtonPo.accessRadioButton();
        radioButtonPo.clickOnRadioButtons();
        Assert.assertTrue(radioButtonPo.validateTest());
    }



}
