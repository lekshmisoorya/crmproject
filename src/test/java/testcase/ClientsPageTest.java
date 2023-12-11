package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import generaltest.RetryAnalyzer;
import pages.ClientsPage;
import pages.Dashboard;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class ClientsPageTest extends BaseClass
{
	 LoginPage login;
	 Dashboard dashboard;
     ClientsPage clientspage;
     @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata")
     public void verifyAddClientsTest(String stremail, String strpassword,String clientCompanyName,String clientAddress,String clientCity,String clientState,String clientZip,String clientCountry,String clientPhone,String clientWebsite,String clientVatNumber) throws InterruptedException
     { 
    	 login = new LoginPage(driver);
         dashboard= new Dashboard(driver);
         login.loginPage(stremail, strpassword);
         clientspage = new ClientsPage(driver);
         clientspage.addClient(clientCompanyName, clientAddress, clientCity, clientState,clientZip,clientCountry,clientPhone,clientWebsite,clientVatNumber);
         Assert.assertTrue(clientspage.setPrintID());
         
             
     }
}
