package tests.widgets;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.Base_PO;
import pageObjects.widgets.DatePicker_PO;


public class DatePicker_Test {

    private WebDriver driver;
    private DatePicker_PO datePickerPo;

    @BeforeTest
    public void setUp()  {
        driver = Base_PO.getDriver();
        datePickerPo = new DatePicker_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        datePickerPo.accessDatePicker();
        datePickerPo.clickOnSelectDateField();
        datePickerPo.selectMonthAndYearByDropdown();
        datePickerPo.selectDay();
        Assert.assertTrue(datePickerPo.dateIsCorrectlySelected());

        datePickerPo.clickOnSelectDateField();
        datePickerPo.selectMonthAndYearByArrow();
        datePickerPo.selectDay();
        Assert.assertTrue(datePickerPo.dateIsCorrectlySelected());

    }








}
