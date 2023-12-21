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
		  String title = excel.getCellData(1, 2);
		  String notes = excel.getCellData(1, 3);
		  String startdate = excel.getCellData(1, 4);
		  String enddate = excel.getCellData(1, 5);
		  String checktext = excel.getCellData(1, 6);
		  login = new LoginPage(driver);
		  login.setEmail(email);
		  login.setPassword(password);
		  login.signin();
	      dashboard= new Dashboard(driver);
	      announcements = new Announcements(driver);
	      announcements.setAnnouncements();
	      announcements.setAddannouncements();
	      announcements.setTitle(title);
	      announcements.setNotes(notes);
	      announcements.setStartdate(startdate);
	      announcements.setEnddate(enddate);
	      announcements.setCheckBoxClick(checktext);
	      announcements.saveAnnouncement();
	       Assert.assertTrue(announcements.checkTitle(title));
   }
  
   @Test
   public void titleErrorAnnouncement() throws InterruptedException, IOException 
   {
  	    ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Announcementtest");
		  String email = excel.getCellData(1, 0);
		  String password = excel.getCellData(1, 1);
		//  String title = excel.getCellData(1, 7);
		 // String notes = excel.getCellData(1, 3);
		//  String startdate = excel.getCellData(1, 4);
		//  String enddate = excel.getCellData(1, 5);
		//  String checktext = excel.getCellData(1, 6);
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
