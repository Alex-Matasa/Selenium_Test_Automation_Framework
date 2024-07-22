package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import helperMethods.WebElement_Methods;
import org.openqa.selenium.support.PageFactory;

public class FormsPage extends BasePage {

    public FormsPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//div[text()='Forms']/parent::div")
    private WebElement formsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Practice Form']/parent::li")
    private WebElement practiceForm_WebElement;


    public void navigateToPracticeForm() {
        webElementMethods.clickOn(practiceForm_WebElement);
    }


}
