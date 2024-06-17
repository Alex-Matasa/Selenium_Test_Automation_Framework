package pageObjects.forms;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageObjects.Base_PO;
import pageObjects.WebElement_Methods;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PracticeForm_PO {

    private WebDriver driver;
    private WebElement_Methods webElementMethods = new WebElement_Methods(Base_PO.getDriver());

    public PracticeForm_PO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    ///      Web Elements        ///

    @FindBy(xpath = "//*[text()='Forms']/ancestor::div[contains(@class,'top-card')]") private WebElement formsHomePage_WebElement;
    @FindBy(xpath = "//div[text()='Forms']/parent::div") private WebElement formsMenuList_WebElement;
    @FindBy(xpath = "//*[text()='Practice Form']/parent::li") private WebElement practiceForm_WebElement;
    @FindBy(xpath = "//input[@id='firstName']") private WebElement firstName_WebElement;
    @FindBy(xpath = "//input[@id='lastName']") private WebElement lastName_WebElement;
    @FindBy(xpath = "//input[@id='userEmail']") private WebElement userEmail_WebElement;
    @FindBy(xpath = "//input[@name='gender']") private List<WebElement> genderList_WebElement;
    @FindBy(xpath = "//input[@id='userNumber']") private WebElement mobileNumber_WebElement;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']") private WebElement dateOfBirthInputField_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']") private WebElement monthSelect_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']") private WebElement yearSelect_WebElement;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']") private List<WebElement> daysList_WebElement;
    @FindBy(xpath = "//input[@id='subjectsInput']") private WebElement subjectsInput_WebElement;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']/descendant::label[@class= 'custom-control-label']") private List<WebElement> hobbiesList_WebElement;
    @FindBy(xpath = "//input[@type='file']") private WebElement chooseFile_WebElement;
    @FindBy(xpath = "//textarea[@class='form-control']") private WebElement currentAddress_WebElement;
    @FindBy(xpath = "//div[@id='state']/descendant::input") private WebElement insertState_WebElement;
    @FindBy(xpath = "//div[@id='city']/descendant::input") private WebElement insertCity_WebElement;
    @FindBy(xpath = "//button[@id='submit']") private WebElement submitButton_WebElement;
    @FindBy(xpath = "//div[text() = 'Thanks for submitting the form']") private WebElement thanksForSubmitting_WebElement;
    @FindBy(xpath = "//tbody/tr") private List<WebElement> outputDataList_WebElement;



    ///       Data      ///

    private String firstNameValue = "Ion";
    private String lastNameValue = "Popescu";
    private String emailValue = "popescu.ion@email.com";
    private ArrayList<String> genderListValue = new ArrayList<>(Arrays.asList("Male", "Female", "Other"));
    private String mobileNumberValue = "0123456789";
    private String monthValue = "January";
    private String yearValue = "2000";
    private String dayValue = "13";
    private String dateOfBirth = dayValue + " " + monthValue + "," + yearValue;
    private String subjectsValue = "Accounting";
    private ArrayList<String> hobbiesListValue = new ArrayList<>(Arrays.asList("Sports", "Reading"));
    private String uploadPictureValue = "src/main/resources/linkedin_photo.png";
    private String currentAddressValue = "asdasdsa@@";
    private String stateValue = "NCR";
    private String cityValue = "Delhi";
    private String successfulMessageSubmissionValue = "Thanks for submitting the form";
    private ArrayList<String> dataInput = new ArrayList<>(Arrays.asList(
            "Student Name " + firstNameValue + " " + lastNameValue,
            "Student Email " + emailValue,
            "Gender " + genderListValue.get(0),
            "Mobile " + mobileNumberValue,
            "Date of Birth " + dateOfBirth,
            "Subjects " + subjectsValue,
            "Hobbies " + getHobbiesFormat(),
            "Picture " + "linkedin_photo.png",
            "Address " + currentAddressValue,
            "State and City " + stateValue + " " + cityValue));



    ///     Steps       ///

    public void accessPracticeForm() {
        driver.get("https://demoqa.com/");
        webElementMethods.clickOn(formsHomePage_WebElement);
        webElementMethods.clickOn(practiceForm_WebElement);
    }

    public void enterFirstName() {
        webElementMethods.sendKeys(firstName_WebElement, firstNameValue);
    }

    public void enterLastName() {
        webElementMethods.sendKeys(lastName_WebElement, lastNameValue);
    }

    public void enterEmail() {
        webElementMethods.sendKeys(userEmail_WebElement, emailValue);
    }

    public void selectGender() {
        String genderValue = genderListValue.get(0);

        for (Integer index = 0; index < genderList_WebElement.size(); index++) {

            if (genderList_WebElement.get(index).getAttribute("value").equals(genderValue)) {
//
                webElementMethods.clickOnJavaScriptExecutor(genderList_WebElement.get(index));
            }
        }
    }

    public void enterMobileNumber() {
        webElementMethods.sendKeys(mobileNumber_WebElement, mobileNumberValue);
    }

    public void selectDateOfBirth() {
        webElementMethods.clickOn(dateOfBirthInputField_WebElement);
        webElementMethods.selectByText(monthSelect_WebElement,monthValue);
        webElementMethods.selectByText(yearSelect_WebElement,yearValue);
        webElementMethods.clickOnWhenMatched(daysList_WebElement, dayValue);
    }

    public void enterSubjects () {
        subjectsInput_WebElement.sendKeys(subjectsValue);
        webElementMethods.keyboardActions(subjectsInput_WebElement,Keys.ENTER);
    }

    public void selectHobbies() {

        webElementMethods.clickOnMultiple(hobbiesList_WebElement, hobbiesListValue);
    }

    public void choosePicture () {
        File file = new File(uploadPictureValue);
//        chooseFile_WebElement.sendKeys(file.getAbsolutePath());
        webElementMethods.sendKeys(chooseFile_WebElement,file.getAbsolutePath());
    }

    public void enterCurrentAddress() {
        webElementMethods.sendKeys(currentAddress_WebElement,currentAddressValue);
    }

    public void selectState() {
        webElementMethods.clickOnJavaScriptExecutor(insertState_WebElement);
        webElementMethods.sendKeys(insertState_WebElement, stateValue);
        webElementMethods.keyboardActions(insertState_WebElement, Keys.ENTER);
    }

    public void selectCity () {
        webElementMethods.clickOnJavaScriptExecutor(insertCity_WebElement);
        webElementMethods.sendKeys(insertCity_WebElement, cityValue);
        webElementMethods.keyboardActions(insertCity_WebElement, Keys.ENTER);
    }

    public void clickOnSubmitButton() {
        webElementMethods.clickOnJavaScriptExecutor(submitButton_WebElement);
    }

    public Boolean  successfulSubmissionMessage() {
        webElementMethods.clickOn(thanksForSubmitting_WebElement); // "non-sens" click - avoiding an error
        return webElementMethods.validateText(thanksForSubmitting_WebElement, successfulMessageSubmissionValue);
    }


    public  Boolean correctDataAreSubmitted() {
        return webElementMethods.validateText(outputDataList_WebElement, dataInput);
    }


    ///     my methods       ////

    private  String getHobbiesFormat() {
        String hobbies ="";

        for (Integer index = 0; index < hobbiesListValue.size(); index++) {

            if(index == hobbiesListValue.size() - 1) {
                hobbies = hobbies + hobbiesListValue.get(index);
            }
            else hobbies += hobbiesListValue.get(index) + ", ";
        }

       return hobbies;
    }










}
