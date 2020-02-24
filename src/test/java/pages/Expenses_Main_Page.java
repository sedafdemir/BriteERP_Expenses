package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class Expenses_Main_Page {
    public Expenses_Main_Page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Buttons on the side  on front page of expenses
    @FindBy(xpath = "//a[@href='/web#menu_id=390&action=540']")
    public WebElement expensesToSubmit;

    @FindBy(xpath = "//a[@href='/web#menu_id=391&action=545']")
    public WebElement refusedReports;

    @FindBy(xpath = "//a[@href='/web#menu_id=392&action=544']")
    public WebElement expenseReport;

    @FindBy(xpath = "//a[@href='/web#menu_id=394&action=546']")
    public WebElement expenseReportsToApprove;

    @FindBy(xpath = "//a[@href='/web#menu_id=399&action=539']")
    public WebElement expensesAnalysis;

    @FindBy(xpath = "//a[@href='/web#menu_id=400&action=549']")
    public WebElement expensesReportsAnalysis;

    @FindBy(xpath = "//a[@href='/web#menu_id=402&action=541']")
    public WebElement expenseProducts;
}
