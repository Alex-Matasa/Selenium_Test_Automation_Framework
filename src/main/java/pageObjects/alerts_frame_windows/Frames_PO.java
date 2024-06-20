package pageObjects.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Base_PO;
import pageObjects.Frames_Methods;
import pageObjects.WebElement_Methods;

public class Frames_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());
    private Frames_Methods framesMethods = new Frames_Methods(Base_PO.getDriver());


    public Frames_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    ///     WebElements         ///

    @FindBy(xpath = "//*[text()='Alerts, Frame & Windows']/ancestor::div[contains(@class,'top-card')]") private WebElement alertsFrameWindowsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Alerts, Frame & Windows']/parent::div") private WebElement alertsFrameWindowsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Frames']/parent::li") private WebElement framesMenu_WebElement;
    @FindBy(xpath = "//iframe[@id='frame1']") private WebElement frame1Body_WebElement;
    @FindBy(xpath = "//iframe[@id='frame2']") private WebElement frame2Body_WebElement;
    @FindBy(xpath = "//*[@id='sampleHeading']") private WebElement frame1Text_WebElement;
    @FindBy(xpath = "//*[@id='sampleHeading']") private WebElement frame2Text_WebElement;
    @FindBy(xpath = "//div[@id='framesWrapper']/descendant::*[text()='Frames']") private WebElement mainPageTitle_WebElement;


    ///     Data        ///

    private String frameTextValue = "This is a sample page";
    private String mainPageTitleValue = "Frames";


    ///     steps       ///

    public void accessFrames() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(alertsFrameWindowsHomePage_WebElement);
        webElementMethods.clickOn(alertsFrameWindowsMenuList_WebElement);
        webElementMethods.clickOn(framesMenu_WebElement);
    }

    public void switchToFrame1() {
        framesMethods.switchToFrame(frame1Body_WebElement);
    }

    public Boolean validateFrame1() {
        return webElementMethods.validateText(frame1Text_WebElement, frameTextValue);
    }

    public void switchToMainPage() {
        framesMethods.switchToMainPage();
    }

    public Boolean validateSwitchToMain() {
        return webElementMethods.validateText(mainPageTitle_WebElement, mainPageTitleValue);
    }

    public void switchToFrame2() {
        framesMethods.switchToFrame(frame2Body_WebElement);
    }

    public Boolean validateFrame2() {
        return webElementMethods.validateText(frame2Text_WebElement, frameTextValue);
    }






}
