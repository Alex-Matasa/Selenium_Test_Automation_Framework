package pageObjects.widgets;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageObjects.Base_PO;
import pageObjects.WebElement_Methods;

import java.util.List;

public class DatePicker_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());

    public DatePicker_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    ///     Web Elements       ///

    @FindBy(xpath = "//*[text()='Widgets']/ancestor::div[contains(@class,'top-card')]") private WebElement widgetsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Widgets']/parent::div") private WebElement widgetsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Date Picker']/parent::li") private WebElement datePickerMenu_WebElement;
    @FindBy(xpath = "//input[@id='datePickerMonthYearInput']") private WebElement selectDate_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") private WebElement selectMonth_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") private WebElement selectYear_WebElement;
    @FindBy(xpath = "//div[@role='option'] [not(contains(@class, 'day--outside-month'))]") private List<WebElement> selectDay_WebElement;
    @FindBy(xpath = "//button[text()='Previous Month']") private WebElement selectPreviousMonth_WebElement;
    @FindBy(xpath = "//button[text()='Next Month']") private WebElement selectNextMonth_WebElement;
    @FindBy(xpath = "//input[@id='dateAndTimePickerInput']") private WebElement selectDateAndTime_WebElement;
    @FindBy(xpath = "//div[contains(@class, 'hasMonthDropdown')]") private WebElement monthYearArrows_WebElement;


    ///     Data        ///

    private String monthValue = "May";
    private String yearValue = "2020";
    private String dayValue = "1";


    ///     steps       ///

    public void accessDatePicker() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(widgetsHomePage_WebElement);
        webElementMethods.clickOn(widgetsMenuList_WebElement);
        webElementMethods.clickOn(datePickerMenu_WebElement);
    }

    public void clickOnSelectDateField() {
        webElementMethods.clickOn(selectDate_WebElement);
    }

    public void selectMonthAndYearByDropdown() {
        webElementMethods.selectByText(selectMonth_WebElement, monthValue);
        webElementMethods.selectByValue(selectYear_WebElement, yearValue);
    }

    public void selectDay() {

        webElementMethods.clickOnWhenMatched(selectDay_WebElement, dayValue);
    }

    public Boolean dateIsCorrectlySelected() {
        Boolean isValid = true;

        if (!selectDate_WebElement.getAttribute("value").equals(getDateValue())) isValid = false;

        return isValid;
    }


    public void selectMonthAndYearByArrow() {

        String monthAndYear = monthYearArrows_WebElement.getText();
        String[] array = monthAndYear.split(" ");
        String tableMonth = array[0];
        String tableYear = array[1];

        while (! tableYear.equals(yearValue)) {
            if (returnIntValue(yearValue) < returnIntValue(tableYear)) {
                webElementMethods.clickOn(selectPreviousMonth_WebElement);
            }

            else webElementMethods.clickOn(selectNextMonth_WebElement);

            String monthAndYearInsideLoop = monthYearArrows_WebElement.getText();
            String[] arrayInsideLoop = monthAndYearInsideLoop.split(" ");

            tableYear = arrayInsideLoop[1];
        }

        while (! tableMonth.equals(monthValue)) {
            if (returnIntValue(monthValue) < returnIntValue(tableMonth)) {
                webElementMethods.clickOn(selectPreviousMonth_WebElement);
            }

            else webElementMethods.clickOn(selectNextMonth_WebElement);

            String monthAndYearInsideLoop = monthYearArrows_WebElement.getText();
            String[] arrayInsideLoop = monthAndYearInsideLoop.split(" ");

            tableMonth = arrayInsideLoop[0];
        }
    }

    ///     my methods      ///

    private String getDateValue() {

        switch (dayValue) {
            case "1":
                dayValue = "01";
                break;
            case "2":
                dayValue = "02";
                break;
            case "3":
                dayValue = "03";
                break;
            case "4":
                dayValue = "04";
                break;
            case "5":
                dayValue = "05";
                break;
            case "6":
                dayValue = "06";
                break;
            case "7":
                dayValue = "07";
                break;
            case "8":
                dayValue = "08";
                break;
            case "9":
                dayValue = "09";
                break;
        }

        return switch (monthValue) {
            case "January" -> "01/" + dayValue + "/" + yearValue;
            case "February" -> "02/" + dayValue + "/" + yearValue;
            case "March" -> "03/" + dayValue + "/" + yearValue;
            case "April" -> "04/" + dayValue + "/" + yearValue;
            case "May" -> "05/" + dayValue + "/" + yearValue;
            case "June" -> "06/" + dayValue + "/" + yearValue;
            case "July" -> "07/" + dayValue + "/" + yearValue;
            case "August" -> "08/" + dayValue + "/" + yearValue;
            case "September" -> "09/" + dayValue + "/" + yearValue;
            case "October" -> "10/" + dayValue + "/" + yearValue;
            case "November" -> "11/" + dayValue + "/" + yearValue;
            case "December" -> "12/" + dayValue + "/" + yearValue;
            default -> "Invalid data";
        };

    }

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