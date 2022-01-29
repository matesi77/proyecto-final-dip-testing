package UserPage;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.RequestCertificatePage;
import pages.UserPage;

import java.util.concurrent.TimeUnit;

public class UserTests extends BaseTest {

    @Test
    public void requestCertificate(){
        webDriver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(webDriver);
        UserPage userPage = loginPage.loginAs("6150564", "123456");
        RequestCertificatePage requestCertificatePage = userPage.clickOnRequestCertificate();
        Assert.assertTrue(requestCertificatePage.isRequestCertificatePageDisplayed());
    }
}
