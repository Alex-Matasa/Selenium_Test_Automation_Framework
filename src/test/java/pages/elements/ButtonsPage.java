package pages.elements;

import helperMethods.Actions_Methods;
import helperMethods.Assertion_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helperMethods.WebElement_Methods;
import helperMethods.Page_Methods;

public class ButtonsPage {

    private WebDriver driver;
    private Page_Methods pageMethods;
    private WebElement_Methods webElementMethods;
    private Actions_Methods actionsMethods;
    private Assertion_Methods assertionMethods;



    public ButtonsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageMethods = new Page_Methods(driver);
        webElementMethods = new WebElement_Methods(driver);
        actionsMethods = new Actions_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    @FindBy(xpath = "//button[text()='Double Click Me']") private WebElement doubleClickMeButton_WebElement;
    @FindBy(xpath = "//p[text()='You have done a double click']") private WebElement doubleClickMeConfirmation_WebElement;
    @FindBy(xpath = "//button[text()='Right Click Me']") private WebElement rightClickMeButton_WebElement;
    @FindBy(xpath = "//p[text()='You have done a right click']") private WebElement rightClickMeConfirmation_WebElement;
    @FindBy(xpath = "//button[text()='Click Me']") private WebElement clickMeButton_WebElement;
    @FindBy(xpath = "//p[text()='You have done a dynamic click']") private WebElement clickMeConfirmation_WebElement;



    public void doubleClickOnDoubleClickButton() {
        actionsMethods.doubleClick(doubleClickMeButton_WebElement);
    }

    public void rightClickOnRightClickButton() {
        pageMethods.scrollPage(0,150);
        actionsMethods.rightClick(rightClickMeButton_WebElement);
    }

    public void clickOnClickMeButton() {
        webElementMethods.clickOn(clickMeButton_WebElement);
    }

    public Boolean validateDoubleClickButton(String expected) {
        return assertionMethods.validateText(doubleClickMeConfirmation_WebElement, expected);
    }

    public Boolean validateRightClickButton(String expected) {
        return assertionMethods.validateText(rightClickMeConfirmation_WebElement, expected);
    }

    public Boolean validateClickMeButton(String expected) {
        return assertionMethods.validateText(clickMeConfirmation_WebElement, expected);
    }




}
