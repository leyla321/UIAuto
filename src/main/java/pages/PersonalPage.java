package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalPage extends AbsBasePage {

    public PersonalPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".sc-199a3eq-0.fJMWHf")
    public WebElement elementToHover;

    @FindBy(css = "input[name='fname']")
    public WebElement name;

    @FindBy(css = "#id_fname_latin")
    public WebElement nameLatin;

    @FindBy(css = "#id_lname")
    public WebElement surname;

    @FindBy(css = "#id_lname_latin")
    public WebElement surnameLatin;

    @FindBy(css = "#id_blog_name")
    public WebElement blogName;

    @FindBy(name = "date_of_birth")
    public WebElement dateOfBirth;

    @FindBy(css = "div[data-ajax-slave='/lk/biography/cv/lookup/cities/by_country/']")
    public WebElement countryDropdown;

    @FindBy(css = "button[data-value='13']")
    public WebElement selectCountry;

    @FindBy(xpath = "(//div[contains(@class, 'select') and contains(@class, 'js-lk-cv-custom-select')])[2]")
    public WebElement cityDropdown;

    @FindBy(css = "button[data-value='504']")
    public WebElement selectCity;

    @FindBy(xpath = "(//div[contains(@class, 'js-custom-select-presentation')]//span[@class='placeholder'])[1]")
    public WebElement englishLevel;

    @FindBy(css = "button[data-value='5'][title='Выше среднего (Upper Intermediate)']")
    public WebElement selectEngLevel;

    @FindBy(css = "span.radio__label")
    public WebElement readyToLocateLabel;

    @FindBy(css = "#id_ready_to_relocate_1")
    public WebElement readyToLocate;

    @FindBy(css = "span.checkbox__label.lk-cv-block__text_work-schedule")
    public WebElement workFormatLabel;

    @FindBy(css = "span.checkbox__label.lk-cv-block__text_work-schedule")
    public WebElement workFormatCheckbox;

    @FindBy(css = "#id_contact-0-value")
    public WebElement additionalNumber;

    @FindBy(css = "#id_gender")
    public WebElement gender;

    @FindBy(css = "#id_company")
    public WebElement company;

    @FindBy(css = "#id_work")
    public WebElement work;

    @FindBy(name = "continue")
    public WebElement saveAndContinue;


    public PersonalPage tickRelocationRadioButton(boolean shouldBeChecked) {
        if (readyToLocate.isSelected() != shouldBeChecked) {
            readyToLocateLabel.click();
        }

        return this;
    }

    public PersonalPage tickWorkFormatCheckbox(boolean shouldBeChecked) {
        if (workFormatCheckbox.isSelected() != shouldBeChecked) {
            workFormatLabel.click();
        }

        return this;
    }

    public PersonalPage updatePersonalData() {
        try {
            clearAndType(name, "TestName");
            clearAndType(nameLatin, "LatinNameTest");
            clearAndType(surname, "SurnameTest");
            clearAndType(surnameLatin, "LatinSurnameTest");
            clearAndType(blogName, "BlogNameTest");
            clearAndType(dateOfBirth, "03.05.1989");

            actions.moveToElement(countryDropdown);

            clickElement(countryDropdown);
            clickElement(selectCountry);

            waitForElementToBeClickable(By.cssSelector("button[data-value='13']"));

            clickElement(cityDropdown);
            clickElement(selectCity);
            clickElement(englishLevel);

            actions.moveToElement(selectEngLevel);

            clickElement(selectEngLevel);
            clickElement(readyToLocate);

            actions.moveToElement(workFormatCheckbox);

            clickElement(workFormatCheckbox);
            clearAndType(additionalNumber, "1234567890");

            actions.moveToElement(gender);

            clickElement(gender);
            clearAndType(company, "somewhere");

            actions.moveToElement(work);

            clearAndType(work, "QA");

            actions.moveToElement(saveAndContinue);

            clickElement(saveAndContinue);
            waitForElementToBeClickable(By.name("continue"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new PersonalPage(driver);
    }
}
