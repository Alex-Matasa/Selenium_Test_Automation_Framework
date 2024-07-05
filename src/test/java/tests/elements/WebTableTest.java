package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.WebTablePage;

import java.util.ArrayList;
import java.util.Arrays;

public class WebTableTest {

    private WebDriver driver;
    private HomePage homePage;
    private ElementsPage elementsPage;
    private WebTablePage webTablePage;


    private String firstNameValue = "Ion";
    private String lastNameValue = "Popescu";
    private String emailValue = "popescu.ion@email.com";
    private String ageValue = "30";
    private String salaryValue = "5000";
    private String departmentValue = "IT";
    private ArrayList<String> inputDataList = new ArrayList<>(Arrays.asList(firstNameValue, lastNameValue, ageValue, emailValue, salaryValue, departmentValue));


    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        webTablePage = new WebTablePage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void addEntryValidScenario() {

        driver.get("https://demoqa.com/");
        homePage.navigateToElements();
        elementsPage.navigateToWebTables();

        webTablePage.clickOnAddButton();
        webTablePage.enterFirstName(firstNameValue);
        webTablePage.enterLastName(lastNameValue);
        webTablePage.enterEmail(emailValue);
        webTablePage.enterAge(ageValue);
        webTablePage.enterSalary(salaryValue);
        webTablePage.enterDepartment(departmentValue);
        webTablePage.clickOnSubmit();
        Assert.assertTrue(webTablePage.validateTest(inputDataList));
    }



}
