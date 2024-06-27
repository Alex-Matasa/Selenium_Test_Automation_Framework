package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Assertion_Methods {

    private WebDriver driver;

    public Assertion_Methods(WebDriver driver) {
        this.driver = driver;
    }


    public Boolean validateText(WebElement element, String expected) {
        return element.getText().equals(expected);
    }

    public Boolean validateText(List<WebElement> webElementList, ArrayList<String> valuesArrayList) {
        Boolean isValid = true;

        for (Integer index = 0; index < webElementList.size(); index ++) {
            if (!webElementList.get(index).getText().equals(valuesArrayList.get(index))) {
                isValid = false;
            }
        }
        return isValid;
    }
}
