package base_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base_PO {

    private static WebDriver driver;

    public Base_PO() {

    }

    private static WebDriver createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        return driver;
    }

    public static WebDriver getDriver() {

        if(driver == null) {
            driver = createDriver();
        }
        return driver;
    }

    public static void cleanUpDriver() {

        if(driver!= null) {
            driver.quit();
            driver = null;
        }

    }


}
