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
	
	 Announcements announcements;
   @Test
   public void verifyAddAnnouncementsTitle() throws InterruptedException, IOException {
	   ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Announcementtest");
	   Login(excel.getCellData(1,0),excel.getCellData(1,1));
	      announcements = new Announcements(driver);
	      announcements.setAnnouncements();
	      announcements.setAddannouncements();
	      announcements.setTitle(excel.getCellData(1, 2));
	      announcements.setNotes(excel.getCellData(1, 3));
	      announcements.setStartdate(excel.getCellData(1, 4));
	      announcements.setEnddate(excel.getCellData(1, 5));
	      announcements.setCheckBoxClick(excel.getCellData(1, 6));
	      announcements.saveAnnouncement();
	       Assert.assertTrue(announcements.checkTitle());
   }
  
   @Test
   public void titleAnnouncementRequiredField() throws InterruptedException, IOException 
   {
  	    ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Announcementtest");
	  	  Login(excel.getCellData(1,0),excel.getCellData(1,1));
	      announcements = new Announcements(driver);
	      announcements.setAnnouncements();
	      announcements.setAddannouncements();
	      announcements.setTitle(excel.getCellData(1, 7));
	      announcements.setNotes(excel.getCellData(1, 3));
	      announcements.setStartdate(excel.getCellData(1, 4));
	      announcements.setEnddate(excel.getCellData(1, 5));
	      announcements.setCheckBoxClick(excel.getCellData(1, 6));
	      announcements.saveAnnouncement(); 
       Assert.assertTrue(announcements.requiredField());
	}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
}
