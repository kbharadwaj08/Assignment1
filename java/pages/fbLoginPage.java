//This is a page class which maintains and initializes all the Facebook login page elements.

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class fbLoginPage{

    WebDriver driver;

    @FindBy(xpath = "//span[contains(.,'Create an account')]")
    WebElement pageTitle;

    @FindBy(xpath = "//input[@name='email']")
    WebElement uname;

    @FindBy(xpath ="//input[@name='pass']")
    WebElement pword;

    @FindBy(xpath = "//input[contains(@value,'Log In')]")
    WebElement loginButton;

    public fbLoginPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String pageLoadVerification()
    {
        return pageTitle.getText();
    }

    public void setUsername(String username)
    {
        uname.clear();
        uname.sendKeys(username);
    }

    public void setPassword(String password)
    {
        pword.clear();
        pword.sendKeys(password);
    }

    public void clickSubmit()
    {
        loginButton.click();
    }

    public void logininFB(String uname, String Pword)
    {
        this.setUsername(uname);
        this.setPassword(Pword);
        this.clickSubmit();
    }


}
