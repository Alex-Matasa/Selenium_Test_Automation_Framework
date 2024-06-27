package pages.alerts_frame_windows;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import helperMethods.Frames_Methods;
import helperMethods.WebElement_Methods;

public class NestedFramesPage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods;
    private Frames_Methods framesMethods;
    private Assertion_Methods assertionMethods;


    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webElementMethods = new WebElement_Methods(driver);
        framesMethods = new Frames_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    @FindBy(xpath = "//iframe[@id='frame1']") private WebElement parentFrame_WebElement;
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']") private WebElement childFrame_WebElement;
    @FindBy(xpath = "//body[text()='Parent frame']") private WebElement parentFrameText_WebElement;
    @FindBy(xpath = "//p") private WebElement childFrameText_WebElement;


    public void switchToParentFrame() {
        framesMethods.switchToFrame(parentFrame_WebElement);
    }

    public void switchToChildFrame() {
        framesMethods.switchToFrame(childFrame_WebElement);
    }

    public Boolean validateParentFrame(String expected) {
        return assertionMethods.validateText(parentFrameText_WebElement, expected);
    }
    public Boolean validateChildFrame(String expected) {
        return assertionMethods.validateText(childFrameText_WebElement, expected);
    }

    public void switchToMainPage() {
        framesMethods.switchToMainPage();
    }


}
