package login;

import base.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import pages.EmployeePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    @Test
    public void testSuccessfulLogin() {
        LoginPage loginPage = new LoginPage(webDriver);
        EmployeePage employeePage = loginPage.loginAs("user1", "admin");
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
    }
}
