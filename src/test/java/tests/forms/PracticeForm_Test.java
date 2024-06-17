package tests.forms;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.forms.PracticeForm_PO;


public class PracticeForm_Test {

    private WebDriver driver;
    private PracticeForm_PO practiceFormPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        practiceFormPo = new PracticeForm_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        practiceFormPo.accessPracticeForm();
        practiceFormPo.enterFirstName();
        practiceFormPo.enterLastName();
        practiceFormPo.enterEmail();
        practiceFormPo.selectGender();
        practiceFormPo.enterMobileNumber();
        practiceFormPo.selectDateOfBirth();
        practiceFormPo.enterSubjects();
        practiceFormPo.selectHobbies();
        practiceFormPo.choosePicture();
        practiceFormPo.enterCurrentAddress();
        practiceFormPo.selectState();
        practiceFormPo.selectCity();
        practiceFormPo.clickOnSubmitButton();
        Assert.assertTrue(practiceFormPo.successfulSubmissionMessage());
        Assert.assertTrue(practiceFormPo.correctDataAreSubmitted());
    }

}
