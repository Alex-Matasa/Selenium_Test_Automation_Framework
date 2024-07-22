package pages.forms;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PracticeFormPage extends BasePage {

    public PracticeFormPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement firstName_WebElement;
    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement lastName_WebElement;
    @FindBy(xpath = "//input[@id='userEmail']")
    private WebElement userEmail_WebElement;
    @FindBy(xpath = "//input[@name='gender']")
    private List<WebElement> genderList_WebElement;
    @FindBy(xpath = "//input[@id='userNumber']")
    private WebElement mobileNumber_WebElement;
    @FindBy(xpath = "//input[@id='dateOfBirthInput']")
    private WebElement dateOfBirthInputField_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__month-select']")
    private WebElement monthSelect_WebElement;
    @FindBy(xpath = "//select[@class='react-datepicker__year-select']")
    private WebElement yearSelect_WebElement;
    @FindBy(xpath = "//div[@class='react-datepicker__month']//div[not(contains(@class,'--outside-month')) and @role='option']")
    private List<WebElement> daysList_WebElement;
    @FindBy(xpath = "//input[@id='subjectsInput']")
    private WebElement subjectsInput_WebElement;
    @FindBy(xpath = "//div[@id='hobbiesWrapper']/descendant::label[@class= 'custom-control-label']")
    private List<WebElement> hobbiesList_WebElement;
    @FindBy(xpath = "//input[@type='file']")
    private WebElement chooseFile_WebElement;
    @FindBy(xpath = "//textarea[@class='form-control']")
    private WebElement currentAddress_WebElement;
    @FindBy(xpath = "//div[@id='state']/descendant::input")
    private WebElement insertState_WebElement;
    @FindBy(xpath = "//div[@id='city']/descendant::input")
    private WebElement insertCity_WebElement;
    @FindBy(xpath = "//button[@id='submit']")
    private WebElement submitButton_WebElement;
    @FindBy(xpath = "//div[text() = 'Thanks for submitting the form']")
    private WebElement thanksForSubmitting_WebElement;
    @FindBy(xpath = "//tbody/tr")
    private List<WebElement> outputDataList_WebElement;



    public void enterFirstName(String firstName) {
        webElementMethods.sendKeys(firstName_WebElement, firstName);
    }

    public void enterLastName(String lastName) {
        webElementMethods.sendKeys(lastName_WebElement, lastName);
    }

    public void enterEmail(String email) {
        webElementMethods.sendKeys(userEmail_WebElement, email);
    }

    public void selectGender(ArrayList<String> genderList, Integer index) {
        String genderValue = genderList.get(index);

        webElementMethods.clickOnWhenMatchedByAttributeJavaScript(genderList_WebElement, genderValue, "value");
    }

    public void enterMobileNumber(String mobileNumber) {
        webElementMethods.sendKeys(mobileNumber_WebElement, mobileNumber);
    }

    public void selectDateOfBirth(String month, String year, String day) {
        webElementMethods.clickOn(dateOfBirthInputField_WebElement);
        webElementMethods.selectByText(monthSelect_WebElement,month);
        webElementMethods.selectByText(yearSelect_WebElement,year);
        webElementMethods.clickOnWhenMatchedByText(daysList_WebElement, day);
    }

    public void enterSubjects (String subject) {
        subjectsInput_WebElement.sendKeys(subject);
        webElementMethods.keyboardActions(subjectsInput_WebElement,Keys.ENTER);
    }

    public void selectHobbies(ArrayList<String> hobbiesList) {

        webElementMethods.clickOnMultiple(hobbiesList_WebElement, hobbiesList);
    }

    public void choosePicture (String url) {
        File file = new File(url);
//        chooseFile_WebElement.sendKeys(file.getAbsolutePath());
        webElementMethods.sendKeys(chooseFile_WebElement,file.getAbsolutePath());
    }

    public void enterCurrentAddress(String currentAddress) {
        webElementMethods.sendKeys(currentAddress_WebElement,currentAddress);
    }

    public void selectState(String state) {
        webElementMethods.clickOnJavaScriptExecutor(insertState_WebElement);
        webElementMethods.sendKeys(insertState_WebElement, state);
        webElementMethods.keyboardActions(insertState_WebElement, Keys.ENTER);
    }

    public void selectCity (String city) {
        webElementMethods.clickOnJavaScriptExecutor(insertCity_WebElement);
        webElementMethods.sendKeys(insertCity_WebElement, city);
        webElementMethods.keyboardActions(insertCity_WebElement, Keys.ENTER);
    }

    public void clickOnSubmitButton() {
        webElementMethods.clickOnJavaScriptExecutor(submitButton_WebElement);
    }

    public Boolean validateSuccessfulSubmission(String successfulText) {
        webElementMethods.clickOn(thanksForSubmitting_WebElement); // "non-sens" click - avoiding an error
        return assertionMethods.validateText(thanksForSubmitting_WebElement, successfulText);
    }


    public  Boolean correctDataAreSubmitted(ArrayList<String> dataInput) {

        return assertionMethods.validateText(outputDataList_WebElement, dataInput);
    }




}
