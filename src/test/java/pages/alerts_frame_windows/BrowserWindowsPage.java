package pages.alerts_frame_windows;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helperMethods.MultipleWindows_Methods;
import helperMethods.WebElement_Methods;

public class BrowserWindowsPage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods;
    private MultipleWindows_Methods multipleWindows_methods;
    private Assertion_Methods assertionMethods;

    public BrowserWindowsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webElementMethods = new WebElement_Methods(driver);
        multipleWindows_methods = new MultipleWindows_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    @FindBy(xpath = "//div/button[text()='New Tab']") private WebElement newTabButton_WebElement;
    @FindBy(xpath = "//*[text()='This is a sample page']") private WebElement newTabConfirmationText_WebElement;
    @FindBy(xpath = "//div/button[text()='New Window']") private WebElement newWindowButton_WebElement;
    @FindBy(xpath = "//*[text()='This is a sample page']") private WebElement newWindowConfirmationText_WebElement;


    public void clickOnNewTabButton() {
        webElementMethods.clickOn(newTabButton_WebElement);
    }

    public void clickOnNewWindowButton() {
        webElementMethods.clickOn(newWindowButton_WebElement);
    }

    public Boolean validateNewTab(String expected) {

        return assertionMethods.validateText(newTabConfirmationText_WebElement, expected);
    }

    public Boolean validateNewWindow(String expected) {

        return  assertionMethods.validateText(newTabConfirmationText_WebElement, expected);

    }



}
