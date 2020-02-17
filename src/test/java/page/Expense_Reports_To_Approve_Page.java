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

    @FindBy(xpath = "(//span[@class='oe_menu_text'])[9]")
    public WebElement expensesModule;
    @FindBy(xpath = "(//span[@class='oe_menu_text'])[25]")
    public WebElement expensesReportsToApprove;
    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr/td[6]")
    public List<WebElement> submittedList;
    @FindBy(xpath = "//span[@class='o_pager_limit']")
    public WebElement amountOfDisplayedSubmittedEntry;
    @FindBy(xpath = "//table[@class='o_list_view table table-condensed table-striped o_list_view_ungrouped']/tbody/tr[2]/td[6]")
    public WebElement sampleEntry;
    @FindBy(xpath = "//button[.='Approve']")
    public WebElement approveButton;


}
