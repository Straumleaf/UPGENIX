package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.UserInboxPage;
import utilities.ConfigReader;
import utilities.Driver;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    UserInboxPage userInboxPage = new UserInboxPage();

    @Given("user is on the UPGENIX login page")
    public void user_is_on_the_UPGENIX_login_page(){

        String url = ConfigReader.getProperty("webLoginPage");
        Driver.getDriver().get(url);

    }

    @When("user enters valid username {string}")
    public void userEntersValidUsername(String arg0) {
        loginPage.inputLogin.sendKeys(arg0);
    }

    @And("user enters valid password {string}")
    public void userEntersValidPassword(String arg0) {
        loginPage.inputPassword.sendKeys(arg0);
    }

    @And("user clicks on the Login button")
    public void userClicksOnTheLoginButton() {
        loginPage.buttonLog.click();
    }

    @Then("user is on the Inbox page")
    public void userIsOnTheInboxPage() {
        Assert.assertTrue(userInboxPage.userInbox.isDisplayed());
    }

}
