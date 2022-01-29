package factoryBrowser;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Firefox implements IBrowser{
    @Override
    public WebDriver create() {
        String pathDriver = "resource/geckodriver";
        System.setProperty("webdriver.gecko.driver", pathDriver);
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        return driver;
    }
}
