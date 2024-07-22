package pages.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;


public class AlertsPage extends BasePage {

    public AlertsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='alertButton']")
    private WebElement standardAlertButton_WebElement;
    @FindBy(xpath = "//button[@id='timerAlertButton']")
    private WebElement fiveSecondsAlertButton_WebElement;
    @FindBy(xpath = "//button[@id='confirmButton']")
    private WebElement confirmBoxAlertButton_WebElement;
    @FindBy(xpath = "//span[@id='confirmResult']")
    private WebElement confirmBoxAlerValidationMessage_WebElement;
    @FindBy(xpath = "//span[@id='promptResult']")
    private WebElement promptBoxAlertValidationMessage_WebElement;
    @FindBy(xpath = "//button[@id='promtButton']")
    private WebElement promptBoxAlertButton_WebElement;

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
