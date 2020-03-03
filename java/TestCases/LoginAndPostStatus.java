//Test scenario to test login and post a status from the facebook account

package TestCases;
import org.dom4j.DocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import UtilityFunctions.*;

import java.io.IOException;
import java.util.List;

public class LoginAndPostStatus extends baseTest {

    fbLoginPage objLoginPage;
    landingPage objLandPage;
    captureScreenshot objss;
    String  sspath = objProp.getProperty("screenshotPath")+objProp.getProperty("screenshotFolder")+"\\";

    @Test
    public void postingStatus() throws IOException, InterruptedException {
        try {
            objLoginPage = new fbLoginPage(driver);

            //Verifying if the login page is loaded
            objLoginPage.pageLoadVerification().contains("Create an account");
            log.debug("-Verified if the Application is loaded successfully-");

            //Logging into FB account
            objLoginPage.logininFB(objProp.getProperty("appUsername"), objProp.getProperty("appPassword"));
            log.debug("-logging in...-");

            //Validating the logged in user
            objLandPage = new landingPage(driver);
            System.out.println(objLandPage.getLoggedinUser());
            Assert.assertTrue(objLandPage.getLoggedinUser().contains(objProp.getProperty("profilename")));
            log.debug("-Successfully logged into the application-");

            //Posting the status
            objLandPage.postingStatus(objProp.getProperty("status"));
            log.debug("-Posting a Status on the application-");


            Thread.sleep(2000);
            //Validating if the status is posted successfully
            List<WebElement> status = driver.findElements(By.tagName("p"));
            for (WebElement e : status) {
                if (e.getText().contains(objProp.getProperty("status")))
                    System.out.println("Status Posted Successfully!!");
            }
            log.debug("-Status validation-");
            Thread.sleep(2000);

            //Finally logging out of the application.
            objLandPage.logoutAction();
            log.debug("-Status validation-");
        } catch (InterruptedException e)
        {
            Thread.sleep(2000);
            objss = new captureScreenshot();
            objss.takeScreenshot(driver,sspath);
            log.debug("Error- screenshot captured!");

            e.printStackTrace();
        }
    }
}
