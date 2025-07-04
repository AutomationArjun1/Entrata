package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTest extends BaseTest {

    @Test
    public void testSignupFormInput() {
        SignupPage signupPage = new SignupPage(driver);

        signupPage.enterFirstName(config.get("firstname"));
        signupPage.enterLastName(config.get("lastname"));
        signupPage.enterEmail(config.get("email"));
        signupPage.enterCompanyName(config.get("company"));
        signupPage.enterPhone(config.get("phone"));
        signupPage.enterJobTitle(config.get("jobtitle"));
        signupPage.selectTotalUnits(config.get("totalunits"));
        signupPage.selectUserType(config.get("userType"));

        Assert.assertEquals(signupPage.getFirstNameValue(), config.get("firstname"));
        Assert.assertEquals(signupPage.getLastNameValue(), config.get("lastname"));
        Assert.assertEquals(signupPage.getEmailValue(), config.get("email"));
    }
}