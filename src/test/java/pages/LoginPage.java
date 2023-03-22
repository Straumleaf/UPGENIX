package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

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

    // Wrong login/password message indication
    @FindBy(xpath = "//p")
    public WebElement pWrongLoginPassword;

    // warning message that session has been expired
    @FindBy(xpath = "//*[text() = '\n    \n    Your Odoo session expired. Please refresh the current web page.\n']")
    public WebElement yourOdooSessionExpired;

    // top right drop list element with or without username
    @FindBy(xpath = "//*[@id='top_menu']")
    public WebElement liDropDown;


}
