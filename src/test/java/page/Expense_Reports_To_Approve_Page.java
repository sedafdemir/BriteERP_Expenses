package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class Expense_Reports_To_Approve_Page {


    public Expense_Reports_To_Approve_Page (){

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


    @FindBy(xpath = "//div[@class = 'o_facet_values']")
    public WebElement approvedFilter;

    @FindBy(xpath = "//div[@class ='fa fa-sm fa-remove o_facet_remove']")
    public WebElement approvedFilterClose;

    @FindBy(xpath = "//tbody/tr/td[6]")
    public List<WebElement> listOfElements;

    @FindBy(xpath = "//tbody/tr[1]/td[2]")
    public WebElement submittedExpense;

    @FindBy(xpath = "//button[@class='btn btn-sm btn-default']")
    public WebElement refuseButton;

    @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement refuseInputBox;

    @FindBy(xpath = "//button[@class='btn btn-sm oe_highlight']")
    public WebElement refuseButton2;

    @FindBy(xpath = "//span[contains(text(), 'Expense Reports To Approve')]")
    public WebElement expense_Report_To_Approve;

    @FindBy(xpath = "//ul[@class='dropdown-menu o_searchview_autocomplete']//li[3]")
    public WebElement SubmittedDropDown;

}
