import exceptions.DriverNotSupportedException;
import factory.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.PersonalPage;

import java.net.MalformedURLException;

public class MainPageTest {
    private WebDriver driver = null;

    public MainPageTest() {
    }

    @BeforeEach
    public void init() throws DriverNotSupportedException, MalformedURLException {
        driver = (new WebDriverFactory()).create();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @org.junit.jupiter.api.Test
    public void logInToOtus() {
        MainPage mainPage = new MainPage(driver);
        mainPage.open();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAndGoToPersonalCabinet();
        mainPage.openProfile();
        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.updatePersonalData();
    }
}
