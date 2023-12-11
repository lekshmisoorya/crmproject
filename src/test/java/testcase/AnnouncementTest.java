package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Announcements;
import pages.Dashboard;
import pages.LoginPage;

import utilities.ExcelUtilities;

public class AnnouncementTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
	 Announcements announcements;
   @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
   public void verifyAddAnnouncements(String stremail,String strpassword,String announcementTitle,String announcementNotes,String announcementStartdate,String announcementEnddate) throws InterruptedException {
  	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
       login.loginPage(stremail, strpassword);
       announcements = new Announcements(driver);
       announcements.createAnnouncements(announcementTitle,announcementNotes,announcementStartdate,announcementEnddate); 
      Assert.assertTrue(announcements.checkTitle(announcementTitle));
   }
}
