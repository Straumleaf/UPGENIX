package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class UserInboxPage {
    public UserInboxPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // 'Inbox' text inside user page
    @FindBy(xpath = "//*[text() = '#Inbox']")
    public WebElement userInbox;

    // username menu with username 'SalesManager75'
    @FindBy(xpath = "//span[@class='oe_topbar_name']")
    public WebElement spanUserName;

    // username menu 'Log out' item
    @FindBy(xpath = "//a[@data-menu='logout']")
    public WebElement linkLogout;

    @FindBy(xpath = "//*[text() = '\n    \n    Your Odoo session expired. Please refresh the current web page.\n']")
    public WebElement yourOdooSessionExpired;

    @FindBy(css = "li[class='dropdown']")
    public WebElement liDropDown;

}
