package pages.alerts_frame_windows;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class BrowserWindowsPage extends BasePage {

    public BrowserWindowsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div/button[text()='New Tab']")
    private WebElement newTabButton_WebElement;
    @FindBy(xpath = "//*[text()='This is a sample page']")
    private WebElement newTabConfirmationText_WebElement;
    @FindBy(xpath = "//div/button[text()='New Window']")
    private WebElement newWindowButton_WebElement;
    @FindBy(xpath = "//*[text()='This is a sample page']")
    private WebElement newWindowConfirmationText_WebElement;


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
