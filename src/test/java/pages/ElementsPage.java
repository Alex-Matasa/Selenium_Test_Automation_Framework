package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ElementsPage extends BasePage {


    public ElementsPage (WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[text()='Elements']/parent::div")
    private WebElement elementsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Text Box']/parent::li")
    private WebElement textBox_WebElement;
    @FindBy(xpath = "//*[text()='Radio Button']/parent::li")
    private WebElement radioButton_WebElement;
    @FindBy(xpath = "//*[text()='Web Tables']/parent::li")
    private WebElement webTables_WebElement;
    @FindBy(xpath = "//*[text()='Buttons']/parent::li")
    private WebElement buttons_WebElement;
    @FindBy(xpath = "//span[text()='Buttons']")
    private WebElement buttons_WebElement_v2;


    public void navigateToTextBox () {
        webElementMethods.clickOn(textBox_WebElement);
    }

    public void navigateToRadioButton () {
        webElementMethods.clickOn(radioButton_WebElement);
    }

    public void navigateToWebTables() {
        webElementMethods.clickOn(webTables_WebElement);
    }

    public void navigateToButtons () {
        webElementMethods.clickOn(buttons_WebElement_v2);
    }







}
