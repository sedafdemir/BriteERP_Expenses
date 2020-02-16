package tests_pages;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.Expenses_Main_Page;
import page.Expenses_To_Submit_Page;
import page.Login_Page;
import utilities.Config;
import utilities.Driver;

public class Aiganysh {

    //@BeforeClass
//    public void loginAsAnOfficer() {
//        Driver.getDriver().get(Config.getProperty("url"));
//        Login_Page login_page = new Login_Page();
//
//        login_page.emailInput.sendKeys("emailOfficer");
//        login_page.passwordInput.sendKeys("passwordOfficer");
//        login_page.loginButton.click();
//        login_page.expenseModule.click();



    @Test
    public void createExpenceAsAnOfficer() {
        LogingPageTest.loginTest();
        Expenses_To_Submit_Page expenses = new Expenses_To_Submit_Page();
        //1 - Verify if create button is displayed
        Assert.assertTrue(expenses.createButton.isDisplayed(), "Create button is not displayed");
        //3 - Click on the Create button
        expenses.createButton.click();
        //Expense window should pop up
        //User should be able to write into Expense description box
        expenses.expenseDescriptionInput.sendKeys(Config.getProperty("expenseDescription"));
        //Click on the product dropdown
        expenses.productInput.click();
        expenses.
        //User should be able to choose product under product dropdown
        //
        //6
        //Click on the unit price module
        //
        //User should be able to see the price of the selected product
        //
        //7
        //Click on the quantity module
        //
        //User should be able to enter quantity of the product
        //
        //8
        //Click on the Expense Date button
        //
        //User should be able to select the date of the Expense
        //
        //9
        //Click on the Employee dropdown
        //
        //User should be able to select Employees name
        //
        //10
        //Click on the Employee/Company checkbox under
        //
        //User should be able to click one of the Employee or Company checkbox
        //
        //11
        //Payment By text
        //
        //under the Payment By text
        //
        //12
        //Total text
        //
        //User should be able to see total same as the unit price
        //
        //13
        //Click on the Notes box
        //
        //User should be able to add details about this expense on this Notes box
        //
        //14
        //Click on the save button
        //
        //User should be able to click on the save button
        //
        //15
        //Click on the Submit to Manager button
        //
        //User should be able to click on the Submit to manager button

    }
}
