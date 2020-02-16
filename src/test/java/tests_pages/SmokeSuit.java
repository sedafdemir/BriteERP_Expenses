package tests_pages;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import page.Login_Page;
import utilities.Config;
import utilities.Driver;

public class SmokeSuit {

    @BeforeClass
    public void login(){
            Login_Page lp = new Login_Page();
            Driver.getDriver().get(Config.getProperty("url"));

            lp.emailInput.sendKeys(Config.getProperty("email"));
            lp.passwordInput.sendKeys(Config.getProperty("password"));
            lp.loginButton.click();
            lp.expenseModule.click();

        }



    @AfterClass
    public void quitDriver(){
        Driver.quitDriver();
        }
}
