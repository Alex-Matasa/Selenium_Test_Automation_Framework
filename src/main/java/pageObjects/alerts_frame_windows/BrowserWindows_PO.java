package pageObjects.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base_PO;
import pageObjects.MultipleWindows_Methods;
import pageObjects.WebElement_Methods;

public class BrowserWindows_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());
    private MultipleWindows_Methods multipleWindows_methods = new MultipleWindows_Methods(Base_PO.getDriver());

    public BrowserWindows_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ///     Web Elements        ///

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'top-card')]") private WebElement alertsFrameWindowsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']/parent::div") private WebElement alertsFrameWindowsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Browser Windows']/parent::li") private WebElement browseerWindowsMenu_WebElement;
    @FindBy(xpath = "//div/button[text()='New Tab']") private WebElement newTabButton_WebElement;
    @FindBy(xpath = "//*[text()='This is a sample page']") private WebElement newTabConfirmationText_WebElement;
    @FindBy(xpath = "//div/button[text()='New Window']") private WebElement newWindowButton_WebElement;
    @FindBy(xpath = "//*[text()='This is a sample page']") private WebElement newWindowConfirmationText_WebElement;


    ///     Data        ///

    String newTabConfirmationValue = "This is a sample page";
    String newWindowConfirmationValue = "This is a sample page";


    ///     steps       ///

    public void accessBrowserWindows() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(alertsFrameWindowsHomePage_WebElement);
        webElementMethods.clickOn(alertsFrameWindowsMenuList_WebElement);
        webElementMethods.clickOn(browseerWindowsMenu_WebElement);
    }

    public void clickOnNewTabButton() {
        webElementMethods.clickOn(newTabButton_WebElement);
    }

    public void clickOnNewWindowButton() {
        webElementMethods.clickOn(newWindowButton_WebElement);
    }

    public Boolean validateNewTab() {
        Boolean isValid = true;

        multipleWindows_methods.switchToChildWindow();

        isValid = webElementMethods.validateText(newTabConfirmationText_WebElement, newTabConfirmationValue);

        driver.close();

        multipleWindows_methods.switchToParentWindow();

        return isValid;
    }

    public Boolean validateNewWindow() {
        Boolean isValid = true;

        multipleWindows_methods.switchToChildWindow();

        isValid = webElementMethods.validateText(newTabConfirmationText_WebElement, newWindowConfirmationValue);

        driver.close();

        multipleWindows_methods.switchToParentWindow();

        return isValid;
    }



}
