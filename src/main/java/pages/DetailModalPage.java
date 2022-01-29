package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailModalPage extends BasePage{

    private By detailsCheckBox = By.xpath("(//ngb-modal-window//input[@type='checkbox'])[1]");
    private By termsAndConditionsCheckBox = By.xpath("(//ngb-modal-window//input[@type='checkbox'])[2]");
    private By agreeButton = By.xpath("//button[text()='Acepto']");

    public DetailModalPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnAgreeButton(){
        WebElement myDynamicElement = (new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(agreeButton)));
        myDynamicElement.click();
    }

    public void confirmDetail(){
        checkCheckBox(detailsCheckBox);
        checkCheckBox(termsAndConditionsCheckBox);
        clickOnAgreeButton();
    }

}
