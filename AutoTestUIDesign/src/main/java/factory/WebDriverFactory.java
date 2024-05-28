package factory;

import data.BrowserNameData;
import exceptions.DriverNotSupportedException;
import factory.impl.ChromeWebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.Locale;

public class WebDriverFactory implements IDriverFactory {
    private String browserName = System.getProperty("browser.name", "chrome");

    public WebDriverFactory() {
    }

    public WebDriver create() throws DriverNotSupportedException {
        BrowserNameData browserNameData = BrowserNameData.valueOf(browserName.toUpperCase(Locale.ROOT));
        switch (browserNameData) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) (new ChromeWebDriver()).settings());
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            default:
                throw new DriverNotSupportedException(browserName);
        }
    }

    public WebDriver getDriver() throws DriverNotSupportedException {
        return null;
    }
}
