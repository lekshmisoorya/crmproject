package testcase;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import constant.Constant;
import pages.LoginPage;
import utilities.ExcelUtilities;
import pages.Dashboard;
@Listeners(listener.ListenerTest.class)
public class LoginPageTest extends BaseClass{
	
         LoginPage login;
	     Dashboard dashboard;
    
	   
	     @Test(priority=1)
	     public void verifyInvalidusername() throws InterruptedException, IOException
	     {
	      ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Logintest");
	   	  String email = excel.getCellData(1, 0);
	   	  String password = excel.getCellData(1, 1);
	   	
	 	  login = new LoginPage(driver);
	 	  login.setEmail(email);
		  login.setPassword(password);
		  login.signin();

	      Assert.assertTrue(login.getAuthenticationFailed());
	     	}
    @Test(priority=2,groups= {"Regression","Sanity"})
    public void verifyValidcredentials() throws InterruptedException, IOException
    {
      ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Logintest");
	  String email = excel.getCellData(2, 0);
	  String password = excel.getCellData(2, 1);
	  login = new LoginPage(driver);
	  login.setEmail(email);
	  login.setPassword(password);
	  login.signin();
	  dashboard=new Dashboard(driver);
    Assert.assertTrue(dashboard.isLoginCheckToDashboardDisplayed());
    } 
    
}

