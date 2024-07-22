package pages.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class NestedFramesPage extends BasePage {

    public NestedFramesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//iframe[@id='frame1']")
    private WebElement parentFrame_WebElement;
    @FindBy(xpath = "//iframe[@srcdoc='<p>Child Iframe</p>']")
    private WebElement childFrame_WebElement;
    @FindBy(xpath = "//body[text()='Parent frame']")
    private WebElement parentFrameText_WebElement;
    @FindBy(xpath = "//p")
    private WebElement childFrameText_WebElement;


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
