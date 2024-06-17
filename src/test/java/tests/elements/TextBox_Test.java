package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.elements.TextBox_PO;

public class TextBox_Test  {

    private WebDriver driver;
    private TextBox_PO textBoxPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        textBoxPo = new TextBox_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        textBoxPo.accessTextBox();
        textBoxPo.enterFullName();
        textBoxPo.enterEmail();
        textBoxPo.enterCurrentAddress();
        textBoxPo.enterPermanentAddress();
        textBoxPo.clickOnSubmitButton();
        Assert.assertTrue(textBoxPo.validateTest());
    }


}
