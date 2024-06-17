package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base_PO;
import pageObjects.WebElement_Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadioButton_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());

    public RadioButton_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    ///     Web Elements        ///

    @FindBy(xpath = "//*[text()='Elements']/ancestor::div[contains(@class,'top-card')]") private WebElement elementsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Elements']/parent::div") private WebElement elementsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Radio Button']/parent::li") private WebElement radioButtonMenu_WebElement;
    @FindBy(xpath = "//input[@type='radio']/following-sibling::label") private List<WebElement> radioButtonInput_WebElement;
    @FindBy(xpath = "//*[@class='text-success']") private WebElement selectionConfirmed_WebElement;


    ///      Data      ////

    private ArrayList<String> radioButtonsIdValueList = new ArrayList<>(Arrays.asList("Impressive", "Yes", "No"));


    /////     steps     /////

    public void accessRadioButton() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(elementsHomePage_WebElement);
        webElementMethods.clickOn(elementsMenuList_WebElement);
        webElementMethods.clickOn(radioButtonMenu_WebElement);
    }

    public void clickOnRadioButtons() {

        for (Integer i = 0; i < radioButtonsIdValueList.size(); i++) {

            for(Integer j = 0; j < radioButtonInput_WebElement.size(); j++) {

                if(radioButtonInput_WebElement.get(j).getText().equals("No")) continue;

                if(radioButtonInput_WebElement.get(j).getText().equals(radioButtonsIdValueList.get(i))) {
                    webElementMethods.clickOn(radioButtonInput_WebElement.get(j));
                }
            }
        }
    }

    public Boolean validateTest() {

        Boolean isValid = true;

        for (Integer i = 0; i < radioButtonsIdValueList.size(); i++) {

            for(Integer j = 0; j < radioButtonInput_WebElement.size(); j++) {

                if(radioButtonInput_WebElement.get(j).getText().equals("No")) continue;

                if(radioButtonInput_WebElement.get(j).getText().equals(radioButtonsIdValueList.get(i))) {
                    webElementMethods.clickOn(radioButtonInput_WebElement.get(j));
                    if(!radioButtonInput_WebElement.get(j).getText().equals(selectionConfirmed_WebElement.getText())){
                        isValid = false;
                    }
                }
            }
        }
        return isValid;
    }





}
