package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RequestCertificatePage extends BasePage{

    private By title = By.xpath("//app-getcertificates/div[1]/app-page-header/div/div/h2");
    private By registrationAgencySelect = By.xpath("//select[@name='agenciaregistro']");
    private By typeOfCertificateSelect = By.name("tipoCertificado");
    private By securityLevelSelect = By.name("nivel");
    private By typeOfUseSelect = By.xpath("//div[label[contains(.,'Tipo de uso')]]//select");
    private By storageSelect = By.xpath("//div[label[contains(.,'Almacenamiento')]]//select");
    private By townSelect = By.id("ciudad");
    private By addressTextArea = By.xpath("//form//textarea");
    private By documentTypeSelect = By.xpath("//div[label[contains(.,'Tipo documento')]]//select");
    private By nitNumberInput = By.name("nit");
    private By businessNameInput = By.name("razon_social");
    private By nextButton = By.xpath("//button[contains(.,'Siguiente')]");



    public RequestCertificatePage(WebDriver webDriver){
        super(webDriver);
    }

    public boolean isRequestCertificatePageDisplayed(){
        WebElement element = webDriver.findElement(title);
        return element.isDisplayed();
    }

    public void clickOnNextButton(){
        WebElement myDynamicElement = (new WebDriverWait(webDriver, 5).until(ExpectedConditions.presenceOfElementLocated(nextButton)));
        myDynamicElement.click();
    }

    public boolean isVisibleTest(){
        WebElement myDynamicElement = (new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(registrationAgencySelect)));
        //WebDriverWait wait = new WebDriverWait(webDriver, 3);
        //wait.until(ExpectedConditions.visibilityOf(webDriver.findElement(registrationAgencySelect)));
        //WebElement element = webDriver.findElement(registrationAgencySelect);
        return myDynamicElement.isDisplayed();
    }

    public CertificateDataPage enterDatesOfCertificate(String registrationAgency, String typeOfCertificate, String securityLevel, String typeOfUse, String storage, String town, String address, String documentType, String nitNumber, String businessName){
        selectByVisibleText(registrationAgency, registrationAgencySelect);
        selectByVisibleText(typeOfCertificate, typeOfCertificateSelect);
        selectByVisibleText(securityLevel, securityLevelSelect);
        selectByVisibleText(typeOfUse, typeOfUseSelect);
        selectByVisibleText(storage, storageSelect);
        selectByVisibleText(town, townSelect);
        typeText(address, addressTextArea);
        selectByVisibleText(documentType, documentTypeSelect);
        typeText(nitNumber, nitNumberInput);
        typeText(businessName, businessNameInput);
        clickOnNextButton();
        return new CertificateDataPage(webDriver);
    }

    public CertificateDataPage enterDatesOfCertificateSW(String registrationAgency, String typeOfCertificate, String securityLevel, String typeOfUse, String storage, String town, String documentType, String nitNumber, String businessName){
        selectByVisibleText(registrationAgency, registrationAgencySelect);
        selectByVisibleText(typeOfCertificate, typeOfCertificateSelect);
        selectByVisibleText(securityLevel, securityLevelSelect);
        selectByVisibleText(typeOfUse, typeOfUseSelect);
        selectByVisibleText(storage, storageSelect);
        selectByVisibleText(town, townSelect);
        selectByVisibleText(documentType, documentTypeSelect);
        typeText(nitNumber, nitNumberInput);
        typeText(businessName, businessNameInput);
        clickOnNextButton();
        return new CertificateDataPage(webDriver);
    }
}
