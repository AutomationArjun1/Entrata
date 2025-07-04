package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPage {
	private WebDriver driver;

	    @FindBy(xpath = "//div[contains(@id,'w-node')]//a[text()='Sign in']")
	    WebElement signinButton;

	    @FindBy(xpath = "//div[text()='Property Manager Login']")
	    WebElement propertyManagerLoginButton;

	    @FindBy(xpath = "//input[@id='entrata-username']")
	    WebElement usernameField;
	    
	    @FindBy(xpath = "//button[@id='contine-login-btn']")
	    WebElement continueButton;

	    @FindBy(xpath = "//p[@id='statusMessage']")
	    WebElement statusMessage;

	    public SignInPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public void goToSignPage() {
	        signinButton.click();
	    }
	    
	    public void goToPropertyManagerLoginPage() {
	    	propertyManagerLoginButton.click();
	    }

	    public void enterUsername(String username) {
	        usernameField.clear();
	        usernameField.sendKeys(username);
	    }

	    public void clickContinue() {
	        continueButton.click();
	    }

	    public String getEnteredUsername() {
	        return usernameField.getAttribute("value");
	    }

	    public String getStatusMessage() {
	        return statusMessage.getText();
	    }
	}


