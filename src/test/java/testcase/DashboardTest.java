package testcase;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Announcements;
import pages.Dashboard;
import pages.LoginPage;
import pages.Notes;
import utilities.ExcelUtilities;

public class DashboardTest extends BaseClass
{
	 LoginPage login;
     Dashboard dashboard;
	    
	     @Test
	     public void verifyDashboardLogo() throws InterruptedException,IOException, AWTException {
	  
	     
	       	 ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Dashboardtest");
	         Login(excel.getCellData(1,0),excel.getCellData(1,1));
	         dashboard= new Dashboard(driver);
	  		dashboard.clickNotes();
	  		dashboard.setDescription(excel.getCellData(1, 2));
	  		dashboard.uploadFile();
	  		dashboard.clickpost();
	  	      
	         Assert.assertTrue(dashboard.isLoginCheckToDashboardDisplayed());
	     }
	    @Test
	    	 public void verifyDashboardDocumentRequiredField() throws InterruptedException,IOException, AWTException 
		    	 {
		    		 
			          ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Dashboardtest");
			          Login(excel.getCellData(1,0),excel.getCellData(1,1));
			          dashboard= new Dashboard(driver);
			  		  dashboard.clickNotes();
			  		  dashboard.setDescription(excel.getCellData(1, 3));
			  		  dashboard.uploadFile();
			  		  dashboard.clickpost();
			  	      Assert.assertTrue(dashboard.requiredField());
		     }
	     
	    	 }
	     

