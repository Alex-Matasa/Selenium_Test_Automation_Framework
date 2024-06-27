package pages.alerts_frame_windows;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helperMethods.Alert_Methods;
import helperMethods.WebElement_Methods;


public class AlertsPage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods;
    private Alert_Methods alertMethods;
    private Assertion_Methods assertionMethods;


    public AlertsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        webElementMethods = new WebElement_Methods(driver);
        alertMethods = new Alert_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    @FindBy(xpath = "//button[@id='alertButton']") private WebElement standardAlertButton_WebElement;
    @FindBy(xpath = "//button[@id='timerAlertButton']") private WebElement fiveSecondsAlertButton_WebElement;
    @FindBy(xpath = "//button[@id='confirmButton']") private WebElement confirmBoxAlertButton_WebElement;
    @FindBy(xpath = "//span[@id='confirmResult']") private WebElement confirmBoxAlerValidationMessage_WebElement;
    @FindBy(xpath = "//span[@id='promptResult']") private WebElement promptBoxAlertValidationMessage_WebElement;
    @FindBy(xpath = "//button[@id='promtButton']") private WebElement promptBoxAlertButton_WebElement;


    public void clickOnStandardAlertButton() {
        webElementMethods.clickOn(standardAlertButton_WebElement);
    }

    public void clickOnFiveSecondAlertButton() {
        webElementMethods.clickOn(fiveSecondsAlertButton_WebElement);
    }

    public void clickOnConfirmBoxAlertButton() {
        webElementMethods.clickOn(confirmBoxAlertButton_WebElement);
    }

    public void clickOnPromptBoxAlertButton() {
        webElementMethods.clickOn(promptBoxAlertButton_WebElement);
    }

    public void confirmAction() {
        alertMethods.acceptAlert();
    }

    public void cancelAction() {
        alertMethods.dismissAlert();
    }

    public Boolean verifyConfirmBoxAlertIsConfirmed(String expected) {
        return assertionMethods.validateText(confirmBoxAlerValidationMessage_WebElement,expected);
    }

    public Boolean verifyConfirmBoxAlertIsCanceled(String expected) {
        return assertionMethods.validateText(confirmBoxAlerValidationMessage_WebElement,expected);
    }

    public Boolean verifyEnteredDataInPromptBoxAlert(String expected) {
        return assertionMethods.validateText(promptBoxAlertValidationMessage_WebElement,expected);
    }

    public void enterName(String name) {
        alertMethods.sendKeys(name);
    }

    public void acceptAlert() {
        alertMethods.acceptAlert();
    }




}
