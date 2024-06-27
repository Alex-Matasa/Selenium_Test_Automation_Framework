package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Actions_Methods {

    private WebDriver driver;
    private Actions actions;

    public Actions_Methods (WebDriver driver) {
        this.driver = driver;
        actions = new Actions(driver);
    }


    public void doubleClick(WebElement element) {
        actions.doubleClick(element).perform();
    }

    public void rightClick(WebElement element) {
        actions.contextClick(element).perform();
    }




}
