package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helperMethods.WebElement_Methods;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{



    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'top-card')]")
    private WebElement alertsFrameWindowsHomePage_WebElement;
    @FindBy(xpath = "//*[text()='Elements']/ancestor::div[contains(@class,'top-card')]")
    private WebElement elementsHomePage_WebElement;
    @FindBy(xpath = "//*[text()='Forms']/ancestor::div[contains(@class,'top-card')]")
    private WebElement formsHomePage_WebElement;
    @FindBy(xpath = "//*[text()='Widgets']/ancestor::div[contains(@class,'top-card')]")
    private WebElement widgetsHomePage_WebElement;

    public void navigateToElements() {
        webElementMethods.clickOn(elementsHomePage_WebElement);
    }

    public void navigateToAlertsFrameWindows() {
        webElementMethods.clickOn(alertsFrameWindowsHomePage_WebElement);
    }

    public void navigateToForms() {
        webElementMethods.clickOn(formsHomePage_WebElement);
    }

    public void navigateToWidgets() {
        webElementMethods.clickOn(widgetsHomePage_WebElement);
    }





}
