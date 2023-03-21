package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.LoginPage;
import pages.UserInboxPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Logout_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    UserInboxPage userInboxPage = new UserInboxPage();


    @Given("user is on the UPGENIX Inbox page")
    public void user_is_on_the_UPGENIX_login_page(){

        String url = ConfigReader.getProperty("webLoginPage");
        Driver.getDriver().get(url);
        loginPage.inputLogin.sendKeys("salesmanager75@info.com");
        loginPage.inputPassword.sendKeys("salesmanager" + Keys.ENTER);

    }


    @Then("user clicks on username and choose Log out option")
    public void userClicksOnUsernameAndChooseLogOutOption() {
        userInboxPage.spanUserName.click();
        userInboxPage.linkLogout.click();
    }

    @Then("user is redirected to Login page")
    public void userIsRedirectedToLoginPage() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Login | Best solution for startups"));
    }
}
