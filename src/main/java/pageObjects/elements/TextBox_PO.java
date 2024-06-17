package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base_PO;
import pageObjects.WebElement_Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TextBox_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());

    public TextBox_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //      Web Elements        //

    @FindBy(xpath = "//*[text()='Elements']/ancestor::div[contains(@class,'top-card')]") private WebElement elementsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Elements']/parent::div") public WebElement elementsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Text Box']/parent::li") private WebElement textBox_WebElement;
    @FindBy(xpath = "//input[@type='text']") private WebElement fullName_WebElement;
    @FindBy(xpath = "//input[@type='email']") private WebElement email_WebElement;
    @FindBy(xpath = "//label[text()='Current Address']/parent:: div/following-sibling::div/textarea") private WebElement currentAddress_WebElement;
    @FindBy(xpath = "//label[text()='Permanent Address']/parent:: div/following-sibling::div/textarea") private WebElement permanentAddress_WebElement;
    @FindBy(xpath = "//button[@id='submit']") private WebElement submit_WebElement;
    @FindBy(xpath = "//div[@id='output']/descendant:: p") private List <WebElement> dataOutput_WebElement;



    ////      Data       /////

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


    /////     steps /////

    public void accessTextBox() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(elementsHomePage_WebElement);
        webElementMethods.clickOn(elementsMenuList_WebElement);
        webElementMethods.clickOn(textBox_WebElement);
    }

    public void enterFullName() {
        webElementMethods.sendKeys(fullName_WebElement, fullNameValue);
    }
    
    public  void enterEmail() {
        webElementMethods.sendKeys(email_WebElement, emailValue);
    }
    
    public void enterCurrentAddress() {
        webElementMethods.sendKeys(currentAddress_WebElement, currentAddressValue);
    }

    public void enterPermanentAddress () {
        webElementMethods.sendKeys(permanentAddress_WebElement, currentAddressValue);
    }

    public void clickOnSubmitButton () {
        webElementMethods.clickOnJavaScriptExecutor(submit_WebElement);
    }

    public Boolean validateTest() {
         return webElementMethods.validateText(dataOutput_WebElement,dataInput);
    }


}







