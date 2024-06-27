package helperMethods;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Alert_Methods {

    private WebDriver driver;

    public Alert_Methods(WebDriver driver) {
        this.driver = driver;
    }


    public void waitForAlert() {
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.alertIsPresent());
    }

    public void acceptAlert() {
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public void dismissAlert() {
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void sendKeys(String text) {
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
    }

    public String getTextAlert() {
        waitForAlert();
        Alert alert = driver.switchTo().alert();
        return  alert.getText();
    }

}
