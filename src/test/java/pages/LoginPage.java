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


}
