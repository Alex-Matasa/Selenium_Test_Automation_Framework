package tests.widgets;

import base_test.Base_PO;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.WidgetsPage;
import pages.widgets.DatePickerPage;
import pages.widgets.ToolTipsPage;


public class ToolTips_Test {

    private WebDriver driver;
    private HomePage homePage;
    private WidgetsPage widgetsPage;
    private ToolTipsPage toolTipsPage;


    @BeforeTest
    public void setUp()  {
        driver = Base_PO.getDriver();
        homePage = new HomePage(driver);
        widgetsPage = new WidgetsPage(driver);
        toolTipsPage = new ToolTipsPage(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        homePage.navigateToWidgets();
        widgetsPage.navigateToToolTips();

        toolTipsPage.hoverOnButton();
        Assert.assertTrue(toolTipsPage.validateHoverOnButton());

        toolTipsPage.hoverOnTextField();
        Assert.assertTrue(toolTipsPage.validateHoverOnTextField());

        toolTipsPage.hoverOnContraryText();
        Assert.assertTrue(toolTipsPage.validateHoverOnContraryText());

        toolTipsPage.hoverOnSectionText();
        Assert.assertTrue(toolTipsPage.validateHoverOnSectionText());

    }













}
