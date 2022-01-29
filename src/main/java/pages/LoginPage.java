package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{


    private By userInput = By.xpath("//form/div[1]/div[1]/input");
    private By passwordInput = By.xpath("//form/div[1]/div[2]/input");
    private By enterButton = By.xpath("//form/div[3]/div[1]/button");
    private By registerButton = By.xpath("//form/div[3]/div[1]/a");
    private By forgetPasswordLink = By.xpath("//form/div[1]/div[3]/a");
    private By helpLink = By.xpath("//form/div[3]/div[2]/a");

    public LoginPage(WebDriver webDriver){
        super(webDriver);
    }

    public void typeUser(String user){
        WebElement element = webDriver.findElement(userInput);
        element.sendKeys(user);
    }

    public void typePassword(String password){
        WebElement element = webDriver.findElement(passwordInput);
        element.sendKeys(password);
    }

    public UserPage clickOnEnterButton(){
        WebElement element = webDriver.findElement(enterButton);
        element.click();
        return new UserPage(webDriver);
    }

    public UserPage loginAs(String user, String password){
        typeUser(user);
        typePassword(password);
        return clickOnEnterButton();
    }

}
