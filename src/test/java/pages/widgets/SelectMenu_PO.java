package pages.widgets;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_test.Base_PO;
import helperMethods.WebElement_Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectMenu_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods;
    private Assertion_Methods assertionMethods;

    public SelectMenu_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webElementMethods = new WebElement_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    ///     Web Elements       ///

    @FindBy(xpath = "//div[@id='withOptGroup']/descendant::input") private WebElement selectOption_WebElement;
    @FindBy(xpath = "//div[@id='withOptGroup']/descendant::div[@class=' css-1uccc91-singleValue']") private WebElement selectOptionGetText_WebElement;
    @FindBy(xpath = "//div[@id='selectOne']/descendant::input") private WebElement selectTitle_WebElement;
    @FindBy(xpath = "//div[@id='selectOne']/descendant::div[@class=' css-1uccc91-singleValue']") private WebElement selectTitleGetText_WebElement;
    @FindBy(xpath = "//select[@id='oldSelectMenu']") private WebElement selectColor_WebElement;
    @FindBy(xpath = "//input[@id='react-select-4-input']") private WebElement multiSelect_WebElement;
    @FindBy(xpath = "//div[@class='css-12jo7m5']") private List<WebElement> multiSelectOutput_WebElement;
    @FindBy(xpath = "//select[@id='cars']") private WebElement standardMultiSelect_WebElement;



    ///      Data      ///

    private ArrayList<String> selectOptionValue = new ArrayList<>(Arrays.asList("Group 1, option 1", "Group 1, option 2", "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option"));
    private ArrayList<String> selectTitleValue = new ArrayList<>(Arrays.asList("Dr.", "Mr.", "Mrs.", "Ms.", "Prof.", "Other"));
    private ArrayList<String> colorLisTValues = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo", "Magenta", "Aqua"));
    private ArrayList<String> multiSelectValues = new ArrayList<>(Arrays.asList("Green", "Black", "Blue"));
    private ArrayList<String> standardMultiSelectValues = new ArrayList<>(Arrays.asList("Volvo", "Saab", "Opel", "Audi"));



    ///     steps       ///

//    public void accessSelectMenu() {
//        driver.get("https://demoqa.com/");
//        webElementMethods.clickOn(widgetsHomePage_WebElement);
//        webElementMethods.clickOn(widgetsMenuList_WebElement);
//        webElementMethods.clickOn(widgetsMenuList_WebElement);
//        webElementMethods.clickOnJavaScriptExecutor(selectMenu_WebElement);
//    }

    public void selectValue() {
        webElementMethods.clickOnJavaScriptExecutor(selectOption_WebElement);
        webElementMethods.sendKeys(selectOption_WebElement,selectOptionValue.get(1));
        webElementMethods.keyboardActions(selectOption_WebElement,Keys.ENTER);
    }

    public Boolean validateSelectValue() {
        return assertionMethods.validateText(selectOption_WebElement,selectOptionValue.get(1));
    }

    public void selectTitle() {
        webElementMethods.sendKeys(selectTitle_WebElement, selectTitleValue.get(1));
        webElementMethods.keyboardActions(selectTitle_WebElement, Keys.ENTER);
    }

    public Boolean validateSelectTitle() {

        return assertionMethods.validateText(selectTitleGetText_WebElement, selectTitleValue.get(1));
    }

    public void selectColor() {
        webElementMethods.selectByText(selectColor_WebElement,colorLisTValues.get(10));
    }

    public Boolean validateSelectColor() {

        return webElementMethods.getFirstSelectedOption(selectColor_WebElement).equals(colorLisTValues.get(10));
    }

    public void selectMultiSelect() {
        webElementMethods.clickOnJavaScriptExecutor(multiSelect_WebElement);

        for (String value : multiSelectValues) {
            multiSelect_WebElement.sendKeys(value);
            webElementMethods.keyboardActions(multiSelect_WebElement,Keys.ENTER);
        }
    }

    public Boolean validateMultiSelect() {

        return  assertionMethods.validateText(multiSelectOutput_WebElement,multiSelectValues);
    }

    public void standardMultiSelect() {
        webElementMethods.selectByText(standardMultiSelect_WebElement,standardMultiSelectValues.get(0));
        webElementMethods.selectByText(standardMultiSelect_WebElement,standardMultiSelectValues.get(3));
    }

    public Boolean validateStandardMultiSelect() {
        return true; // needs implementation
    }






}
