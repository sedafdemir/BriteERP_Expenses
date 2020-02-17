package tests_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import page.*;
import utilities.Config;
import utilities.Driver;

import java.util.ArrayList;
import java.util.List;

public class SmokeSuit {

    Expense_Reports_To_Approve_Page to_approve = new Expense_Reports_To_Approve_Page();
    Expenses_Main_Page expenses_main_page = new Expenses_Main_Page();
    Expense_Reports_Page expense_reports_page = new Expense_Reports_Page();

    @BeforeMethod
    public void login() {
        Login_Page lp = new Login_Page();
        Driver.getDriver().get(Config.getProperty("url"));

        lp.emailInput.sendKeys(Config.getProperty("email"));
        lp.passwordInput.sendKeys(Config.getProperty("password"));
        lp.loginButton.click();
        lp.expenseModule.click();

    }

    //        @Test (priority = 1)                     // Begimai, Aiganysh, Rabia
    public void createExpense() throws InterruptedException {

        Expenses_To_Submit_Page expenseToSubmit = new Expenses_To_Submit_Page();
        Assert.assertTrue(expenseToSubmit.textDisplay.isDisplayed());

        expenseToSubmit.createButton.click();
        Assert.assertTrue(expenseToSubmit.newTextDisplay.isDisplayed());

        expenseToSubmit.expenseDescriptionInput.sendKeys(Config.getProperty("expenseDescription"));

        expenseToSubmit.productInput.click();
        Driver.getDriver().findElement(By.xpath("//a[.='" + Config.getProperty("product") + "']")).click();

        expenseToSubmit.employeeField.click();
        Driver.getDriver().findElement(By.xpath("//a[.='" + Config.getProperty("employee") + "']")).click();

        expenseToSubmit.saveButton.click();

        Assert.assertTrue(expenseToSubmit.textAfterSave.isDisplayed());

        expenseToSubmit.submitToManagerButton.click();
        Thread.sleep(2000);
        expenseToSubmit.saveButton.click();

        String expectedMessage = "Expense report submitted, waiting approval";
        String actualMessage = expenseToSubmit.submittedMessage.getText();
    }


    @Test(priority = 2)
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
        Thread.sleep(2000);
        expense_reports_page.saveButton.click();
        String expectedMessage = "Expense report submitted, waiting approval";
        String actualMessage = expense_reports_page.confirmMessage.getText();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
        Assert.assertTrue(expense_reports_page.confirmMessage.isDisplayed());
        Driver.quitDriver();

    }

    @Test(priority = 3)
    public void verificationReportsTable() {
        Expense_Reports_To_Approve_Page expense_reports_to_approve_page = new Expense_Reports_To_Approve_Page();
        expenses_main_page.expenseReportsToApprove.click();

//Checking expenses description from from Expense Reports to Approve table(Max)
        String actualDescription = expense_reports_to_approve_page.expenseReportSummary.getText();
        String expectedDescription = Config.getProperty("expenseDescription");
        Assert.assertEquals(actualDescription, expectedDescription, "Description doesn match");

//Checking employee name from Expense Reports to Approve table(Max)
        String actualName = expense_reports_to_approve_page.expenseReportEmployeeName.getText();
        String expectedName = Config.getProperty("employee");
        Assert.assertEquals(actualName, expectedName, "Names doesnt match");

////Checking report status from Expense Reports to Approve table(Max)
        String actualStatus = expense_reports_to_approve_page.expenseReportStatus.getText();
        String expectedStatus = "Submitted";
        Assert.assertEquals(actualStatus, expectedStatus, "Status doesnt match");
        Driver.quitDriver();

    }

    @Test(priority = 4)
    public void submittedTest() throws InterruptedException {
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

    @Test(priority = 7)
    public void VerifyRefuseButton() throws InterruptedException {

//        5	Click on Expense Reports to Approve at the left side
        expenses_main_page.expenseReportsToApprove.click();
        Thread.sleep(3000);

//        6	Verify that there is a filter called To Approved in search box

        WebElement filter = to_approve.approvedFilter;

        Assert.assertTrue(filter.getText().equals("To Approve"));

//        7	Cancel the filter (To Approved) option in search box

        to_approve.approvedFilterClose.click();


//        8	Verify that all list of any kind of expenses should be displayed

        List<WebElement> listOfStatusWebElement = to_approve.listOfElements;
        List<String> listOfStatusString = new ArrayList<>();

        Thread.sleep(5000);
        for (WebElement element : to_approve.listOfElements) {
            String s = element.getText();
            listOfStatusString.add(s);
        }
        System.out.println(listOfStatusString);

        Assert.assertTrue(listOfStatusString.contains("Approved") && listOfStatusString.contains("Submitted") && listOfStatusString.contains("Refused"));

//        9	Click on one of the submitted expenses displayed in the list

        to_approve.searchBox.sendKeys("Submitted");
        Thread.sleep(2000);
        to_approve.SubmittedDropDown.click();
        Thread.sleep(2000);
        to_approve.submittedExpense.click();

        String employeeName = Driver.getDriver().findElement(By.xpath("//a[@class='o_form_uri o_field_widget o_required_modifier']")).getText();

//        10	Verify there is a Refuse button right next to Approve button

        Assert.assertTrue(to_approve.refuseButton.isDisplayed());

//        11	Click on Refuse button
        Thread.sleep(2000);

        to_approve.refuseButton.click();

//        12	Verify that there is a place to write the reason of refusing

        Assert.assertTrue(to_approve.refuseButton.isDisplayed());

//        13	Write the reason of refusing

        to_approve.refuseInputBox.sendKeys(Config.getProperty("reasonForRefusing"));
//        14	After writing the reason, click on refuse button

        to_approve.refuseButton2.click();
        Thread.sleep(2000);

//        15	Click on Expense Reports to Approve again

        to_approve.expense_Report_To_Approve.click();

        Thread.sleep(2000);
//        16	Verify that refused one by manager is shown as refused

        to_approve.approvedFilterClose.click();

        String employeeName2 = Driver.getDriver().findElement(By.xpath("//tbody//tr[2]//td[4]")).getText();

        Assert.assertTrue(employeeName.equals(employeeName2));

    }

    @Test(priority = 1)
    public void goToExpensesModule() {
        to_approve.expensesModule.click();
        to_approve.expensesReportsToApprove.click();
        String actualTitle = Driver.getDriver().getTitle();
        String expectedInTitle = "Odoo";
        Assert.assertTrue(actualTitle.contains(expectedInTitle), "");
    }

    @Test(priority = 2)
    public void submitedEntryList() {
        int amountOfSubmittedEntry = to_approve.submittedList.size();
        int amountOfDisplayedSubmitedEntry = Integer.parseInt(to_approve.amountOfDisplayedSubmittedEntry.getText());
        Assert.assertEquals(amountOfDisplayedSubmitedEntry, amountOfSubmittedEntry, "Not passed");
    }

    @Test(priority = 3)
    public void approveEntry() {

        to_approve.sampleEntry.click();
        to_approve.approveButton.click();

        Assert.assertTrue(to_approve.approveButton.isDisplayed(), "Not passed");

    }

    @AfterMethod
    public void quitDriver() {
        Driver.quitDriver();
    }
}
