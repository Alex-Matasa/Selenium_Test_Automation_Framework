package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helperMethods.WebElement_Methods;
import org.openqa.selenium.support.PageFactory;

public class AlertsWindowsPage extends BasePage{

    public AlertsWindowsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']/parent::div")
    private WebElement alertsFrameWindowsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Browser Windows']/parent::li")
    private WebElement browserWindows_WebElement;
    @FindBy(xpath = "//*[text()='Alerts']/parent::li")
    private WebElement alerts_WebElement;
    @FindBy(xpath = "//*[text()='Frames']/parent::li")
    private WebElement frames_WebElement;
    @FindBy(xpath = "//*[text()='Nested Frames']/parent::li")
    private WebElement nestedFrames_WebElement;


    public void navigateToBrowserWindows() {
        webElementMethods.clickOn(browserWindows_WebElement);
    }

    public void navigateToAlerts() {
        webElementMethods.clickOn(alerts_WebElement);
    }

    public void navigateToFrames() {
        webElementMethods.clickOn(frames_WebElement);
    }

    public void navigateToNestedFrames() {
        webElementMethods.clickOn(nestedFrames_WebElement);
    }







}
