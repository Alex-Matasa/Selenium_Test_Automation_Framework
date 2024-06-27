package pages.elements;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import helperMethods.WebElement_Methods;

import java.util.ArrayList;
import java.util.List;

public class WebTablePage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods;
    private Assertion_Methods assertionMethods;

    public WebTablePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
        webElementMethods = new WebElement_Methods(driver);
        assertionMethods = new Assertion_Methods(driver);
    }


    //      Registration Form Elements      //

    @FindBy(xpath = "//label[text()='First Name']/parent::div/following-sibling::div/input") private WebElement firstName_WebElement;
    @FindBy(xpath = "//label[text()='Last Name']/parent::div/following-sibling::div/input") private WebElement lastName_WebElement;
    @FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::div/input") private WebElement userEmail_WebElement;
    @FindBy(xpath = "//label[text()='Age']/parent::div/following-sibling::div/input") private WebElement age_WebElement;
    @FindBy(xpath = "//label[text()='Salary']/parent::div/following-sibling::div/input") private WebElement salary_WebElement;
    @FindBy(xpath = "//label[text()='Department']/parent::div/following-sibling::div/input") private WebElement department_WebElement;
    @FindBy(xpath = "//button[text()='Submit']") private WebElement submit_WebElement;


    //      WebTablesPage Elements     //

    @FindBy(xpath = "//*[@type='button' and text()='Add']") private WebElement addEntryButton_WebElement;
    @FindBy(xpath = "//div[contains(@class, '-padRow')][1]/parent::div/preceding-sibling::div[1]/div[not(contains(@class, '-padRow'))]/div [text() != '']")
    private List <WebElement> lastEntryAddedList_WebElement;



    public void clickOnAddButton() {
        webElementMethods.clickOn(addEntryButton_WebElement);
    }

    public void enterFirstName(String firstName) {
        webElementMethods.sendKeys(firstName_WebElement,firstName);
    }

    public void enterLastName(String lastName) {
        webElementMethods.sendKeys(lastName_WebElement, lastName);
    }

    public void enterEmail(String email) {
        webElementMethods.sendKeys(userEmail_WebElement, email);
    }

    public void enterAge(String age) {
        webElementMethods.sendKeys(age_WebElement, age);
    }

    public void enterSalary(String salary) {
        webElementMethods.sendKeys(salary_WebElement, salary);
    }

    public void enterDepartment(String department) {
        webElementMethods.sendKeys(department_WebElement, department);
    }

    public void clickOnSubmit () {
        webElementMethods.clickOn(submit_WebElement);
    }

    public Boolean validateTest(ArrayList inputData) {

        return assertionMethods.validateText(lastEntryAddedList_WebElement, inputData);
    }





}


























