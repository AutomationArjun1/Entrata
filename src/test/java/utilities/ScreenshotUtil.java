package utilities;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String captureScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destPath = "screenshots/" + testName + "_" + timestamp + ".png";

        File destFile = new File(destPath);
        try {
            File destDir = new File("screenshots");
            if (!destDir.exists()) {
                destDir.mkdirs();
            }
            FileUtils.copyFile(src, destFile);
        } catch (IOException e) {
            System.err.println("Failed to save screenshot: " + e.getMessage());
        }

        return destPath;
    }
}