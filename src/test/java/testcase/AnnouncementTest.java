package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Announcements;
import pages.Dashboard;
import pages.LoginPage;

import utilities.ExcelUtilities;

public class AnnouncementTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
	 Announcements announcements;
   @Test
   public void verifyAddAnnouncementsTitle() throws InterruptedException, IOException {
	   ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Announcementtest");
		  String email = excel.getCellData(1, 0);
		  String password = excel.getCellData(1, 1);
		  login = new LoginPage(driver);
		  login.setEmail(email);
		  login.setPassword(password);
		  login.signin();
	      dashboard= new Dashboard(driver);
	      announcements = new Announcements(driver);
	      announcements.setAnnouncements();
	      announcements.setAddannouncements();
	      announcements.setTitle(excel.getCellData(1, 2));
	      announcements.setNotes(excel.getCellData(1, 3));
	      announcements.setStartdate(excel.getCellData(1, 4));
	      announcements.setEnddate(excel.getCellData(1, 5));
	      announcements.setCheckBoxClick(excel.getCellData(1, 6));
	      announcements.saveAnnouncement();
	       Assert.assertTrue(announcements.checkTitle(excel.getCellData(1, 2)));
   }
  
   @Test
   public void titleErrorAnnouncement() throws InterruptedException, IOException 
   {
  	    ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Announcementtest");
		  String email = excel.getCellData(1, 0);
		  String password = excel.getCellData(1, 1);
		  login = new LoginPage(driver);
		  login.setEmail(email);
		  login.setPassword(password);
		  login.signin();
	      dashboard= new Dashboard(driver);
	      announcements = new Announcements(driver);
	      announcements.setAnnouncements();
	      announcements.setAddannouncements();
	      announcements.setTitle(excel.getCellData(1, 7));
	      announcements.setNotes(excel.getCellData(1, 3));
	      announcements.setStartdate(excel.getCellData(1, 4));
	      announcements.setEnddate(excel.getCellData(1, 5));
	      announcements.setCheckBoxClick(excel.getCellData(1, 6));
	      announcements.saveAnnouncement(); 
       Assert.assertTrue(announcements.requiredField().contains("This field is required."));
	}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
