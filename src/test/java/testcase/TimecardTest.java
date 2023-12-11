package testcase;


import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import pages.Timecards;
import utilities.ExcelUtilities;

public class TimecardTest extends BaseClass{
	 LoginPage login;
	 Dashboard dashboard;
	 Timecards timecards;
   @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
   public void verifyTime(String stremail,String strpassword,String timeTeammembers,String timeIndates,String timeIntimes,String timeOutdates,String timeOuttimes,String timeNotes) throws InterruptedException {
  	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
       login.loginPage(stremail, strpassword);
       timecards = new Timecards(driver);
       timecards.addTimeCards(timeTeammembers,timeIndates,timeIntimes,timeOutdates,timeOuttimes,timeNotes); 
      //Assert.assertTrue(announcements.checkTitle(announcementTitle));
   }
}

