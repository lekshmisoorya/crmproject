package testcase;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import generaltest.RetryAnalyzer;
import pages.LoginPage;

import utilities.ExcelUtilities;
import pages.Dashboard;
@Listeners(generaltest.ListenerTest.class)
public class LoginPageTest extends BaseClass{
	
         LoginPage login;
	     Dashboard dashboard;
    
	     @Test(priority=1,dataProviderClass=ExcelUtilities.class,dataProvider="logdata")
	     public void invalid_username(String stremail,String strpassword){
	 	   login = new LoginPage(driver);
	       	login.loginPage(stremail,strpassword);
	       	dashboard=new Dashboard(driver);
	     	Assert.assertTrue(login.getAuthenticationFailed().contains("Authentication failed!"));
	     	System.out.println("username not valid");}

    
  @Test(priority=2,dataProviderClass=ExcelUtilities.class,dataProvider="logdata",groups= {"Regression","Sanity"})
    public void verifyValid_credentials(String stremail,String strpassword) throws InterruptedException
{
    	login = new LoginPage(driver);
    	login.loginPage(stremail,strpassword);
    	dashboard=new Dashboard(driver);
    	Assert.assertTrue(dashboard.isLoginCheckToDashboardDisplayed());
    	System.out.println("valid credentials");
    }}
  
