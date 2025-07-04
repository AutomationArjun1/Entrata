package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReport {
    private static ExtentReports extent;
    private static ExtentTest test;

    public static ExtentReports getInstance() {
        if (extent == null) {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File reportDir = new File("reports");
            if (!reportDir.exists()) {
                reportDir.mkdirs();
            }

            ExtentSparkReporter htmlReporter = new ExtentSparkReporter("reports/extent-report_" + timestamp + ".html");
            htmlReporter.config().setTheme(Theme.DARK);
            htmlReporter.config().setDocumentTitle("Entrata Automation Report");
            htmlReporter.config().setReportName("Regression Suite");
            htmlReporter.config().setTimelineEnabled(true);
            htmlReporter.config().setEncoding("utf-8");

            extent = new ExtentReports();
            extent.attachReporter(htmlReporter);
            extent.setSystemInfo("OS", System.getProperty("os.name"));
            extent.setSystemInfo("User", System.getProperty("user.name"));
            extent.setSystemInfo("Java Version", System.getProperty("java.version"));
        }
        return extent;
    }

    public static void startTest(String testName) {
        test = extent.createTest(testName);
    }

    public static void logInfo(String message) {
        if (test != null) {
            test.log(Status.INFO, message);
        }
    }

    public static void passTest(String screenshotPath) {
        try {
            test.pass("Test Passed",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            test.pass("Test Passed, but screenshot couldn't be attached.");
        }
    }

    public static void failTest(Throwable error, String screenshotPath) {
        try {
            test.fail(error,
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        } catch (Exception e) {
            test.fail(error);
        }
    }

    public static void skipTest() {
        test.skip("Test Skipped");
    }

    public static void flush() {
        if (extent != null) {
            extent.flush();
        }
    }
}
