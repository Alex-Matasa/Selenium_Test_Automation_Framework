package pages;

import helperMethods.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public WebDriver driver;
    public WebElement_Methods webElementMethods;
    public Alert_Methods alertMethods;
    public Assertion_Methods assertionMethods;
    public Actions_Methods actionsMethods;
    public Frames_Methods framesMethods;
    public MultipleWindows_Methods multipleWindowsMethods;
    public Page_Methods pageMethods;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        webElementMethods = new WebElement_Methods(driver);
        alertMethods = new Alert_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
        actionsMethods = new Actions_Methods(driver);
        framesMethods = new Frames_Methods(driver);
        multipleWindowsMethods = new MultipleWindows_Methods(driver);
        pageMethods = new Page_Methods(driver);
    }



}
