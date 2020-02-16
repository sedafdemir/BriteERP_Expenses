package tests_pages;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.Expenses_Main_Page;
import page.Expenses_To_Submit_Page;
import utilities.Config;
import utilities.Driver;

import java.util.Collection;

public class ExpensesToSubmitTest {

    @Test
    public void createExpense() throws InterruptedException{

        Expenses_To_Submit_Page expenseToSubmit = new Expenses_To_Submit_Page();
        LogingPageTest.loginTest();
        Assert.assertTrue(expenseToSubmit.textDisplay.isDisplayed());

        expenseToSubmit.createButton.click();
        Assert.assertTrue(expenseToSubmit.newTextDisplay.isDisplayed());

        expenseToSubmit.expenseDescriptionInput.sendKeys(Config.getProperty("expenseDescription"));

        expenseToSubmit.productInput.click();
        expenseToSubmit.chosenProduct.click();

        expenseToSubmit.employeeField.click();
        expenseToSubmit.employeeName.click();
        expenseToSubmit.saveButton.click();


        Assert.assertTrue(expenseToSubmit.textAfterSave.isDisplayed());

        expenseToSubmit.submitToManagerButton.click();
        Thread.sleep(2000);
        expenseToSubmit.saveButton.click();

        String expectedMessage = "Expense report submitted, waiting approval";
        String actualMessage = expenseToSubmit.submittedMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);

        Driver.quitDriver();
    }
}
