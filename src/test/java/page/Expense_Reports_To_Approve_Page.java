package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Expense_Reports_To_Approve_Page {

    public Expense_Reports_To_Approve_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//a[@data-action-id='546']")
    public WebElement expensesToApprove;

    @FindBy(xpath = "//div[@class='fa fa-sm fa-remove o_facet_remove']")
    public WebElement toApproveRemoveButton;

    @FindBy(xpath = "//input[@class='o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr/td[6]")
    public List<WebElement> expensesSubmittedStatus;


    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr/td[6]")
    public List<WebElement> expensesStatus;


    @FindBy(xpath = "//ul[@class='dropdown-menu o_searchview_autocomplete']/li[3]")
    public WebElement approvedOption;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_searchview_autocomplete']/li[3]")
    public WebElement refusedOption;

// Expenses report description from Expense Reports to Approve table(Max)
    @FindBy(xpath = "//tbody[@class='ui-sortable']//tr//td[2]")
    public WebElement expenseReportSummary;

//Expenses report employee name from Expense Reports to Approve table(Max)
    @FindBy(xpath = "//tbody[@class='ui-sortable']//tr//td[4]")
    public WebElement expenseReportEmployeeName;

//Expenses report report status from Expense Reports to Approve table(Max)
    @FindBy(xpath = "//tbody[@class='ui-sortable']//tr//td[6]")
    public WebElement expenseReportStatus;


}
