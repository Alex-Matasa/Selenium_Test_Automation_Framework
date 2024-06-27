package helperMethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Frames_Methods {

    private WebDriver driver;

    public Frames_Methods (WebDriver driver) {
        this.driver = driver;
    }


    public void switchToFrame(String idOrName) {
        driver.switchTo().frame(idOrName);
    }

    public void switchToFrame(WebElement webElement) {
        driver.switchTo().frame(webElement);
    }

    public void switchToMainPage() {
        driver.switchTo().defaultContent();
    }


}
