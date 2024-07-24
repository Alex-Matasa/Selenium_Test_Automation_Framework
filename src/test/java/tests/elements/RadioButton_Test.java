package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.RadioButtonPage;

import java.util.ArrayList;
import java.util.Arrays;


public class RadioButton_Test extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private ElementsPage elementsPage = new ElementsPage(driver);
    private RadioButtonPage radioButtonPage = new RadioButtonPage(driver);


    ///      Data      ////

    private ArrayList<String> radioButtonsIdValueList = new ArrayList<>(Arrays.asList("Impressive", "Yes", "No"));

    @Test
    public void validScenario() {
        driver.get("https://demoqa.com/");
        homePage.navigateToElements();
        elementsPage.navigateToRadioButton();
        radioButtonPage.clickOnRadioButtons(radioButtonsIdValueList);
        Assert.assertTrue(radioButtonPage.validateTest(radioButtonsIdValueList));
    }



}
