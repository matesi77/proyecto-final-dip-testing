package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class UserPage extends BasePage{

    private By title = By.xpath("//app-page-header/div/div/h2");

    private By requestCertificateButton = By.xpath("//app-mycertificates/div[1]/div/div/div/div[3]/button");

    public UserPage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isUserPageDisplayed(){
        WebElement element = webDriver.findElement(title);
        return element.isDisplayed();
    }

    public RequestCertificatePage clickOnRequestCertificate(){
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.elementToBeClickable(requestCertificateButton));
        WebElement element = webDriver.findElement(requestCertificateButton);
        element.click();
        return new RequestCertificatePage(webDriver);
    }
}
