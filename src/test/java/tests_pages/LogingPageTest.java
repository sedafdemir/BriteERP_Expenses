package tests_pages;

import org.testng.annotations.Test;
import page.Login_Page;
import utilities.Config;
import utilities.Driver;

public class LogingPageTest {

    Login_Page lp = new Login_Page();

    @Test
    public void loginTest(){

        Driver.getDriver().get(Config.getProperty("url"));

        lp.emailInput.sendKeys(Config.getProperty("emailManager"));
        lp.passwordInput.sendKeys(Config.getProperty("passwordManager"));
        lp.loginButton.click();
        lp.expenseModule.click();

    }
}
