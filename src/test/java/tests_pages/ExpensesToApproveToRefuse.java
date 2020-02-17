package tests_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.Expense_Reports_To_Approve_Page;
import page.Expenses_Main_Page;
import utilities.Config;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class ExpensesToApproveToRefuse {

    Expenses_Main_Page expenses_main_page = new Expenses_Main_Page();
    Expense_Reports_To_Approve_Page expense_reports_to_approve_page = new Expense_Reports_To_Approve_Page( );


    @BeforeMethod
    public void login() {

//        1 Go to the app ==> http://app.briteerp.com/web#menu_id=115&action=120&active_id=channel_inbox
//        2	Put credentials as manager
//        3	Click login button
//        4	Click Expense module at the top

//        LogingPageTest.loginTest();
    }

    @Test
    public void VerifyRefuseButton() throws InterruptedException{

//        5	Click on Expense Reports to Approve at the left side

        expenses_main_page.expenseReportsToApprove.click();
        Thread.sleep(3000);

//        6	Verify that there is a filter called To Approved in search box

        WebElement filter = expense_reports_to_approve_page.approvedFilter;

        Assert.assertTrue(filter.getText().equals("To Approve"));

//        7	Cancel the filter (To Approved) option in search box

        expense_reports_to_approve_page.approvedFilterClose.click();


//        8	Verify that all list of any kind of expenses should be displayed

        List<WebElement> listOfStatusWebElement = expense_reports_to_approve_page.listOfElements;
        List<String> listOfStatusString = new ArrayList<>();

        Thread.sleep(5000);
        for (WebElement element: expense_reports_to_approve_page.listOfElements) {
            String s = element.getText();
            listOfStatusString.add(s);
        }
        System.out.println(listOfStatusString);

        Assert.assertTrue(listOfStatusString.contains("Approved") && listOfStatusString.contains("Submitted") && listOfStatusString.contains("Refused") );

//        9	Click on one of the submitted expenses displayed in the list

        expense_reports_to_approve_page.searchBox.sendKeys("Submitted");
        Thread.sleep(2000);
        expense_reports_to_approve_page.SubmittedDropDown.click();
        Thread.sleep(2000);
        expense_reports_to_approve_page.submittedExpense.click();

        String employeeName = Driver.getDriver().findElement(By.xpath("//a[@class='o_form_uri o_field_widget o_required_modifier']")).getText();

//        10	Verify there is a Refuse button right next to Approve button

        Assert.assertTrue(expense_reports_to_approve_page.refuseButton.isDisplayed());

//        11	Click on Refuse button
        Thread.sleep(2000);

        expense_reports_to_approve_page.refuseButton.click();

//        12	Verify that there is a place to write the reason of refusing

        Assert.assertTrue(expense_reports_to_approve_page.refuseButton.isDisplayed());

//        13	Write the reason of refusing

        expense_reports_to_approve_page.refuseInputBox.sendKeys(Config.getProperty("reasonForRefusing"));
//        14	After writing the reason, click on refuse button

        expense_reports_to_approve_page.refuseButton2.click();
        Thread.sleep(2000);

//        15	Click on Expense Reports to Approve again

        expense_reports_to_approve_page.expense_Report_To_Approve.click();

        Thread.sleep(2000);
//        16	Verify that refused one by manager is shown as refused

        expense_reports_to_approve_page.approvedFilterClose.click();

        String employeeName2 = Driver.getDriver().findElement(By.xpath("//tbody//tr[2]//td[4]")).getText();

        Assert.assertTrue(employeeName.equals(employeeName2));

    }
}
