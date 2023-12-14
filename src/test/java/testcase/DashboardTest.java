package testcase;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import pages.Notes;
import utilities.ExcelUtilities;

public class DashboardTest extends BaseClass
{
		 LoginPage login;
		 Dashboard dashboard;
	    
	     @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
	     public void verifyDashboardLogo(String stremail,String strpassword,String Descriptions) throws InterruptedException, AWTException {
	    	 {
	    	 login = new LoginPage(driver);
	         dashboard= new Dashboard(driver);
	         login.loginPage(stremail, strpassword);	        
	         dashboard.sharedocDashboard(Descriptions);
	         Assert.assertTrue(dashboard.isLoginCheckToDashboardDisplayed());
	     }}
	     @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
	    	 public void verifyDashboardDocumentRequired(String stremail,String strpassword,String Descriptions) throws InterruptedException, AWTException {
		    	 {
		    	 login = new LoginPage(driver);
		         dashboard= new Dashboard(driver);
		         login.loginPage(stremail, strpassword);	        
		         dashboard.sharedocDashboard(Descriptions);
		         Assert.assertTrue(dashboard.requiredField().contains("This field is required."));
		     }
	     
	    	 }
	     }

