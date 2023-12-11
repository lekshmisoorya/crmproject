package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import pages.MessagePage;
import pages.ProfilePage;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ProfilePageTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
	 ProfilePage profilepage;
   @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
   public void verifyUseraddprofile(String stremail,String strpassword,String profilefirstname,String profilelastname,String email,String Address,String phoneNumber,String skypeData,String ssnNum,String gender) throws InterruptedException {
  	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
       login.loginPage(stremail, strpassword);
       profilepage = new ProfilePage(driver);
       profilepage.addProfile(profilefirstname,profilelastname,FakerUtility.emailID(),Address,phoneNumber,skypeData,ssnNum,gender); 
       System.out.println(FakerUtility.emailID());
       Assert.assertTrue(profilepage.checkAddress(Address));
   }
}
