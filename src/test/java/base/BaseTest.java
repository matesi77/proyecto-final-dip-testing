package base;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver webDriver;
    private String url = "https://desarrollo.adsib.gob.bo/desa_solicitudes/login";
    //private String url = "https://desarrollo.adsib.gob.bo/solicitudes/login";
    //private String browser = "chrome";
    private String browser = "firefox";

    @BeforeMethod
    public  void setUp(){
        webDriver = new FactoryBrowser().make(browser).create();
        webDriver.get(url);
        webDriver.manage().window().maximize();
    }

    //@AfterMethod
    public void tearDown(){
        if (webDriver != null){
            webDriver.quit();
        }
    }
}
