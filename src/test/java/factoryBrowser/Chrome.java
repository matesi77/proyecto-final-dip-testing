package factoryBrowser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome implements IBrowser{
    @Override
    public WebDriver create() {
        String pathDriver = "resource/chromedriver";
        System.setProperty("webdriver.chrome.driver", pathDriver);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new ChromeDriver(chromeOptions);
        return driver;
    }
}
