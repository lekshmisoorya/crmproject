package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import retryAnalyser.RetryAnalyser;
import pages.ClientsPage;
import pages.Dashboard;
import pages.ItemsPage;
import pages.LoginPage;
import pages.ProfilePage;
import utilities.DataProviderExcel;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ClientsPageTest extends BaseClass
{
	 LoginPage login;
	 Dashboard dashboard;
     ClientsPage clientspage;
     @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata",retryAnalyzer=retryAnalyser.RetryAnalyser.class)
     public void verifClientsCompanyName(String stremail, String strpassword,String clientCompanyName,String clientAddress,String clientCity,String clientState,String clientZip,String clientCountry,String clientPhone,String clientWebsite) throws InterruptedException
     { 
    	 login = new LoginPage(driver);
         dashboard= new Dashboard(driver);
         login.loginPage(stremail, strpassword);
         clientspage = new ClientsPage(driver);
         clientspage.addClient(clientCompanyName, clientAddress, clientCity, clientState,clientZip,clientCountry,FakerUtility.phoneNumber(),clientWebsite);
         Assert.assertTrue(clientspage.checkCompanyName());
         
             
     }
    
}
