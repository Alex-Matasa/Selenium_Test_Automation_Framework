package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class TextBoxPage extends BasePage {

    public TextBoxPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@type='text']")
    private WebElement fullName_WebElement;
    @FindBy(xpath = "//input[@type='email']")
    private WebElement email_WebElement;
    @FindBy(xpath = "//label[text()='Current Address']/parent:: div/following-sibling::div/textarea")
    private WebElement currentAddress_WebElement;
    @FindBy(xpath = "//label[text()='Permanent Address']/parent:: div/following-sibling::div/textarea")
    private WebElement permanentAddress_WebElement;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submit_WebElement;
    @FindBy(xpath = "//div[@id='output']/descendant:: p")
    private List<WebElement> dataOutput_WebElement;


    public void enterFullName(String fullName) {
        webElementMethods.sendKeys(fullName_WebElement, fullName);
    }
    
    public  void enterEmail(String email) {
        webElementMethods.sendKeys(email_WebElement, email);
    }
    
    public void enterCurrentAddress(String currentAddress) {
        webElementMethods.sendKeys(currentAddress_WebElement, currentAddress);
    }

    public void enterPermanentAddress (String permanentAddress) {
        webElementMethods.sendKeys(permanentAddress_WebElement, permanentAddress);
    }

    public void clickOnSubmitButton () {
        webElementMethods.clickOnJavaScriptExecutor(submit_WebElement);
    }

    public Boolean validateTest(ArrayList dataInput) {
         return assertionMethods.validateText(dataOutput_WebElement,dataInput);
    }


}







