package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SignInPage;

public class SignInTest extends BaseTest {

    @Test
    public void testFormFieldInteraction() {
        SignInPage signInPage = new SignInPage(driver);

        signInPage.goToSignPage();
        signInPage.goToPropertyManagerLoginPage();

        String username = config.get("username");
        signInPage.enterUsername(username);
        signInPage.clickContinue();


        //Assert.assertEquals(signInPage.getEnteredUsername(), username);
        Assert.assertEquals(signInPage.getStatusMessage(), "The username is not valid. Please try again.");
    }
}