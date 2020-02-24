package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Expense_Reports_Page {
    public Expense_Reports_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

// this is locator for "Create" button
    @FindBy(xpath = "//button[@accesskey='c']")
    public WebElement createBtn;

//"My Reports" Header
@FindBy(xpath = "//li[.='My Reports']")
public WebElement myReporstsSign;

//"My Reports / New" Sign should be displayed after you press "Create" button
  @FindBy(xpath = "//li[.='New']")
    public WebElement newHeader;

//Field inside Pop-up frame "Expense Report Summary" to fill up
  @FindBy(xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public WebElement expense_Report_SummaryField;

// Field inside Pop-up frame "Employee" to choose the employee
    @FindBy(xpath = "//div[@class='o_field_widget o_field_many2one o_required_modifier']//div//input")
    public WebElement employee_to_selectField;

//Add an Item button
@FindBy(xpath = "//a[.='Add an item']")
public WebElement addAnItem;

//new Window with all items
    @FindBy(xpath = "//div[@class='modal-content']")
    public WebElement bigWindow;

    //Search Field

    @FindBy(xpath = "//div[@class='o_searchview']//input")
    public WebElement filter_in_bigWindow;

//"Add: Expense Lines" header on the top of the table

@FindBy(xpath = "//h4[.='Add: Expense Lines']")
public WebElement tableHeader;

    // checkBox in Tablem tr[from 1 - to ...]


@FindBy(xpath = "//div[@class='o_expense_tree table-responsive']//tbody//tr[1]//td[1]")
public WebElement checkBox_inTable;

// Select button
    @FindBy(xpath = "//button[@class='btn btn-sm btn-primary o_select_button']")
    public WebElement selectButton;

//Save Button

@FindBy(xpath = "//button[@accesskey='s']")
public WebElement saveButton;

@FindBy(xpath = "//div[@class='o_thread_message_content']//p")
    public WebElement confirmMessage;
}
