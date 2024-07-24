package tests.widgets;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import base_test.Base_Test;
import pages.HomePage;
import pages.WidgetsPage;
import pages.widgets.SelectMenuPage;

import java.util.ArrayList;
import java.util.Arrays;


public class SelectMenu_Test extends Base_Test {

    private WebDriver driver  =getDriver();

    private HomePage homePage = new HomePage(driver);
    private WidgetsPage widgetsPage = new WidgetsPage(driver);
    private SelectMenuPage selectMenuPage = new SelectMenuPage(driver);


            ///     Data        ///

    private ArrayList<String> selectOptionValue = new ArrayList<>(Arrays.asList("Group 1, option 1", "Group 1, option 2", "Group 2, option 1", "Group 2, option 2", "A root option", "Another root option"));
    private ArrayList<String> selectTitleValue = new ArrayList<>(Arrays.asList("Dr.", "Mr.", "Mrs.", "Ms.", "Prof.", "Other"));
    private ArrayList<String> colorLisTValues = new ArrayList<>(Arrays.asList("Red", "Blue", "Green", "Yellow", "Purple", "Black", "White", "Voilet", "Indigo", "Magenta", "Aqua"));
    private ArrayList<String> multiSelectColorsValues = new ArrayList<>(Arrays.asList("Green", "Black", "Blue"));
    private ArrayList<String> standardMultiSelectValues = new ArrayList<>(Arrays.asList("Volvo", "Opel", "Audi"));


    @Test
    public void validScenario() {

        driver.get("https://demoqa.com");
        homePage.navigateToWidgets();
        widgetsPage.navigateToSelectMenu();

        selectMenuPage.selectValue(selectOptionValue.get(1));
        Assert.assertTrue(selectMenuPage.validateSelectValue(selectOptionValue.get(1)));

        selectMenuPage.selectTitle(selectTitleValue.get(1));
        Assert.assertTrue(selectMenuPage.validateSelectTitle(selectTitleValue.get(1)));

        selectMenuPage.selectColor(colorLisTValues.get(1));
        Assert.assertTrue(selectMenuPage.validateSelectColor(colorLisTValues.get(1)));

        selectMenuPage.selectMultiSelect(multiSelectColorsValues);
        Assert.assertTrue(selectMenuPage.validateMultiSelect(multiSelectColorsValues));

        selectMenuPage.standardMultiSelect(standardMultiSelectValues);
//        Assert.assertTrue(selectMenuPage.validateStandardMultiSelect()); // needs implementation
    }


}
