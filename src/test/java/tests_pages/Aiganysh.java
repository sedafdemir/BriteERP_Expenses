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
    public void createExpenceAsAnOfficer() throws InterruptedException {
        LogingPageTest.loginTest();
        Expenses_To_Submit_Page expenses = new Expenses_To_Submit_Page();
        //1 - Verify if create button is displayed
        Assert.assertTrue(expenses.createButton.isDisplayed(), "Create button is not displayed");
        //2 - Click on the Create button
        expenses.createButton.click();
        //3-Enter expense description
        expenses.expenseDescriptionInput.sendKeys(Config.getProperty("expenseDescription"));
        //4-Click on the product dropdown and select the default product
        expenses.productInput.click();
        expenses.chosenProduct.click();

        //5-Click on the Employee dropdown and select the default Employee name
        expenses.employeeField.click();
        expenses.employeeName.click();

        //6-Click on the save button
        expenses.saveButton.click();
        //7-Verify Expense has been created

        Assert.assertTrue(expenses.expenseCreatedText.isDisplayed());

        //8-Click on the Submit to Manager button
        expenses.submitToManagerButton.click();
        Thread.sleep(2000);
        expenses.saveButton.click();
        //9-Verify Expense report submitted
        Assert.assertTrue(expenses.submittedMessage.isDisplayed());

    }
}
