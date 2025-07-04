package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class NavigationTest extends BaseTest {

    /**
     * Test Case: Hover on Resources > Click on Product Updates and verify page
     */
    @Test
    public void testNavigateToProductUpdates() {
        HomePage homePage = new HomePage(driver);

        // Hover and click using POM
        homePage.hoverOverResourcesAndClickProductUpdates();

        // Assertion - wait and verify Product Updates page is displayed
        WebElement heading = driver.findElement(By.xpath("//h1[contains(text(),'Product Updates') or contains(text(),'Updates')]"));
        Assert.assertTrue(heading.isDisplayed(), "Product Updates heading is not visible");
    }
}