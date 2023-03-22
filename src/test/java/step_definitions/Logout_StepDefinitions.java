package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import pages.LoginPage;
import pages.UserInboxPage;
import utilities.ConfigReader;
import utilities.Driver;

import javax.swing.*;

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

    @Then("user is on the Login page and see {string} option in top right conner")
    public void userIsRedirectedToLoginPage(String text) {
        Assert.assertTrue(loginPage.liDropDown.getText().equals(text));
    }


    @And("user clicks the browser step back button")
    public void userClicksTheBrowserStepBackButton() {
        Driver.getDriver().navigate().back();
    }

    @Then("user should see the message {string}")
    public void userShouldSeeTheMessage(String warning) {
        Assert.assertTrue(userInboxPage.yourOdooSessionExpired.getText().contains(warning));

    }

    @And("user closes the active web tab")
    public void userClosesTheActiveWebTab() {
        Actions actions = new Actions(Driver.getDriver());
        actions.keyDown(Keys.CONTROL).sendKeys("w").keyUp(Keys.CONTROL);
    }

    @And("user open home page again")
    public void userOpenHomePageAgain() {
        String url = ConfigReader.getProperty("webLoginPage");
        Driver.getDriver().get(url);
    }
}
