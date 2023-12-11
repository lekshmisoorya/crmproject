package testcase;

import java.util.concurrent.TimeoutException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.ItemsPage;
import pages.LoginPage;
import pages.MessagePage;
import utilities.ExcelUtilities;

public class MessagePageTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
	 MessagePage messagepage;
    @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
    public void verifyUseraddmessage(String stremail,String strpassword,String address, String messageSubject,String message) throws TimeoutException, InterruptedException 
	  {
   	    login = new LoginPage(driver);
        dashboard= new Dashboard(driver);
        login.loginPage(stremail, strpassword);
        messagepage = new MessagePage(driver);
        messagepage.addMessage(address, messageSubject, message);
        Assert.assertTrue(messagepage.checkMessageSent());
}}
