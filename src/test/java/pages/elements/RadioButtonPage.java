package pages.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class RadioButtonPage extends BasePage {

    public RadioButtonPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@type='radio']/following-sibling::label")
    private List<WebElement> radioButtonInput_WebElement;
    @FindBy(xpath = "//*[@class='text-success']")
    private WebElement selectionConfirmed_WebElement;


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
