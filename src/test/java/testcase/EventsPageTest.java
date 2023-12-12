package testcase;



import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.EventsPage;

import pages.LoginPage;

import utilities.ExcelUtilities;

public class EventsPageTest extends BaseClass{
	LoginPage login;
	 Dashboard dashboard;
	 EventsPage eventspage;
   @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
   public void verifyUseraddevent(String stremail,String strpassword,String eventsTitle, String eventsDescription,String eventsStartdate,String eventsEnddate,String eventsLocation,String radiobuttontext) throws InterruptedException {
  	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
       login.loginPage(stremail, strpassword);
       eventspage = new EventsPage(driver);
       eventspage.addingEvents(eventsTitle, eventsDescription,eventsStartdate,eventsEnddate,eventsLocation,radiobuttontext);
       if (eventsDescription.isEmpty()) {
	         System.out.println("Is description field required? " + eventspage.checkRequiredDescription());
	         Assert.assertTrue(eventspage.checkRequiredDescription());
	     }
}}