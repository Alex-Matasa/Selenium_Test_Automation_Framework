package tests.elements;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.elements.WebTable_PO;

public class WebTableTest extends Base_PO {

    private WebDriver driver;
    private WebTable_PO webTable_po;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        webTable_po = new WebTable_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void addEntryValidScenario() {

        webTable_po.accessWebTable();
        webTable_po.clickOnAddButton();
        webTable_po.enterFirstName();
        webTable_po.enterLastName();
        webTable_po.enterEmail();
        webTable_po.enterAge();
        webTable_po.enterSalary();
        webTable_po.enterDepartment();
        webTable_po.clickOnSubmit();
        Assert.assertTrue(webTable_po.validateTest());

    }



}
