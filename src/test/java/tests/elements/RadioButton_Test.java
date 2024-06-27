package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.RadioButtonPage;

import java.util.ArrayList;
import java.util.Arrays;


public class RadioButton_Test {

    private WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private RadioButtonPage radioButtonPage;

    ///      Data      ////

    private ArrayList<String> radioButtonsIdValueList = new ArrayList<>(Arrays.asList("Impressive", "Yes", "No"));


    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        radioButtonPage = new RadioButtonPage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        driver.get("https://demoqa.com/");
        homePage.navigateToElements();
        elementsPage.navigateToRadioButton();
        radioButtonPage.clickOnRadioButtons(radioButtonsIdValueList);
        Assert.assertTrue(radioButtonPage.validateTest(radioButtonsIdValueList));
    }



}
