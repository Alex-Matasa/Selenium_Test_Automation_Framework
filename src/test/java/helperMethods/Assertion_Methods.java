package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Assertion_Methods {

    private WebDriver driver;

    public Assertion_Methods(WebDriver driver) {
        this.driver = driver;
    }

    public void waitToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(element));
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

    public Boolean elementIsDisplayed(WebElement webElement) {
        waitToBeVisible(webElement);
        return webElement.isDisplayed();
    }

}
