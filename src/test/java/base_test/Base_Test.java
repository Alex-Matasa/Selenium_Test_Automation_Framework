package base_test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class Base_Test {

    private static WebDriver driver;

    @BeforeTest
    public void setUp() {

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.get("https://demoqa.com");
    }

    @AfterTest
    public void tearDown() {
        cleanUpDriver();
    }

    private static WebDriver createDriver() {
        driver = new ChromeDriver();

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
