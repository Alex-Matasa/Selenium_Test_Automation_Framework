package tests.forms;

import helperMethods.Assertion_Methods;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import base_test.Base_PO;
import pages.FormsPage;
import pages.HomePage;
import pages.forms.PracticeFormPage;

import java.util.ArrayList;
import java.util.Arrays;


public class PracticeForm_Test {

    private WebDriver driver;
    private HomePage homePage;
    private FormsPage formsPage;
    private PracticeFormPage practiceFormPage;
    private Assertion_Methods assertionMethods;


    private String firstNameValue = "Ion";
    private String lastNameValue = "Popescu";
    private String emailValue = "popescu.ion@email.com";
    private ArrayList<String> genderListValue = new ArrayList<>(Arrays.asList("Male", "Female", "Other"));
    private Integer indexSelectedForGender = 1;
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
            "Gender " + genderListValue.get(indexSelectedForGender),
            "Mobile " + mobileNumberValue,
            "Date of Birth " + dateOfBirth,
            "Subjects " + subjectsValue,
            "Hobbies " + getHobbiesFormat(),
            "Picture " + "linkedin_photo.png",
            "Address " + currentAddressValue,
            "State and City " + stateValue + " " + cityValue));

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        formsPage = new FormsPage(driver);
        practiceFormPage = new PracticeFormPage(driver);
        assertionMethods = new Assertion_Methods(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        homePage.navigateToForms();
        formsPage.navigateToPracticeForm();

        practiceFormPage.enterFirstName(firstNameValue);
        practiceFormPage.enterLastName(lastNameValue);
        practiceFormPage.enterEmail(emailValue);
        practiceFormPage.selectGender(genderListValue, indexSelectedForGender);
        practiceFormPage.enterMobileNumber(mobileNumberValue);
        practiceFormPage.selectDateOfBirth(monthValue, yearValue, dayValue);
        practiceFormPage.enterSubjects(subjectsValue);
        practiceFormPage.selectHobbies(hobbiesListValue);
        practiceFormPage.choosePicture(uploadPictureValue);
        practiceFormPage.enterCurrentAddress(currentAddressValue);
        practiceFormPage.selectState(stateValue);
        practiceFormPage.selectCity(cityValue);
        practiceFormPage.clickOnSubmitButton();
        Assert.assertTrue(practiceFormPage.validateSuccessfulSubmission(successfulMessageSubmissionValue));
        Assert.assertTrue(practiceFormPage.correctDataAreSubmitted(dataInput));
    }

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
