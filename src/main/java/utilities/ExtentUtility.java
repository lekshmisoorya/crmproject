package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentUtility {

    public static ExtentReports createextentreport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(System.getProperty("user.dir") + "\\extend-report\\extent-report.html");
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}