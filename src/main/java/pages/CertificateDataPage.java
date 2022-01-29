package pages;

import com.sun.tools.javac.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.LocalFileDetector;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public class CertificateDataPage extends BasePage{

    private By organizationalUnitInput = By.xpath("//div[label[contains(.,'Unidad Organizativa')]]//input");
    private By jobTitleInput = By.xpath("//div[label[contains(.,'Nombre de cargo')]]//input");
    private By nitEntityInput = By.xpath("//div[label[contains(.,'NIT de la Entidad o Empresa como dato para el Certificado')]]//input");
    private  By entityNameInput = By.xpath("//div[label[contains(.,'Nombre de la entidad')]]//input");
    private By letterDateInput = By.xpath("//div[label[contains(.,'Fecha de emisión del Documento de Acreditación del Representante Legal')]]//input");
    private By citeLetterInput = By.xpath("//div[label[contains(.,'CITE del Documento de Acreditación del Representante Legal')]]//input");
    private By nameLegalRepresentativeInput = By.xpath("//div[label[contains(.,'Nombre del Representante Legal')]]//input");
    private By jobTitleLegalRepresentativeInput = By.xpath("//div[label[contains(.,'Cargo del Representante Legal')]]//input");
    private By nitButton = By.xpath("//div[label[contains(.,'Fotocopia del Número de Identificación Tributaria (NIT)')]]//input");
    private By ciButton = By.xpath("//div[label[contains(.,'Fotocopia de Documento de Identidad del solicitante')]]//input");
    private By letterButton = By.xpath("//div[label[contains(.,'Carta o Nota de Solicitud firmada por la MAE o Representante Legal')]]//input");
    private By electricityBillButton = By.xpath("//div[label[contains(.,'Factura de Luz')]]//input");
    private By requestButton = By.id("btnSig");

    public CertificateDataPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void uploadFile(String file, By locator) {
        String absolutePath = System.getProperty("user.dir") + "/fakeDocuments" + file;
        webDriver.findElement(locator).sendKeys(absolutePath);
    }

    public void fillData(String organizationalUnit, String jobTitle, String nitEntity, String entityName, String letterDate, String citeLetter, String nameLegalRepresentative, String jobTitleLegalRepresentative) {
        typeText(organizationalUnit, organizationalUnitInput);
        typeText(jobTitle, jobTitleInput);
        typeText(nitEntity, nitEntityInput);
        typeText(entityName, entityNameInput);
        typeText(letterDate, letterDateInput);
        typeText(citeLetter, citeLetterInput);
        typeText(nameLegalRepresentative, nameLegalRepresentativeInput);
        typeText(jobTitleLegalRepresentative, jobTitleLegalRepresentativeInput);
        uploadFile("/NIT.pdf", nitButton);
        uploadFile("/CI.pdf", ciButton);
        uploadFile("/NOTA.pdf", letterButton);
    }

    public void fillDataNatural(){
        uploadFile("/NIT.pdf", electricityBillButton);
        uploadFile("/CI.pdf", ciButton);
    }

    public DetailModalPage requestCertificate(){
        webDriver.findElement(requestButton).click();
        return new DetailModalPage(webDriver);
    }


}
