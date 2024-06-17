package pageObjects.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base_PO;
import pageObjects.WebElement_Methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebTable_PO  {

    private WebDriver driver;
    WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());

    public WebTable_PO (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    //      Registration Form Elements      //

    @FindBy(xpath = "//label[text()='First Name']/parent::div/following-sibling::div/input") private WebElement firstName_WebElement;
    @FindBy(xpath = "//label[text()='Last Name']/parent::div/following-sibling::div/input") private WebElement lastName_WebElement;
    @FindBy(xpath = "//label[text()='Email']/parent::div/following-sibling::div/input") private WebElement userEmail_WebElement;
    @FindBy(xpath = "//label[text()='Age']/parent::div/following-sibling::div/input") private WebElement age_WebElement;
    @FindBy(xpath = "//label[text()='Salary']/parent::div/following-sibling::div/input") private WebElement salary_WebElement;
    @FindBy(xpath = "//label[text()='Department']/parent::div/following-sibling::div/input") private WebElement department_WebElement;
    @FindBy(xpath = "//button[text()='Submit']") private WebElement submit_WebElement;


    //      Web Tables Elements     //

    @FindBy(xpath = "//*[text()='Elements']/ancestor::div[contains(@class,'top-card')]") private WebElement elementsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Elements']/parent::div") private WebElement elementsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Web Tables']/parent::li") private WebElement webTablesMenu_WebElement;
    @FindBy(xpath = "//*[@type='button' and text()='Add']") private WebElement addEntryButton_WebElement;
    @FindBy(xpath = "//div[contains(@class, '-padRow')][1]/parent::div/preceding-sibling::div[1]/div[not(contains(@class, '-padRow'))]/div [text() != '']")
    private List <WebElement> lastEntryAddedList_WebElement;



    //       Data      //

    private String firstNameValue = "Ion";
    private String lastNameValue = "Popescu";
    private String emailValue = "popescu.ion@email.com";
    private String ageValue = "30";
    private String salaryValue = "5000";
    private String departmentValue = "IT";
    private ArrayList<String> inputDataList = new ArrayList<>(Arrays.asList(firstNameValue, lastNameValue, ageValue, emailValue, salaryValue, departmentValue));


    ///     steps       ///
    
    public void accessWebTable() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(elementsHomePage_WebElement);
        webElementMethods.clickOn(elementsMenuList_WebElement);
        webElementMethods.clickOnJavaScriptExecutor(webTablesMenu_WebElement);
    }

    public void clickOnAddButton() {
        webElementMethods.clickOn(addEntryButton_WebElement);
    }

    public void enterFirstName() {
        webElementMethods.sendKeys(firstName_WebElement,firstNameValue);
    }

    public void enterLastName() {
        webElementMethods.sendKeys(lastName_WebElement, lastNameValue);
    }

    public void enterEmail() {
        webElementMethods.sendKeys(userEmail_WebElement, emailValue);
    }

    public void enterAge() {
        webElementMethods.sendKeys(age_WebElement, ageValue);
    }

    public void enterSalary() {
        webElementMethods.sendKeys(salary_WebElement, salaryValue);
    }

    public void enterDepartment() {
        webElementMethods.sendKeys(department_WebElement, departmentValue);
    }

    public void clickOnSubmit () {
        webElementMethods.clickOn(submit_WebElement);
    }

    public Boolean validateTest() {

        return webElementMethods.validateText(lastEntryAddedList_WebElement, inputDataList);
    }





}


























