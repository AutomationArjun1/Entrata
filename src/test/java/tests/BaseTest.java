package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utilities.ConfigReader;
import utilities.ExtentReport;
import utilities.ScreenshotUtil;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected ConfigReader config;

    private static final String CONFIG_PATH = "src/test/resources/testdata.properties";

    @BeforeSuite
    public void initializeReports() {
        ExtentReport.getInstance(); // initializes ExtentReports
    }

    @BeforeMethod
    public void setUp(Method method) {
        config = new ConfigReader(CONFIG_PATH); // loads testdata.properties
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(config.get("url")); // base URL from properties file

        ExtentReport.startTest(method.getName()); // logs the test start
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        String screenshotPath = ScreenshotUtil.captureScreenshot(driver, result.getName());
        String absolutePath = "file:///" + new File(screenshotPath).getAbsolutePath().replace("\\", "/");

        switch (result.getStatus()) {
            case ITestResult.FAILURE:
                ExtentReport.failTest(result.getThrowable(), absolutePath);
                break;
            case ITestResult.SUCCESS:
                ExtentReport.passTest(absolutePath);
                break;
            case ITestResult.SKIP:
                ExtentReport.skipTest();
                break;
        }

        if (driver != null) {
            driver.quit();
        }
    }

    @AfterSuite
    public void flushReports() {
        ExtentReport.flush(); // write everything to the HTML report
    }
}
