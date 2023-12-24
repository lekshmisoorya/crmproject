package testcase;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;

import pages.LoginPage;
import pages.MessagePage;
import utilities.DataProviderExcel;


public class MessagePageTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
	 MessagePage messagepage;
    @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata")
    public void verifyUsermessagesent(String stremail,String strpassword,String address, String messageSubject,String message) throws TimeoutException, InterruptedException 
	  {
   	    login = new LoginPage(driver);
        dashboard= new Dashboard(driver);
        login.loginPage(stremail, strpassword);
        messagepage = new MessagePage(driver);
        messagepage.addMessage(address, messageSubject, message);
        Assert.assertTrue(messagepage.checkMessageGone());
}

    @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata")
    public void verifyUserSubjectRequired(String stremail,String strpassword,String address, String messageSubject,String message) throws TimeoutException, InterruptedException 
	  {
   	    login = new LoginPage(driver);
        dashboard= new Dashboard(driver);
        login.loginPage(stremail, strpassword);
        messagepage = new MessagePage(driver);
        messagepage.addMessage(address, messageSubject, message);
    	Assert.assertTrue(messagepage.requiredField());
	  }}
