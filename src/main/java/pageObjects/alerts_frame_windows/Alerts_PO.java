package pageObjects.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.AlertMethods_Methods;
import pageObjects.Base_PO;
import pageObjects.WebElement_Methods;
import pageObjects.Page_Methods;


public class Alerts_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());
    private AlertMethods_Methods alertMethodsMethods = new AlertMethods_Methods(Base_PO.getDriver());
    private Page_Methods pageMethods = new Page_Methods(Base_PO.getDriver());

    public Alerts_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    ///     Web Elements        ///

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'top-card')]") private WebElement alertsFrameWindowsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']/parent::div") private WebElement alertsFrameWindowsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Alerts']/parent::li") private WebElement alertsMenu_WebElement;
    @FindBy(xpath = "//button[@id='alertButton']") private WebElement standardAlertButton_WebElement;
    @FindBy(xpath = "//button[@id='timerAlertButton']") private WebElement fiveSecondsAlertButton_WebElement;
    @FindBy(xpath = "//button[@id='confirmButton']") private WebElement confirmBoxAlertButton_WebElement;
    @FindBy(xpath = "//span[@id='confirmResult']") private WebElement confirmBoxAlerValidationMessage_WebElement;
    @FindBy(xpath = "//span[@id='promptResult']") private WebElement promptBoxAlertValidationMessage_WebElement;
    @FindBy(xpath = "//button[@id='promtButton']") private WebElement promptBoxAlertButton_WebElement;


    ///     Data        ///

    private String standardAlertTextMessage = "You clicked a button";
    private String fiveSecondsAlertTextMessage = "This alert appeared after 5 seconds";
    private String confirmBoxAlertTextMessage = "Do you confirm action?";
    private String acceptedAlertMessage = "You selected Ok";
    private String declinedAlertMessage = "You selected Cancel";
    private String promptBoxAlertTextMessage= "Please enter your name";
    private String name = "Popescu";
    private String promptBoxAlertValidationMesageValue = "You entered " + name;


    /////     steps    /////

    public void accessAlerts() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(alertsFrameWindowsHomePage_WebElement);
        webElementMethods.clickOn(alertsFrameWindowsMenuList_WebElement);
        webElementMethods.clickOn(alertsMenu_WebElement);
    }


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


    public Boolean verifyStandardAlertIsDisplayed() {
        return alertMethodsMethods.alertIsDisplayed(standardAlertTextMessage);
    }

    public Boolean verifyFiveSecondsAlertIsDisplayed() {
        return alertMethodsMethods.alertIsDisplayed(fiveSecondsAlertTextMessage);
    }

    public Boolean verifyConfirmBoxAlertIsDisplayed() {
        return alertMethodsMethods.alertIsDisplayed(confirmBoxAlertTextMessage);
    }

    public Boolean verifyPromptBoxAlertIsDisplayed() {
        return alertMethodsMethods.alertIsDisplayed(promptBoxAlertTextMessage);
    }



    public void confirmAction() {
        alertMethodsMethods.acceptAlert();
    }

    public void cancelAction() {
        alertMethodsMethods.dismissAlert();
    }


    public Boolean verifyConfirmBoxAlertIsConfirmed() {
        return webElementMethods.validateText(confirmBoxAlerValidationMessage_WebElement,acceptedAlertMessage);
    }

    public Boolean verifyConfirmBoxAlertIsCanceled() {
        return webElementMethods.validateText(confirmBoxAlerValidationMessage_WebElement,declinedAlertMessage);
    }

    public Boolean verifyEnteredDataInPromptBoxAlert() {
        return webElementMethods.validateText(promptBoxAlertValidationMessage_WebElement,promptBoxAlertValidationMesageValue);
    }



    public Boolean confirmStandardAlertIsClosed() {
        return alertMethodsMethods.alertIsClosed(standardAlertButton_WebElement);
    }

    public Boolean confirmFiveSecondsAlertIsClosed() {
        return alertMethodsMethods.alertIsClosed(fiveSecondsAlertButton_WebElement);
    }

    public Boolean confirmPromptBoxAlertIsClosed() {
        return alertMethodsMethods.alertIsClosed(promptBoxAlertButton_WebElement);
    }


    public void enterName() {
        alertMethodsMethods.sendKeys(name);
    }

    public void closeAlert() {
        alertMethodsMethods.acceptAlert();
    }



















}
