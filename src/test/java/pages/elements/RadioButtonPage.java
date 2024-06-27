package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base_test.Base_PO;
import helperMethods.WebElement_Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RadioButtonPage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());

    public RadioButtonPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@type='radio']/following-sibling::label") private List<WebElement> radioButtonInput_WebElement;
    @FindBy(xpath = "//*[@class='text-success']") private WebElement selectionConfirmed_WebElement;


    public void clickOnRadioButtons(ArrayList expected) {

        for (Integer i = 0; i < expected.size(); i++) {

            for(Integer j = 0; j < radioButtonInput_WebElement.size(); j++) {

                if(radioButtonInput_WebElement.get(j).getText().equals("No")) continue;

                if(radioButtonInput_WebElement.get(j).getText().equals(expected.get(i))) {
                    webElementMethods.clickOn(radioButtonInput_WebElement.get(j));
                }
            }
        }
    }

    public Boolean validateTest(ArrayList expected) {

        Boolean isValid = true;

        for (Integer i = 0; i < expected.size(); i++) {

            for(Integer j = 0; j < radioButtonInput_WebElement.size(); j++) {

                if(radioButtonInput_WebElement.get(j).getText().equals("No")) continue;

                if(radioButtonInput_WebElement.get(j).getText().equals(expected.get(i))) {
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
