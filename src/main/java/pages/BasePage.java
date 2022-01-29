package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver webDriver;

    public BasePage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    protected void selectByVisibleText(String option, By selectBy){
        WebElement myDynamicElement = (new WebDriverWait(webDriver, 25).until(ExpectedConditions.presenceOfElementLocated(selectBy)));
        //Select toSelect = new Select(webDriver.findElement(selectBy));
        Select toSelect = new Select(myDynamicElement);
        WebDriverWait wait = new WebDriverWait(webDriver,25);
        wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(myDynamicElement, By.tagName("option")));
        toSelect.selectByVisibleText(option);
    }

    protected void typeText(String text, By elementBy){
        WebElement element = webDriver.findElement(elementBy);
        element.sendKeys(text);
    }

    protected void checkCheckBox(By elementBy){
        WebElement element = webDriver.findElement(elementBy);
        element.click();
    }

    protected  void waitElement(By selectBy){
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(selectBy)));
    }
}
