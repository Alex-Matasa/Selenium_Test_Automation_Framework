package pageObjects.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base_PO;
import pageObjects.Frames_Methods;
import pageObjects.WebElement_Methods;

public class NestedFrames_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());
    private Frames_Methods framesMethods = new Frames_Methods(Base_PO.getDriver());


    public NestedFrames_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    ///     WebElements         ///

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'top-card')]") private WebElement alertsFrameWindowsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']/parent::div") private WebElement alertsFrameWindowsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Nested Frames']/parent::li") private WebElement nestedFramesMenu_WebElement;
    @FindBy(xpath = "//iframe[@id='frame1']") private WebElement parentFrame_WebElement;
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']") private WebElement childFrame_WebElement;
    @FindBy(xpath = "//body[text()='Parent frame']") private WebElement parentFrameText_WebElement;
    @FindBy(xpath = "//p") private WebElement childFrameText_WebElement;
    @FindBy(xpath = "//div[@id='framesWrapper']/descendant::*[text()='Nested Frames']") private WebElement mainPageTitle_WebElement;



    ///     Data        ///

    private String childFrameTextValue = "Child Iframe";
    private String parentFrameTextValue = "Parent frame";
    private String mainPageTitleValue = "Nested Frames";



    ///     steps       ///

    public void accessNestedFrames() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(alertsFrameWindowsHomePage_WebElement);
        webElementMethods.clickOn(alertsFrameWindowsMenuList_WebElement);
        webElementMethods.clickOn(nestedFramesMenu_WebElement);
    }

    public void switchToParentFrame() {
        framesMethods.switchToMainPage();
        framesMethods.switchToFrame(parentFrame_WebElement);
    }

    public void switchToChildFrame() {
        framesMethods.switchToFrame(parentFrame_WebElement);
        framesMethods.switchToFrame(childFrame_WebElement);
    }

    public Boolean validateParentFrame() {
        return webElementMethods.validateText(parentFrameText_WebElement, parentFrameTextValue);
    }
    public Boolean validateChildFrame() {
        return webElementMethods.validateText(childFrameText_WebElement, childFrameTextValue);
    }

    public void switchToMainPage() {
        framesMethods.switchToMainPage();
    }

    public Boolean validateSwitchToMain() {
        return webElementMethods.validateText(mainPageTitle_WebElement, mainPageTitleValue);
    }







}
