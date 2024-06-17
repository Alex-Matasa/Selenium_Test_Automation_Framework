package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base_PO;
import pageObjects.WebElement_Methods;
import pageObjects.Page_Methods;

public class Buttons_PO {

    private WebDriver driver;
    private Page_Methods pageMethods = new Page_Methods(Base_PO.getDriver());
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());



    public Buttons_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    ///     Web Elements        ///

    @FindBy(xpath = "//*[text()='Elements']/ancestor::div[contains(@class,'top-card')]") private WebElement elementsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Elements']/parent::div") private WebElement elementsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Buttons']/parent::li") private WebElement buttonsMenu_WebElement;
    @FindBy(xpath = "//button[text()='Double Click Me']") private WebElement doubleClickMeButton_WebElement;
    @FindBy(xpath = "//p[text()='You have done a double click']") private WebElement doubleClickMeConfirmation_WebElement;
    @FindBy(xpath = "//button[text()='Right Click Me']") private WebElement rightClickMeButton_WebElement;
    @FindBy(xpath = "//p[text()='You have done a right click']") private WebElement rightClickMeConfirmation_WebElement;
    @FindBy(xpath = "//button[text()='Click Me']") private WebElement clickMeButton_WebElement;
    @FindBy(xpath = "//p[text()='You have done a dynamic click']") private WebElement clickMeConfirmation_WebElement;


    ///      Data      ////

    private String doubleClickMeMessageConfirmationValue = "You have done a double click";
    private String rightClickMeMessageConfirmationValue = "You have done a right click";
    private String clickMeMessageConfirmationValue = "You have done a dynamic click";


    /////     steps /////

    public void accessButtons() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(elementsHomePage_WebElement);
        pageMethods.scrollPage(0, 360);
        webElementMethods.clickOn(buttonsMenu_WebElement);
    }

    public void doubleClickOnDoubleClickButton() {
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickMeButton_WebElement).perform();
    }

    public void rightClickOnRightClickButton() {
        pageMethods.scrollPage(0,150);
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMeButton_WebElement).perform();
    }

    public void clickOnClickMeButton() {
        webElementMethods.clickOn(clickMeButton_WebElement);
    }


    public Boolean validateDoubleClickButton() {
        return webElementMethods.validateText(doubleClickMeConfirmation_WebElement, doubleClickMeMessageConfirmationValue);
    }

    public Boolean validateRightClickButton() {
        return webElementMethods.validateText(rightClickMeConfirmation_WebElement, rightClickMeMessageConfirmationValue);
    }

    public Boolean validateClickMeButton() {
        return webElementMethods.validateText(clickMeConfirmation_WebElement, clickMeMessageConfirmationValue);
    }




}
