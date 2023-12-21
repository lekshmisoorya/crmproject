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
    
	   /*  @Test(priority=1)
	     public void invalid_username(String stremail,String strpassword){
	 	   login = new LoginPage(driver);
	       	login.loginPage(stremail,strpassword);
	      	Assert.assertTrue(login.requiredField().contains("Please enter a valid email address."));
	     	}*/
	   /* public void performLogin(String stremail,String strpassword) throws InterruptedException {
	    	 login = new LoginPage(driver);
		        login.loginPage(stremail,strpassword);
		        System.out.println("login successful");
		    }*/
	     @Test(priority=1)
	     public void invalidusername() throws InterruptedException, IOException
	     {
	      ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Logintest");
	   	  String email = excel.getCellData(1, 0);
	   	  String password = excel.getCellData(1, 1);
	   	  String data = excel.getCellData(1, 2);
	 	  login = new LoginPage(driver);
	 	  login.setEmail(email);
		  login.setPassword(password);
		  login.signin();

	      Assert.assertTrue(login.getAuthenticationFailed().contains(data));
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
/*@Test(priority=1)
public void Valid_LoginTest() throws InterruptedException, IOException {
   
    ReadExcelData excelData = new ReadExcelData(constant.EXCEL_FILE_PATH, "LoginTest");
    String username = excelData.getCellData(1, 0);
    String password = excelData.getCellData(1, 1);
    String value =excelData.getCellData(1, 2);

    objLogin = new LoginPage(driver);
    objLogin.setUsername(username);
    objLogin.setPassword(password);
    objLogin.clickLogin();
    Assert.assertTrue(objLogin.getToastMessage());
    Assert.assertTrue(objLogin.verifyWelcomeText(value));
  
}*/
