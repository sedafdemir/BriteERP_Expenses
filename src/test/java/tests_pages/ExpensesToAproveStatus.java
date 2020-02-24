package tests_pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.Expense_Reports_To_Approve_Page;


import java.util.List;


public class ExpensesToAproveStatus {


    @BeforeClass
    public void setUp() {


        LoginPageTest loginPageTest = new LoginPageTest();
        loginPageTest.loginTest();

    }

    Expense_Reports_To_Approve_Page to_approve = new Expense_Reports_To_Approve_Page();

    @Test(priority = 0)
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

    @Test(priority = 1)
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


    @Test(priority = 2)
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

}
