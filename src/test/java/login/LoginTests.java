package login;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserPage;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {

    @Test(dataProvider = "users")
    public void testSuccessfulLogin(String user, String password){
        webDriver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(webDriver);
        UserPage userPage = loginPage.loginAs(user, password);
        webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        Assert.assertTrue(userPage.isUserPageDisplayed());
    }

    @DataProvider(name = "users")
    public Object[][] usersList(){
        return new Object[][]{
                {"6150564", "123456"},
                {"7009329", "12345678"}
        };
    }
}
