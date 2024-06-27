package pages.alerts_frame_windows;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helperMethods.Frames_Methods;
import helperMethods.WebElement_Methods;

public class FramesPage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods;
    private Frames_Methods framesMethods;
    private Assertion_Methods assertionMethods;


    public FramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webElementMethods = new WebElement_Methods(driver);
        framesMethods = new Frames_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    @FindBy(xpath = "//iframe[@id='frame1']") private WebElement frame1Body_WebElement;
    @FindBy(xpath = "//iframe[@id='frame2']") private WebElement frame2Body_WebElement;
    @FindBy(xpath = "//*[@id='sampleHeading']") private WebElement frame1Text_WebElement;
    @FindBy(xpath = "//*[@id='sampleHeading']") private WebElement frame2Text_WebElement;


    public void switchToFrame1() {
        framesMethods.switchToFrame(frame1Body_WebElement);
    }

    public Boolean validateFrame1(String expected) {
        return assertionMethods.validateText(frame1Text_WebElement, expected);
    }

    public void switchToMainPage() {
        framesMethods.switchToMainPage();
    }

    public void switchToFrame2() {
        framesMethods.switchToFrame(frame2Body_WebElement);
    }

    public Boolean validateFrame2(String expected) {
        return assertionMethods.validateText(frame2Text_WebElement, expected);
    }






}
