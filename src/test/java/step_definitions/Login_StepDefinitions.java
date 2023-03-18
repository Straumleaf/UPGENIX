package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.LoginPage;
import pages.UserInboxPage;
import utilities.BrowserTools;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    UserInboxPage userInboxPage = new UserInboxPage();

    @Given("user is on the UPGENIX login page")
    public void user_is_on_the_UPGENIX_login_page(){

        String url = ConfigReader.getProperty("webLoginPage");
        Driver.getDriver().get(url);

    }

    @When("user enters username {string}")
    public void userEntersValidUsername(String arg0) {
        loginPage.inputLogin.sendKeys(arg0);
    }

    @And("user enters password {string}")
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

    @Then("user should see Wrong login or password message")
    public void userShouldSeeWrongLoginPasswordMessage() {
        Assert.assertTrue(loginPage.pWrongLoginPassword.isDisplayed());
    }

    @Then("user should get - \\(Please fill out this field.) warning message")
    public void userShouldGetPleaseFillOutThisFieldWarningMessage() {
        Assert.assertEquals("true", loginPage.inputLogin.getAttribute("required"));
    }

    @When("user {string} enters password {string}")
    public void userEntersPassword(String login, String password) {
        loginPage.inputLogin.sendKeys(login);
        loginPage.inputPassword.sendKeys(password);
    }

    @Then("user should see the password in bullet signs by default")
    public void userShouldSeeThePasswordInBulletSignsByDefault() {
        Assert.assertEquals("password", loginPage.inputPassword.getAttribute("type"));
    }

    @And("press \\(Enter) key")
    public void pressEnterKey() {
        loginPage.inputPassword.sendKeys(Keys.ENTER);
    }
}
