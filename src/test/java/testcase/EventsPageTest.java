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
	
	 EventsPage eventspage;
   @Test
   public void verifyeventDescriptionRequired() throws InterruptedException, IOException {
	  
     	 ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Eventstest");
     	 Login(excel.getCellData(1,0),excel.getCellData(1,1));
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
      public void verifyeventTitleRequired() throws InterruptedException, IOException {
   	   
        	 ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Eventstest");
        	 Login(excel.getCellData(1,0),excel.getCellData(1,1));
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