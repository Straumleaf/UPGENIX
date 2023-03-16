package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    // body of login page
    @FindBy(css = "body")
    public WebElement body;

    // email login input box
    @FindBy(xpath = "//*[@id='login']")
    public WebElement inputLogin;

    // password input box
    @FindBy(xpath = "//*[@id='password']")
    public WebElement inputPassword;

    // 'Log in' button
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement buttonLog;

    // 'Inbox' text inside user page
    @FindBy(xpath = "//*[text() = '#Inbox']")
    public WebElement liInbox;

    // username menu with username 'SalesManager75'
    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement spanUserName;

    // username menu 'Log out' item
    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement linkLogout;

}
