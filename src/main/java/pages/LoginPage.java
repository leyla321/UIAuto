package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    private WebElement passwordForClicking;

    @FindBy(css = "input[type='password']")
    public WebElement passwordForTyping;

    @FindBy(css = ".sc-9a4spb-0.eQlGvH.sc-11ptd2v-2-Component.cElCrZ")
    private WebElement signInButton2;

    @FindBy(xpath = "//a[contains(text(),'Личный кабинет')]")
    public WebElement personalCabinet;

    @FindBy(css = ".sc-199a3eq-0.fJMWHf")
    public WebElement userProfileName;


    public LoginPage loginAndGoToPersonalCabinet() {
        clickElement(signInButton);
        waitForElementToBeClickable(By.xpath("//div[./input[@name='email']]"));
        clickElement(emailField);
        email.sendKeys(username);

        clickElement(passwordForClicking);
        passwordForTyping.sendKeys(password);
        clickElement(signInButton2);
        waitForElementToBeClickable(By.cssSelector(".sc-199a3eq-0.fJMWHf"));
        waitForElementToBeClickable(By.xpath("//a[contains(text(),'Личный кабинет')]"));
        return new LoginPage(driver);
    }

    public LoginPage verifyUpdatedData() {
        clickElement(signInButton);
        waitForElementToBeClickable(By.xpath("//div[./input[@name='email']]"));
        clickElement(emailField);
        email.sendKeys(username);

        clickElement(passwordForClicking);
        passwordForTyping.sendKeys(password);
        clickElement(signInButton2);
        waitForElementToBeClickable(By.cssSelector(".sc-199a3eq-0.fJMWHf"));
        String expectedResult = "TestName";
        Assertions.assertEquals(expectedResult, userProfileName.getText());
        return this;
    }
}
