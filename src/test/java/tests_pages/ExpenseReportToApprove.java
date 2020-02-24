package tests_pages;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Expense_Reports_To_Approve_Page;
import utilities.Driver;

public class ExpenseReportToApprove {

    Expense_Reports_To_Approve_Page moduleObject = new Expense_Reports_To_Approve_Page();

    @BeforeClass
    public void login(){
        LoginPageTest.loginTest();
    }

    @Test(priority = 1)
    public void goToExpensesModule(){
        moduleObject.expensesModule.click();
        moduleObject.expensesReportsToApprove.click();
        String actualTitle= Driver.getDriver().getTitle();
        String expectedInTitle = "Odoo";
        Assert.assertTrue(actualTitle.contains(expectedInTitle), "");
    }
    @Test(priority = 2)
    public void submitedEntryList(){
        int amountOfSubmittedEntry = moduleObject.submittedList.size();
        int amountOfDisplayedSubmitedEntry = Integer.parseInt(moduleObject.amountOfDisplayedSubmittedEntry.getText());
        Assert.assertEquals(amountOfDisplayedSubmitedEntry,amountOfSubmittedEntry,"Not passed");
    }

    @Test (priority = 3)
    public void approveEntry(){

        moduleObject.sampleEntry.click();
        moduleObject.approveButton.click();

        Assert.assertTrue(moduleObject.approveButton.isDisplayed(), "Not passed");

    }





}
