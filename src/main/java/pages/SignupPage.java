package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignupPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement firstName;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastName;

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement email;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement company;

    @FindBy(xpath = "//input[@id='Phone']")
    private WebElement phone;

    @FindBy(xpath = "//input[@id='Title']")
    private WebElement jobTitle;

    @FindBy(xpath = "//select[@id='Unit_Count__c']")
    private WebElement totalUnitsDropdown;

    @FindBy(xpath = "//select[@id='demoRequest']")
    private WebElement userTypeDropdown;

    public SignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterFirstName(String value) {
        firstName.clear();
        firstName.sendKeys(value);
    }

    public void enterLastName(String value) {
        lastName.clear();
        lastName.sendKeys(value);
    }

    public void enterEmail(String value) {
        email.clear();
        email.sendKeys(value);
    }

    public void enterCompanyName(String value) {
        company.clear();
        company.sendKeys(value);
    }

    public void enterPhone(String value) {
        phone.clear();
        phone.sendKeys(value);
    }

    public void enterJobTitle(String value) {
        jobTitle.clear();
        jobTitle.sendKeys(value);
    }

    public void selectTotalUnits(String value) {
        //totalUnits.sendKeys(value);
        new Select(totalUnitsDropdown).selectByVisibleText(value);
    }

    public void selectUserType(String value) {
        new Select(userTypeDropdown).selectByVisibleText(value);
    }
    

    public String getFirstNameValue() {
        return firstName.getAttribute("value");
    }

    public String getLastNameValue() {
        return lastName.getAttribute("value");
    }

    public String getEmailValue() {
        return email.getAttribute("value");
    }
}