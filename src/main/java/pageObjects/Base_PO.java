package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Base_PO {

    private static WebDriver driver;

    public Base_PO() {

    }

    private static WebDriver createDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
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
//            driver.quit();
            driver = null;
        }

    }


}
