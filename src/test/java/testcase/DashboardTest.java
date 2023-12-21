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
	    	 {
	    	 login = new LoginPage(driver);
	         dashboard= new Dashboard(driver);
	       	 ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Dashboardtest");
	         login.setEmail(excel.getCellData(1, 0));
	  		 login.setPassword(excel.getCellData(1, 1));
	  		 login.signin();
	  		dashboard.clickNotes();
	  		dashboard.setDescription(excel.getCellData(1, 2));
	  		dashboard.uploadFile();
	  		dashboard.clickpost();
	  	      
	         Assert.assertTrue(dashboard.isLoginCheckToDashboardDisplayed());
	     }}
	    @Test
	    	 public void verifyDashboardDocumentRequired() throws InterruptedException,IOException, AWTException 
		    	 {
		    		 login = new LoginPage(driver);
			         dashboard= new Dashboard(driver);
			          ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Dashboardtest");
			   		  login.setEmail(excel.getCellData(1, 0));
			  		  login.setPassword(excel.getCellData(1, 1));
			  		  login.signin();
			  		  dashboard.clickNotes();
			  		  dashboard.setDescription(excel.getCellData(1, 3));
			  		  dashboard.uploadFile();
			  		  dashboard.clickpost();
			  	   Assert.assertTrue(dashboard.requiredField().contains(excel.getCellData(1, 4)));
		     }
	     
	    	 }
	     

