package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WebElement_Methods {

    private WebDriver driver;

    public WebElement_Methods(WebDriver driver) {
        this.driver = driver;
    }


    public void waitToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void clickOn(WebElement element) {
        waitToBeVisible(element);
        element.click();
    }

    public void clickOnWhenMatched(List<WebElement> webElementList, String targetValue) {
        for (Integer index = 0; index < webElementList.size(); index++) {

            if (webElementList.get(index).getText().equals(targetValue)) {
                clickOn(webElementList.get(index));
                break;
            }
        }
    }

    public void clickOnMultiple(List<WebElement> webElementList, ArrayList<String> stringArrayList) {
        for (WebElement webElement : webElementList) {
            if(stringArrayList.contains(webElement.getText())) {
                clickOn(webElement);
            }
        }
    }

    public void clickOnJavaScriptExecutor(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",element);
    }

    public void sendKeys(WebElement element, String value) {
        waitToBeVisible(element);
        element.sendKeys(value);
    }

    public void clearAndSendKeys(WebElement element, String value) {
        element.clear();
        element.sendKeys();
    }

    public void keyboardActions(WebElement element, Keys action) {
        element.sendKeys(action);
    }

    public void selectByText(WebElement element, String text) {
        waitToBeVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }

    public void selectByValue(WebElement element, String value) {
        waitToBeVisible(element);
        Select select = new Select(element);
        select.selectByVisibleText(value);
    }

    public String getFirstSelectedOption(WebElement element) {
        waitToBeVisible(element);
        Select select = new Select(element);

        return select.getFirstSelectedOption().getText();
    }

    public ArrayList<String> getAllSelectedOptions(WebElement element) {
        waitToBeVisible(element);
        Select select = new Select(element);

        List<WebElement> webElementList = select.getAllSelectedOptions();

        Iterator<WebElement> iterator = webElementList.iterator();

        ArrayList<String> arrayList = new ArrayList<>();

        for(WebElement item : webElementList) {
            arrayList.add(iterator.next().getText());
        }

        return arrayList;
    }


    ///     assertions      ///

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

    public Boolean elementIsDisplayed(WebElement element) {
        waitToBeVisible(element);
        return element.isDisplayed();
    }



}
