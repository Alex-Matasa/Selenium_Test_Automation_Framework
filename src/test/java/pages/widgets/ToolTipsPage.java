package pages.widgets;

import helperMethods.Actions_Methods;
import helperMethods.Assertion_Methods;
import helperMethods.Page_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ToolTipsPage {

    WebDriver driver;
    Actions_Methods actionsMethods;
    Assertion_Methods assertionMethods;
    Page_Methods pageMethods;

    public ToolTipsPage(WebDriver driver) {
        this.driver = driver;
        this.actionsMethods = new Actions_Methods(driver);
        this.assertionMethods = new Assertion_Methods(driver);
        this.pageMethods = new Page_Methods(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//button[@id='toolTipButton']")
    private WebElement hoverMeToSeeButton_WebElement;

    @FindBy(xpath = "//input[@id='toolTipTextField']")
    private WebElement hoverMeToSeeField_WebElement;

    @FindBy(xpath = "//button[@aria-describedby='buttonToolTip']")
    private WebElement hoverMeToSeeBUttonDescription_WebElement;

    @FindBy(xpath = "//input[@aria-describedby='textFieldToolTip']")
    private WebElement hoverMeToSeeTextFieldDescription_WebElement;

    @FindBy(xpath = "//div/a[text()='Contrary']")
    private WebElement contraryText_WebElement;

    @FindBy(xpath = "//div/a[@aria-describedby='contraryTexToolTip']")
    private WebElement contraryTextDescription_WebElement;

    @FindBy(xpath = "//div/a[text()='1.10.32']")
    private WebElement sectionText_WebElement;

    @FindBy(xpath = "//div/a[@aria-describedby='sectionToolTip']")
    private WebElement sectionTexxDescription_WebElement;



    public void hoverOnButton() {
        pageMethods.scrollPage(0, 150);
        actionsMethods.hover(hoverMeToSeeButton_WebElement);
    }

    public Boolean validateHoverOnButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(hoverMeToSeeBUttonDescription_WebElement));
        return assertionMethods.elementIsDisplayed(hoverMeToSeeBUttonDescription_WebElement);
    }

    public void hoverOnTextField() {
        actionsMethods.hover(hoverMeToSeeField_WebElement);
    }

    public Boolean validateHoverOnTextField() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(hoverMeToSeeTextFieldDescription_WebElement));
        return assertionMethods.elementIsDisplayed(hoverMeToSeeTextFieldDescription_WebElement);
    }

    public void hoverOnContraryText() {
        actionsMethods.hover(contraryText_WebElement);
    }

    public Boolean validateHoverOnContraryText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(contraryTextDescription_WebElement));
        return assertionMethods.elementIsDisplayed(contraryTextDescription_WebElement);
    }

    public void hoverOnSectionText() {
        actionsMethods.hover(sectionText_WebElement);
    }

    public Boolean validateHoverOnSectionText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(sectionTexxDescription_WebElement));
        return assertionMethods.elementIsDisplayed(sectionTexxDescription_WebElement);
    }


}
