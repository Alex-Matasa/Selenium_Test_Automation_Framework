package helperMethods;

import org.openqa.selenium.WebDriver;

import java.util.Iterator;
import java.util.Set;

public class MultipleWindows_Methods {

    private WebDriver driver;

    public MultipleWindows_Methods(WebDriver driver) {
        this.driver = driver;
    }


    public void switchToChildWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentIdWindow = iterator.next();
        String childIdWindow = iterator.next();

        driver.switchTo().window(childIdWindow);
    }

    public void switchToParentWindow() {
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();

        driver.switchTo().window(parentWindow);
    }

    public void switchToMain() {
        switchToMain();
    }







}
