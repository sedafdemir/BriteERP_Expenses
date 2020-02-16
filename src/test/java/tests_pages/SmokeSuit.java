package tests_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.*;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class SmokeSuit {

    Expense_Reports_To_Approve_Page to_approve = new Expense_Reports_To_Approve_Page();
    Expenses_Main_Page expenses_main_page = new Expenses_Main_Page();
    Expense_Reports_Page expense_reports_page = new Expense_Reports_Page();

    @BeforeMethod
    public void login(){
            Login_Page lp = new Login_Page();
            Driver.getDriver().get(Config.getProperty("url"));

            lp.emailInput.sendKeys(Config.getProperty("email"));
            lp.passwordInput.sendKeys(Config.getProperty("password"));
            lp.loginButton.click();
            lp.expenseModule.click();

        }

//        @Test                      // Begimai, Aiganysh, Rabia
        public void createExpense() throws InterruptedException{

            Expenses_To_Submit_Page expenseToSubmit = new Expenses_To_Submit_Page();
            Assert.assertTrue(expenseToSubmit.textDisplay.isDisplayed());

            expenseToSubmit.createButton.click();
            Assert.assertTrue(expenseToSubmit.newTextDisplay.isDisplayed());

            expenseToSubmit.expenseDescriptionInput.sendKeys(Config.getProperty("expenseDescription"));

            expenseToSubmit.productInput.click();
            Driver.getDriver().findElement(By.xpath("//a[.='"+Config.getProperty("product")+"']")).click();

            expenseToSubmit.employeeField.click();
            Driver.getDriver().findElement(By.xpath("//a[.='"+Config.getProperty("employee")+"']")).click();

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


        @Test (priority = 1)
        public void expenseReportsToApproveTest() throws InterruptedException {

            expenses_main_page.expenseReport.click();
//Checking if Header contains Sign My Reports and If it is displayed
            String expectedSign = "My Reports";
            WebElement actualSign = expense_reports_page.myReporstsSign;
            Assert.assertEquals(actualSign.getText(), expectedSign, "Header sign on Expenses Report Page");
            Assert.assertTrue(actualSign.isDisplayed());

//Press Create Button

            Thread.sleep(2000);
            expense_reports_page.createBtn.click();
// Assert Header contains "NEW" after pressed Create new button;
            String expectedNewSign = "New";
            String actualNewSign = expense_reports_page.newHeader.getText();
            Assert.assertEquals(expectedNewSign, actualNewSign, "Something Wrong with New Sign");

            expense_reports_page.expense_Report_SummaryField.sendKeys(Config.getProperty("expenseDescription"));
            //       expense_reports_page.employee_to_selectField.sendKeys("Kristen Bell"+ Keys.ENTER);
            expense_reports_page.employee_to_selectField.click();
//expense_reports_page.employeeFromList.click();
            Driver.getDriver().findElement(By.xpath("//li[.='" + Config.getProperty("employee") + "']")).click();
            expense_reports_page.addAnItem.click();
            Thread.sleep(2000);

            String expectedTableHeader = "Add: Expense Lines";
            String actualTableHeader = expense_reports_page.tableHeader.getText();
            Assert.assertEquals(actualTableHeader, expectedTableHeader, "Something wrong with Add: Expense Lines" +
                    "header of the table");
            expense_reports_page.filter_in_bigWindow.sendKeys(Config.getProperty("employee") + Keys.ENTER);

            Thread.sleep(2000);
            expense_reports_page.checkBox_inTable.click();

            expense_reports_page.selectButton.click();
            expense_reports_page.saveButton.click();
            String expectedMessage = "Expense report submitted, waiting approval";
            String actualMessage = expense_reports_page.confirmMessage.getText();
            Assert.assertTrue(actualMessage.contains(expectedMessage));
            Assert.assertTrue(expense_reports_page.confirmMessage.isDisplayed());
            Driver.quitDriver();

        }
    @Test (priority = 2)
    public void verificationReportsTable(){
        Expense_Reports_To_Approve_Page expense_reports_to_approve_page = new Expense_Reports_To_Approve_Page();
        expenses_main_page.expenseReportsToApprove.click();

//Checking expenses description from from Expense Reports to Approve table(Max)
        String actualDescription=expense_reports_to_approve_page.expenseReportSummary.getText();
        String expectedDescription = Config.getProperty("expenseDescription");
        Assert.assertEquals(actualDescription,expectedDescription,"Description doesn match");

//Checking employee name from Expense Reports to Approve table(Max)
        String actualName = expense_reports_to_approve_page.expenseReportEmployeeName.getText();
        String expectedName = Config.getProperty("employee");
        Assert.assertEquals(actualName,expectedName,"Names doesnt match");

////Checking report status from Expense Reports to Approve table(Max)
        String actualStatus = expense_reports_to_approve_page.expenseReportStatus.getText();
        String expectedStatus= "Submitted";
        Assert.assertEquals(actualStatus,expectedStatus,"Status doesnt match");
        Driver.quitDriver();

    }

    @Test (priority = 4)
    public void submittedTest() throws  InterruptedException{
        to_approve.expensesToApprove.click();
        Thread.sleep(4000);
        List<WebElement> statuses = to_approve.expensesSubmittedStatus;
        int count = 0;

        for (WebElement status : statuses) {
            String actual = status.getText();
            String expected = "Submitted";
            Assert.assertEquals(actual, expected);
            count++;
            System.out.println(actual);
        }
        System.out.println(count);

    }

    @Test(priority = 5)
    public void approvedTest() throws InterruptedException {
        to_approve.expensesToApprove.click();
        Thread.sleep(4000);
        to_approve.toApproveRemoveButton.click();
        Thread.sleep(4000);
        to_approve.searchBox.sendKeys("Approved");
        to_approve.approvedOption.click();
        Thread.sleep(4000);
        List<WebElement> approvedStatuses = to_approve.expensesStatus;
        int count = 0;
        for (WebElement approvedStatus : approvedStatuses) {
            String actual = approvedStatus.getText();
            String expected = "Approved";
            Assert.assertEquals(actual, expected);
            count++;
            System.out.println(actual);
        }

        System.out.println(count);
    }


    @Test(priority = 6)
    public void refuseTest() throws InterruptedException {

        to_approve.expensesToApprove.click();
        Thread.sleep(4000);
        to_approve.toApproveRemoveButton.click();
        Thread.sleep(4000);
        to_approve.searchBox.sendKeys("Refuse");
        to_approve.refusedOption.click();
        Thread.sleep(4000);
        List<WebElement> statuses = to_approve.expensesStatus;
        int count = 0;
        //Thread.sleep(4000);

        Thread.sleep(4000);
        for (WebElement status : statuses) {
            String actual = status.getText();
            String expected = "Refused";
            Assert.assertEquals(actual, expected);

            count++;
            System.out.println(actual);
        }
        System.out.println(count);

    }

    @AfterClass
    public void quitDriver(){
        Driver.quitDriver();
        }
}
