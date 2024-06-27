package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.TextBoxPage;

import java.util.ArrayList;
import java.util.Arrays;

public class TextBox_Test  {

    private WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private TextBoxPage textBoxPage;


    private String fullNameValue = "Popescu Ion";
    private String emailValue = "popescu.ion@email.com";
    private String currentAddressValue = "str. OriceStrada, nr. 5, județ OriceJudeț";
    private String permanentAddressValue = "str. OriceStrada, nr. 5, județ OriceJudeț";

    public ArrayList<String> dataInput = new ArrayList<>(Arrays.asList(
            "Name:" + fullNameValue,
            "Email:" + emailValue,
            "Current Address :" + currentAddressValue,
            "Permananet Address :" + permanentAddressValue)
    );

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        textBoxPage = new TextBoxPage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void enterValidData() {
        driver.get("https://demoqa.com/");
        homePage.navigateToElements();
        elementsPage.navigateToTextBox();

        textBoxPage.enterFullName(fullNameValue);
        textBoxPage.enterEmail(emailValue);
        textBoxPage.enterCurrentAddress(currentAddressValue);
        textBoxPage.enterPermanentAddress(permanentAddressValue);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.validateTest(dataInput));
    }
    @Test
    public void enterInvalidEmail() {
        driver.get("https://demoqa.com/");
        homePage.navigateToElements();
        elementsPage.navigateToTextBox();

        textBoxPage.enterFullName(fullNameValue);
        textBoxPage.enterEmail("popescu.ion.email.com");
        textBoxPage.enterCurrentAddress(currentAddressValue);
        textBoxPage.enterPermanentAddress(permanentAddressValue);
        textBoxPage.clickOnSubmitButton();
        Assert.assertTrue(textBoxPage.validateEmailErrorField());
    }


}
