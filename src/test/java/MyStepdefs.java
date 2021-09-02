import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.EmployeePage;
import pages.LoginPage;

/**
 * @autor: Boris.Perez
 **/
public class MyStepdefs {

    protected WebDriver webDriver;
    private EmployeePage employeePage = new EmployeePage(webDriver);

    @Given("the user enter to the page with (.*) and (.*)")
    public void theUserEnterToThePageWithBorisAndPassword(String user, String pass) {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://www.testfaceclub.com/ejercicios/");
        webDriver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(webDriver);
        employeePage = loginPage.loginAs(user, pass);
    }

    @When("the user adds a new employee with (.*), (.*), (.*), (.*)")
    public void theUserAddsANewEmployee(String name, String email, String address, String phone) {
        employeePage.addEmployee(name, email, address, phone);
    }

    @Then("the notification is displayed")
    public void theNotificationIsDisplayed() {
        Assert.assertTrue(employeePage.isAlertPresent());
    }

    @Then("^the employee page is displayed$")
    public void theEmployeePageIsDisplayed() {
        Assert.assertTrue(employeePage.isEmployeePageDisplayed());
    }

    @And("^the session is closed$")
    public void theSessionIsClosed() {
        if(webDriver != null)
            webDriver.quit();
    }
}
