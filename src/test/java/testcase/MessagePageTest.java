package testcase;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Dashboard;

import pages.LoginPage;
import pages.MessagePage;

import utilities.ExcelUtilities;

public class MessagePageTest extends BaseClass {
	
	 MessagePage messagepage;
	 @Test(priority=1)
	 public void verifyUsermessagesent() throws TimeoutException, InterruptedException, IOException 
	  {
  	   
       ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Messagetest");
       Login(excel.getCellData(1,0),excel.getCellData(1,1));
       messagepage = new MessagePage(driver);
       messagepage.clickMessages();
       messagepage.clickCompose();
       messagepage.enterRecipient(excel.getCellData(1, 2));
       messagepage.enterSubject(excel.getCellData(1, 3));
       messagepage.enterMessageText(excel.getCellData(1, 4));
       messagepage.clickSend(); 
       Assert.assertTrue(messagepage.checkMessageGone());
}
	 @Test(priority=2)
	    public void verifyUserSubjectRequired() throws TimeoutException, InterruptedException, IOException 
		  {
	   	    
	        ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Messagetest");
	        Login(excel.getCellData(1,0),excel.getCellData(1,1));
	        messagepage = new MessagePage(driver);
	        messagepage.clickMessages();
	        messagepage.clickCompose();
	        messagepage.enterRecipient(excel.getCellData(1, 2));
	        messagepage.enterSubject(excel.getCellData(1, 5));
	        messagepage.enterMessageText(excel.getCellData(1, 4));
	        messagepage.clickSend(); 
	    	Assert.assertTrue(messagepage.requiredField());
		  }}





