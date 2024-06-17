package tests.widgets;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.Base_PO;
import pageObjects.widgets.SelectMenu_PO;


public class SelectMenu_Test {

    private WebDriver driver;
    private SelectMenu_PO selectMenuPo;

    @BeforeTest
    public void setUp() {
        driver = Base_PO.getDriver();
        selectMenuPo = new SelectMenu_PO(driver);
    }

    @AfterTest
    public void tearDown() {
        Base_PO.cleanUpDriver();
    }

    @Test
    public void validScenario() {
        selectMenuPo.accessSelectMenu();

        selectMenuPo.selectValue();
        Assert.assertTrue(selectMenuPo.validateSelectValue());

        selectMenuPo.selectTitle();
        Assert.assertTrue(selectMenuPo.validateSelectTitle());

        selectMenuPo.selectColor();
        Assert.assertTrue(selectMenuPo.validateSelectColor());

        selectMenuPo.selectMultiSelect();
        Assert.assertTrue(selectMenuPo.validateMultiSelect());

        selectMenuPo.standardMultiSelect();
        Assert.assertTrue(selectMenuPo.validateStandardMultiSelect()); // needs implementation
    }


}
