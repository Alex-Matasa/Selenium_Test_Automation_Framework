package tests.widgets;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_test.Base_Test;
import pages.HomePage;
import pages.WidgetsPage;
import pages.widgets.DatePickerPage;


public class DatePicker_Test extends Base_Test {

    private WebDriver driver = getDriver();

    private HomePage homePage = new HomePage(driver);
    private WidgetsPage widgetsPage = new WidgetsPage(driver);
    private DatePickerPage datePickerPage = new DatePickerPage(driver);


        ///         Data        ////

    private String monthValue = "May";
    private String yearValue = "2020";
    private String dayValue = "1";


    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        homePage.navigateToWidgets();
        widgetsPage.navigateToDatePicker();

        datePickerPage.clickOnSelectDateField();
        datePickerPage.selectMonthAndYearByDropdown(monthValue, yearValue);
        datePickerPage.selectDay(dayValue);
        Assert.assertTrue(datePickerPage.dateIsCorrectlySelected(getDateValue(dayValue, monthValue, yearValue)));

        datePickerPage.clickOnSelectDateField();
        datePickerPage.selectMonthAndYearByArrow(yearValue, monthValue);
        datePickerPage.selectDay(dayValue);
        Assert.assertTrue(datePickerPage.dateIsCorrectlySelected(getDateValue(dayValue, monthValue, yearValue)));

    }


    private String getDateValue(String day, String month, String year) {

        switch (day) {
            case "1":
                day = "01";
                break;
            case "2":
                day = "02";
                break;
            case "3":
                day = "03";
                break;
            case "4":
                day = "04";
                break;
            case "5":
                day = "05";
                break;
            case "6":
                day = "06";
                break;
            case "7":
                day = "07";
                break;
            case "8":
                day = "08";
                break;
            case "9":
                day = "09";
                break;
        }

        return switch (month) {
            case "January" -> "01/" + day + "/" + year;
            case "February" -> "02/" + day + "/" + year;
            case "March" -> "03/" + day + "/" + year;
            case "April" -> "04/" + day + "/" + year;
            case "May" -> "05/" + day + "/" + year;
            case "June" -> "06/" + day + "/" + year;
            case "July" -> "07/" + day + "/" + year;
            case "August" -> "08/" + day + "/" + year;
            case "September" -> "09/" + day + "/" + year;
            case "October" -> "10/" + day + "/" + year;
            case "November" -> "11/" + day + "/" + year;
            case "December" -> "12/" + day + "/" + year;
            default -> "Invalid data";
        };

    }










}
