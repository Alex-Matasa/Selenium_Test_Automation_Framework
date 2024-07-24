package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.TextBoxPage;

import java.util.ArrayList;
import java.util.Arrays;

public class TextBox_Test  extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private ElementsPage elementsPage = new ElementsPage(driver);
    private TextBoxPage textBoxPage = new TextBoxPage(driver);


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


    @Test
    public void validScenario() {
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


}
