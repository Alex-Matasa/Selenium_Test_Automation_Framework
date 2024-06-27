package pages.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base_test.Base_PO;
import helperMethods.WebElement_Methods;

import java.util.List;

public class DatePickerPage {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());

    public DatePickerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']") private WebElement selectDate_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") private WebElement selectMonth_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") private WebElement selectYear_WebElement;
    @FindBy(xpath = "//div[@role='option'] [not(contains(@class, 'day--outside-month'))]") private List<WebElement> selectDay_WebElement;
    @FindBy(xpath = "//button[text()='Previous Month']") private WebElement selectPreviousMonth_WebElement;
    @FindBy(xpath = "//button[text()='Next Month']") private WebElement selectNextMonth_WebElement;
    @FindBy(xpath = "//input[@id='dateAndTimePickerInput']") private WebElement selectDateAndTime_WebElement;
    @FindBy(xpath = "//div[contains(@class, 'hasMonthDropdown')]") private WebElement monthYearArrows_WebElement;



    public void clickOnSelectDateField() {
        webElementMethods.clickOn(selectDate_WebElement);
    }

    public void selectMonthAndYearByDropdown(String month, String year) {
        webElementMethods.selectByText(selectMonth_WebElement, month);
        webElementMethods.selectByValue(selectYear_WebElement, year);
    }

    public void selectDay(String day) {

        webElementMethods.clickOnWhenMatchedByText(selectDay_WebElement, day);
    }

    public Boolean dateIsCorrectlySelected(String dateValue) {
        Boolean isValid = true;

        if (!selectDate_WebElement.getAttribute("value").equals(dateValue)) isValid = false;

        return isValid;
    }


    public void selectMonthAndYearByArrow(String year, String month) {

        String monthAndYear = monthYearArrows_WebElement.getText();
        String[] array = monthAndYear.split(" ");
        String tableMonth = array[0];
        String tableYear = array[1];

        while (! tableYear.equals(year)) {
            if (returnIntValue(month) < returnIntValue(tableYear)) {
                webElementMethods.clickOn(selectPreviousMonth_WebElement);
            }

            else webElementMethods.clickOn(selectNextMonth_WebElement);

            String monthAndYearInsideLoop = monthYearArrows_WebElement.getText();
            String[] arrayInsideLoop = monthAndYearInsideLoop.split(" ");

            tableYear = arrayInsideLoop[1];
        }

        while (! tableMonth.equals(month)) {
            if (returnIntValue(month) < returnIntValue(tableMonth)) {
                webElementMethods.clickOn(selectPreviousMonth_WebElement);
            }

            else webElementMethods.clickOn(selectNextMonth_WebElement);

            String monthAndYearInsideLoop = monthYearArrows_WebElement.getText();
            String[] arrayInsideLoop = monthAndYearInsideLoop.split(" ");

            tableMonth = arrayInsideLoop[0];
        }
    }



    ///     my methods      ///

    public Integer returnIntValue(String yearOrMonth) {

        switch (yearOrMonth) {
            case "Januray":
                yearOrMonth = "1";
                break;
            case "February":
                yearOrMonth = "2";
                break;
            case "March":
                yearOrMonth = "3";
                break;
            case "April":
                yearOrMonth = "4";
                break;
            case "May":
                yearOrMonth = "5";
                break;
            case "June":
                yearOrMonth = "6";
                break;
            case "July":
                yearOrMonth = "7";
                break;
            case "August":
                yearOrMonth = "8";
                break;
            case "September":
                yearOrMonth = "9";
                break;
            case "October":
                yearOrMonth = "10";
                break;
            case "November":
                yearOrMonth = "11";
                break;
            case "December":
                yearOrMonth = "12";
                break;
            default: yearOrMonth = yearOrMonth;

        }

        return Integer.parseInt(yearOrMonth);
    }

}