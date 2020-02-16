package tests_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Expense_Reports_Page;
import page.Expense_Reports_To_Approve_Page;
import page.Expenses_Main_Page;
import page.Login_Page;
import utilities.Config;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class ExpenseReportstoApproveTest {

    @Test(priority = 1)
    public void myModule() throws InterruptedException {
        Expenses_Main_Page expenses_main_page = new Expenses_Main_Page();
        Expense_Reports_Page expense_reports_page = new Expense_Reports_Page();
//Enter the appp
        LogingPageTest.loginTest();
//Go to Expenses Report module
        expenses_main_page.expenseReport.click();

//Checking if Header contains Sign My Reports and If it is displayed
        String expectedSign = "My Reports";
        WebElement actualSign = expense_reports_page.myReporstsSign;
        Assert.assertEquals(actualSign.getText(), expectedSign, "Header sign on Expenses Report Page");
        Assert.assertTrue(actualSign.isDisplayed());

//Press Create Button

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
        public void myModule2(){
    Expenses_Main_Page expenses_main_page = new Expenses_Main_Page();
    Expense_Reports_To_Approve_Page expense_reports_to_approve_page = new Expense_Reports_To_Approve_Page();
        LogingPageTest.loginTest();
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




}
