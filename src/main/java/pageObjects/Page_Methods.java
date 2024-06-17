package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class Page_Methods {

    private WebDriver driver;

    public Page_Methods(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollPage(Integer x, Integer y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy("+x+","+y+")", "");
    }
}
