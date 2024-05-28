package pages;

import components.AbsBaseComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    protected void clearAndType(WebElement element, String text) {
        element.clear();
        element.sendKeys(text);
    }
    protected void clickElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    protected void waitForElementToBeClickable(By locator) {
        waiters.waitForCondition(ExpectedConditions.elementToBeClickable(locator));
    }
}
