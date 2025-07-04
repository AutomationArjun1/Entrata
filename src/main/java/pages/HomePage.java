
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {
    private WebDriver driver;

    private By productsMenu = By.xpath("//div[text()='Products']");
    private By resourcesMenu = By.xpath("//div[text()='Resources']");
    private By productUpdatesMenu = By.xpath("//div[text()='Product Updates']");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProductsMenu() {
        driver.findElement(productsMenu).click();
    }

    public void hoverOverResourcesAndClickProductUpdates() {
        Actions actions = new Actions(driver);
        WebElement resources = driver.findElement(resourcesMenu);
        WebElement productUpdates = driver.findElement(productUpdatesMenu);
        actions.moveToElement(resources).moveToElement(productUpdates).click().build().perform();
    }
}
