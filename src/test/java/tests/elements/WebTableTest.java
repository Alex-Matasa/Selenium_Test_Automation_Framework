package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.ElementsPage;
import pages.HomePage;
import pages.elements.WebTablePage;

import java.util.ArrayList;
import java.util.Arrays;

public class WebTableTest extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private ElementsPage elementsPage = new ElementsPage(driver);
    private WebTablePage webTablePage = new WebTablePage(driver);


            ///     Data        ///

    private String firstNameValue = "Ion";
    private String lastNameValue = "Popescu";
    private String emailValue = "popescu.ion@email.com";
    private String ageValue = "30";
    private String salaryValue = "5000";
    private String departmentValue = "IT";
    private ArrayList<String> inputDataList = new ArrayList<>(Arrays.asList(firstNameValue, lastNameValue, ageValue, emailValue, salaryValue, departmentValue));


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
