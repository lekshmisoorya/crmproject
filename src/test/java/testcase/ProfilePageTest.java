package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import pages.MessagePage;
import pages.ProfilePage;
import utilities.DataProviderExcel;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ProfilePageTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
	 ProfilePage profilepage;
   @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata",groups= {"Regression"})
   public void verifyUseraddprofileAddress(String stremail,String strpassword,String profilefirstname,String profilelastname,String email,String Address,String phoneNumber,String skypeData,String ssnNum,String gender) throws InterruptedException {
  	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
       login.loginPage(stremail, strpassword);
       profilepage = new ProfilePage(driver);
       profilepage.addProfile(profilefirstname,profilelastname,FakerUtility.emailID(),Address,phoneNumber,skypeData,ssnNum,gender); 
        Assert.assertTrue(profilepage.checkAddress(Address));
   }
   @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata",groups= {"Regression"})
   public void verifyFirstName(String stremail,String strpassword,String profilefirstname,String profilelastname,String email,String Address,String phoneNumber,String skypeData,String ssnNum,String gender) throws InterruptedException {
  	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
       login.loginPage(stremail, strpassword);
       profilepage = new ProfilePage(driver);
       profilepage.addProfile(profilefirstname,profilelastname,FakerUtility.emailID(),Address,phoneNumber,skypeData,ssnNum,gender); 
        Assert.assertTrue(profilepage.checkfirstName(profilefirstname));
   }
}
