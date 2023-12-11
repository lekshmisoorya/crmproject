package testcase;

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
	     public void verifyAddDashboardTest(String stremail,String strpassword,String notesticky) throws InterruptedException {
	    	 {
	    	 login = new LoginPage(driver);
	         dashboard= new Dashboard(driver);
	         login.loginPage(stremail, strpassword);	        
	         dashboard.addDashboardNoteAndVerify(notesticky);
	    	 Assert.assertTrue(dashboard.verifyStickyNoteAdded(notesticky));
	     }
	       
	     }
	        
	     }

