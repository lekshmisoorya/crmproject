package testcase;



import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Dashboard;
import pages.EventsPage;

import pages.LoginPage;

import utilities.ExcelUtilities;

public class EventsPageTest extends BaseClass{
	LoginPage login;
	 Dashboard dashboard;
	 EventsPage eventspage;
   @Test
   public void verifyUseraddeventDescription() throws InterruptedException, IOException {
	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
     	 ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Eventstest");
       login.setEmail(excel.getCellData(1, 0));
		 login.setPassword(excel.getCellData(1, 1));
		 login.signin();
       eventspage = new EventsPage(driver);
       eventspage.events();
		 eventspage.addevent();
		 eventspage.setTitle(excel.getCellData(1, 2));
		 eventspage.setDescription(excel.getCellData(1, 3));
		 eventspage.setStartdate(excel.getCellData(1, 4));
		 eventspage.setEnddate(excel.getCellData(1, 5));
		 eventspage.setLocation(excel.getCellData(1, 6));
		 eventspage.setRadioButton(excel.getCellData(1, 7));
		 eventspage.clickSaveButton();
     	 Assert.assertTrue(eventspage.checkRequiredDescription());
	     }
   
      @Test
      public void verifyUseraddeventTitle() throws InterruptedException, IOException {
   	   login = new LoginPage(driver);
          dashboard= new Dashboard(driver);
        	 ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Eventstest");
          login.setEmail(excel.getCellData(2, 0));
   		 login.setPassword(excel.getCellData(2, 1));
   		 login.signin();
          eventspage = new EventsPage(driver);
          eventspage.events();
   		 eventspage.addevent();
   		 eventspage.setTitle(excel.getCellData(2, 2));
   		 eventspage.setDescription(excel.getCellData(2, 3));
   		 eventspage.setStartdate(excel.getCellData(2, 4));
   		 eventspage.setEnddate(excel.getCellData(2, 5));
   		 eventspage.setLocation(excel.getCellData(2, 6));
   		 eventspage.setRadioButton(excel.getCellData(2, 7));
   		 eventspage.clickSaveButton();
             Assert.assertTrue(eventspage.checkRequiredTitle());
    	     }
}