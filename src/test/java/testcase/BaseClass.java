package testcase;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.util.Constants;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Dashboard;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class BaseClass {
    WebDriver driver;
    LoginPage login;
	 Dashboard dashboard;
	
    public static Properties prop = new Properties();
    @BeforeMethod
    @Parameters({"Browser"})
     public void setUpDriverOpenUrl(String browser) {
        if (driver == null) {
            // Load the properties file
            try (FileInputStream input = new FileInputStream(Constant.CONFIG_PROPERTY_FILE_PATH)) {
                prop.load(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Rest of your browser setup remains the same
        if (browser.equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            System.out.println("Enter correct browser");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Retrieve the URL from the properties file
        String url = prop.getProperty("url");
        if (url != null && !url.isEmpty()) {
            driver.get(url);
        } else {
            System.out.println("URL not found in properties file");
        }
    }
   
   
    @AfterMethod
    public void takeScreenshotOnFailure(ITestResult iTestResult) throws IOException {
      	System.out.println(iTestResult.getStatus());
        System.out.println(ITestResult.FAILURE);
            if (iTestResult.getStatus() == ITestResult.FAILURE) {
               takeScreenShotOnFailure(iTestResult.getName());
               
            }
	      
  if(driver!=null)
  {
	  driver.quit();
    }
    }
    public String takeScreenShotOnFailure(String name) throws IOException {
    	   String dateName = new SimpleDateFormat("yyyy_MM_dd_hh_mm").format(new Date());
    	   File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//takes screenshot
    	   String destination = Constant.SCREENSHOT_PATH + name + dateName + ".png";
    	   File finalDestination = new File(destination);
    	   FileUtils.copyFile(source, finalDestination);
		    return destination;
    	      	}
    }
 




