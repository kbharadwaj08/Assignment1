package pages;

import org.dom4j.DocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class landingPage{

    WebDriver driver;

    @FindBy(xpath = "//div[@class ='linkWrap noCount']")
    WebElement loggedIn;

    @FindBy(xpath = "//textarea[@name='xhpc_message']")
    WebElement statusBox;

    @FindBy(xpath = "//button[contains(.,'Post')]")
    WebElement postButton;

    @FindBy(xpath ="//a/div[text()='Account Settings']")
    WebElement usernav;

    @FindBy(xpath="//span[text()='Log Out']")
    WebElement logout;

    public landingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getLoggedinUser()
    {
        return loggedIn.getText();
    }

    public void enterStatus(String status)
    {
        statusBox.click();
        statusBox.sendKeys(status);
    }

    public void postStatus()
    {
        postButton.click();
    }

    public void userNav()
    {
        usernav.click();
    }

    public void loggingOut()
    {
        logout.click();
    }


    public void postingStatus(String status) throws InterruptedException {
        this.getLoggedinUser();
        this.enterStatus(status);
        Thread.sleep(2000);
        this.postStatus();
    }

    public void logoutAction() throws InterruptedException {
        this.userNav();
        Thread.sleep(2000);
        this.loggingOut();
    }

}
