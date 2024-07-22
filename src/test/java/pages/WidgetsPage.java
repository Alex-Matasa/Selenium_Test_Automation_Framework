package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helperMethods.WebElement_Methods;
import org.openqa.selenium.support.PageFactory;

public class WidgetsPage extends BasePage{

    public WidgetsPage(WebDriver driver) {
       super(driver);

    }


    @FindBy(xpath = "//div[text()='Widgets']/parent::div")
    private WebElement widgetsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Date Picker']/parent::li")
    private WebElement datePicker_WebElement;
    @FindBy(xpath = "//*[text()='Select Menu']/parent::li")
    private WebElement selectMenu_WebElement;


    public void navigateToDatePicker() {
        webElementMethods.clickOn(datePicker_WebElement);
    }

    public void navigateToSelectMenu() {
        webElementMethods.clickOnJavaScriptExecutor(selectMenu_WebElement);
    }



}
