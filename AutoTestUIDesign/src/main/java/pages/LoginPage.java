package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbsBasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    String username = System.getProperty("username");
    String password = System.getProperty("password");
    @FindBy(css = "button.sc-mrx253-0.enxKCy.sc-945rct-0.iOoJwQ")
    private WebElement signInButton;

    @FindBy(xpath = "//div[./input[@name='email']]")
    private WebElement emailField;

    @FindBy(name = "email")
    private WebElement email;

    @FindBy(css = ".sc-177u1yy-0.sc-rq8xzv-2.xkNdd")
    private WebElement password2;

    @FindBy(css = "input[type='password']")
    public WebElement password3;

    @FindBy(css = ".sc-9a4spb-0.eQlGvH.sc-11ptd2v-2-Component.cElCrZ")
    private WebElement signInButton2;

    @FindBy(xpath = "//a[contains(text(),'Личный кабинет')]")
    public WebElement personalCabinet;


    public LoginPage loginAndGoToPersonalCabinet() {
        clickElement(signInButton);
        waitForElementToBeClickable(By.xpath("//div[./input[@name='email']]"));
        clickElement(emailField);
        email.sendKeys(username);

        clickElement(password2);
        password3.sendKeys(password);
        clickElement(signInButton2);
        waitForElementToBeClickable(By.cssSelector(".sc-199a3eq-0.fJMWHf"));
        waitForElementToBeClickable(By.xpath("//a[contains(text(),'Личный кабинет')]"));
        return new LoginPage(driver);
    }

    private void clickElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

    private void waitForElementToBeClickable(By locator) {
        waiters.waitForCondition(ExpectedConditions.elementToBeClickable(locator));
    }
}
