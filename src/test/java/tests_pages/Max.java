package tests_pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.Expense_Reports_Page;
import page.Expenses_Main_Page;
import utilities.Driver;

import java.util.concurrent.TimeUnit;

public class Max {

    @Test
    public static void myModule() throws InterruptedException {
        Expenses_Main_Page expenses_main_page = new Expenses_Main_Page();
        Expense_Reports_Page expense_reports_page = new Expense_Reports_Page();
//Enter the appp
        LogingPageTest.loginTest();
//Go to Expenses Report module
        expenses_main_page.expenseReport.click();

//Checking if Header contains Sign My Reports and If it is displayed
        String expectedSign = "My Reports";
        WebElement actualSign = expense_reports_page.myReporstsSign;
      Assert.assertEquals(actualSign.getText(),expectedSign,"Header sign on Expenses Report Page");
      Assert.assertTrue(actualSign.isDisplayed());

//Press Create Button

expense_reports_page.createBtn.click();
// Assert Header contains "NEW" after pressed Create new button;
String expectedNewSign = "New";
String actualNewSign = expense_reports_page.newHeader.getText();
Assert.assertEquals(expectedNewSign,actualNewSign,"Something Wrong with New Sign");

expense_reports_page.expense_Report_SummaryField.sendKeys("checking");
        expense_reports_page.employee_to_selectField.sendKeys("Kristen Bell"+ Keys.ENTER);

        expense_reports_page.addAnItem.click();
        Thread.sleep(2000);
        expense_reports_page.filter_in_bigWindow.sendKeys("Kristen Bell"+Keys.ENTER);

        expense_reports_page.checkBox_inTable.click();
        Thread.sleep(2000);
        expense_reports_page.selectButton.click();


    }


}
