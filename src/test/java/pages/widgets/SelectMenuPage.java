package pages.widgets;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helperMethods.WebElement_Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectMenuPage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods;
    private Assertion_Methods assertionMethods;

    public SelectMenuPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webElementMethods = new WebElement_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    @FindBy(xpath = "//div[@id='withOptGroup']/descendant::input") private WebElement selectOption_WebElement;
    @FindBy(xpath = "//div[@id='withOptGroup']/descendant::div[@class=' css-1uccc91-singleValue']") private WebElement selectOptionGetText_WebElement;
    @FindBy(xpath = "//div[@id='selectOne']/descendant::input") private WebElement selectTitle_WebElement;
    @FindBy(xpath = "//div[@id='selectOne']/descendant::div[@class=' css-1uccc91-singleValue']") private WebElement selectTitleGetText_WebElement;
    @FindBy(xpath = "//select[@id='oldSelectMenu']") private WebElement selectColor_WebElement;
    @FindBy(xpath = "//input[@id='react-select-4-input']") private WebElement multiSelect_WebElement;
    @FindBy(xpath = "//div[@class='css-12jo7m5']") private List<WebElement> multiSelectOutput_WebElement;
    @FindBy(xpath = "//select[@id='cars']") private WebElement standardMultiSelect_WebElement;



    public void selectValue(String value) {
        webElementMethods.clickOnJavaScriptExecutor(selectOption_WebElement);
        webElementMethods.sendKeys(selectOption_WebElement,value);
        webElementMethods.keyboardActions(selectOption_WebElement,Keys.ENTER);
    }

    public Boolean validateSelectValue(String expectedValue) {
        return assertionMethods.validateText(selectOptionGetText_WebElement, expectedValue);
    }

    public void selectTitle(String value) {
        webElementMethods.sendKeys(selectTitle_WebElement, value);
        webElementMethods.keyboardActions(selectTitle_WebElement, Keys.ENTER);
    }

    public Boolean validateSelectTitle(String expectedValue) {

        return assertionMethods.validateText(selectTitleGetText_WebElement, expectedValue);
    }

    public void selectColor(String color) {
        webElementMethods.selectByText(selectColor_WebElement,color);
    }

    public Boolean validateSelectColor(String expectedValue) {

        return webElementMethods.getFirstSelectedOption(selectColor_WebElement).equals(expectedValue);
    }

    public void selectMultiSelect(ArrayList<String> colors) {
        webElementMethods.clickOnJavaScriptExecutor(multiSelect_WebElement);

        for (String color : colors) {
            multiSelect_WebElement.sendKeys(color);
            webElementMethods.keyboardActions(multiSelect_WebElement,Keys.ENTER);
        }

        webElementMethods.keyboardActions(multiSelect_WebElement, Keys.ESCAPE);
    }

    public Boolean validateMultiSelect(ArrayList<String> selectedColors) {

        return  assertionMethods.validateText(multiSelectOutput_WebElement,selectedColors);
    }

    public void standardMultiSelect(ArrayList<String> listValues) {
        webElementMethods.selectByValue(standardMultiSelect_WebElement, listValues);
    }

    public Boolean validateStandardMultiSelect() {
        return true; // needs implementation
    }






}
