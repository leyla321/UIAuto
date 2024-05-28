package pages;

import components.AbsBaseComponents;
import org.openqa.selenium.WebDriver;

public abstract class AbsBasePage extends AbsBaseComponents {
    private final String BASE_URL = System.getProperty("base.url").endsWith("/") ? System.getProperty("base.url")
            .replaceAll("/$", "") : System.getProperty("base.url");
    private String path = "/lk/biography/personal/";

    public AbsBasePage(WebDriver driver, String path) {
        super(driver);
        this.path = path.startsWith("/") ? path : "/" + path;
    }

    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void openProfile() {
        driver.get(BASE_URL + path);
    }
}
