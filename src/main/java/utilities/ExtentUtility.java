package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import constant.Constant;

public class ExtentUtility {

    public static ExtentReports createextentreport() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(Constant.EXTENT_REPORT);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        return extent;
    }
}