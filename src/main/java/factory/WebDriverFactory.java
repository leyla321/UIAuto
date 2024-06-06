package factory;

import data.BrowserNameData;
import exceptions.DriverNotSupportedException;
import factory.impl.ChromeWebDriver;
import factory.impl.RemoteSettings;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Locale;

public class WebDriverFactory implements IDriverFactory {
    private String browserName = System.getProperty("browser.name", "chrome");
    private String remoteGridUrl = System.getProperty("remote.url", "https://193.104.57.173/wd/hub");

    public WebDriverFactory() {
    }

    public WebDriver create() throws DriverNotSupportedException, MalformedURLException {
        BrowserNameData browserNameData = BrowserNameData.valueOf(browserName.toUpperCase(Locale.ROOT));
        switch (browserNameData) {
            case CHROME:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver((ChromeOptions) (new ChromeWebDriver()).settings());
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                return new FirefoxDriver(firefoxOptions);
            case REMOTE:
                RemoteSettings chromeOptions = new RemoteSettings();
                return new RemoteWebDriver(new URL(remoteGridUrl), chromeOptions.settings());
            default:
                throw new DriverNotSupportedException(browserName);
        }
    }

    public WebDriver getDriver() throws DriverNotSupportedException {
        return null;
    }
}
