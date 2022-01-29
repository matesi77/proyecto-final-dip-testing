package requestCertificate;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.*;

public class RequestCertificateTests extends BaseTest {
    @Test(dataProvider = "users")
    public void requestNaturalCertificateWithToken(String user, String password){
        LoginPage loginPage = new LoginPage(webDriver);
        UserPage userPage = loginPage.loginAs(user, password);
        RequestCertificatePage requestCertificatePage = userPage.clickOnRequestCertificate();
        CertificateDataPage certificateDataPage = requestCertificatePage.enterDatesOfCertificate(
                "ADSIB",
                "NATURAL",
                "ALTO",
                "FIRMA SIMPLE",
                "TOKEN",
                "La Paz",
                "Calle Los Olivos Nro.123",
                "CI - CEDULA DE IDENTIDAD",
                "789456123",
                "Daily Bugle"
        );
        certificateDataPage.fillDataNatural();
        DetailModalPage detailModalPage = certificateDataPage.requestCertificate();
        detailModalPage.confirmDetail();

        WebElement myDynamicElement = (new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']"))));
        Assert.assertEquals(myDynamicElement.getText(), "Solicitud realizada correctamente");
    }

    @Test(dataProvider = "users")
    public void requestLegalCertificateWithToken(String user, String password){
        LoginPage loginPage = new LoginPage(webDriver);
        UserPage userPage = loginPage.loginAs(user, password);
        RequestCertificatePage requestCertificatePage = userPage.clickOnRequestCertificate();
        CertificateDataPage certificateDataPage = requestCertificatePage.enterDatesOfCertificate(
                "ADSIB",
                "JURIDICA ENTIDADES PUBLICAS",
                "ALTO",
                "FIRMA SIMPLE",
                "TOKEN",
                "La Paz",
                "Calle Los Olivos Nro.123",
                "OD - OTRO DOCUMENTO DE IDENTIDAD",
                "1111111111",
                "Umbrella corporation");
        certificateDataPage.fillData("PRENSA",
                "REPORTERO",
                "123456789",
                "DAILY BUGLE",
                "06/06/2021",
                "DB-001",
                "JAMES JAMESON",
                "DIRECTOR");
        DetailModalPage detailModalPage = certificateDataPage.requestCertificate();
        detailModalPage.confirmDetail();

        WebElement myDynamicElement = (new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']"))));
        Assert.assertEquals(myDynamicElement.getText(), "Solicitud realizada correctamente");
        tearDown();
    }

    @Test(dataProvider = "users")
    public void requestNaturalCertificateWithSoftoken(String user, String password){
        LoginPage loginPage = new LoginPage(webDriver);
        UserPage userPage = loginPage.loginAs(user, password);
        RequestCertificatePage requestCertificatePage = userPage.clickOnRequestCertificate();
        CertificateDataPage certificateDataPage = requestCertificatePage.enterDatesOfCertificateSW(
                "ADSIB",
                "NATURAL",
                "NORMAL",
                "FIRMA SIMPLE",
                "SOFTWARE",
                "La Paz",
                "PAS - PASAPORTE",
                "20500034",
                "Van Lubeck"
        );
        certificateDataPage.fillDataNatural();
        DetailModalPage detailModalPage = certificateDataPage.requestCertificate();
        detailModalPage.confirmDetail();

        WebElement myDynamicElement = (new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']"))));
        Assert.assertEquals(myDynamicElement.getText(), "Solicitud realizada correctamente");
    }

    @Test(dataProvider = "users")
    public void requestLegalCertificateWithSoftoken(String user, String password){
        LoginPage loginPage = new LoginPage(webDriver);
        UserPage userPage = loginPage.loginAs(user, password);
        RequestCertificatePage requestCertificatePage = userPage.clickOnRequestCertificate();
        CertificateDataPage certificateDataPage = requestCertificatePage.enterDatesOfCertificateSW(
                "ADSIB",
                "JURIDICA",
                "NORMAL",
                "FIRMA SIMPLE",
                "SOFTWARE",
                "La Paz",
                "NIT - NÚMERO DE IDENTIFICACIÓN TRIBUTARIA",
                "7009329015",
                "CARMELO");
        certificateDataPage.fillData("PRENSA",
                "REPORTERO",
                "123456789",
                "DAILY BUGLE",
                "06/06/2021",
                "DB-001",
                "JAMES JAMESON",
                "DIRECTOR");
        DetailModalPage detailModalPage = certificateDataPage.requestCertificate();
        detailModalPage.confirmDetail();

        WebElement myDynamicElement = (new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='alert alert-success']"))));
        Assert.assertEquals(myDynamicElement.getText(), "Solicitud realizada correctamente");
    }


    @DataProvider(name = "users")
    public Object[][] userList(){
        return new Object[][]{
                //solo para desa
                //{"6796298", "12345678"},
                //{"6773235", "12345678"},

                //ambos ambientes
                {"8373504", "12345678"},
                {"7009329", "12345678"}
        };
    }
}
