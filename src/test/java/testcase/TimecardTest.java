package testcase;


import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import pages.Timecards;
import utilities.DataProviderExcel;


public class TimecardTest extends BaseClass{
	 LoginPage login;
	 Dashboard dashboard;
	 Timecards timecards;
   @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata")
   public void verifyTimeTeammemberrequired(String stremail,String strpassword,String timeTeammembers,String timeIndates,String timeIntimes,String timeOutdates,String timeOuttimes,String timeNotes) throws InterruptedException {
  	   login = new LoginPage(driver);
       dashboard= new Dashboard(driver);
       login.loginPage(stremail, strpassword);
       timecards = new Timecards(driver);
       timecards.addTimeCards(timeTeammembers,timeIndates,timeIntimes,timeOutdates,timeOuttimes,timeNotes); 
       if (timeTeammembers.isEmpty()) {
	         System.out.println("Is description field required? " + timecards.checkRequiredteammember());
	         Assert.assertTrue(timecards.checkRequiredteammember());
       }  }
}

