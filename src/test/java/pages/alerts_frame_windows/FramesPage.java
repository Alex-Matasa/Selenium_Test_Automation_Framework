package pages.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class FramesPage extends BasePage {

    public FramesPage(WebDriver driver) {
        super(driver);
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
