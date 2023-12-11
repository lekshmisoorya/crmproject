package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;
import generaltest.RetryAnalyzer;
import pages.Dashboard;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class ItemsPageTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
     ItemsPage itemspage;
     @Test(dataProviderClass = ExcelUtilities.class, dataProvider = "logdata",retryAnalyzer = RetryAnalyzer.class)
     public void verifyAddItemsTest(String stremail, String strpassword,String itemTitle,String itemDescription,String itemunittype,String itemRate) throws InterruptedException {
    	 login = new LoginPage(driver);
         dashboard= new Dashboard(driver);
         login.loginPage(stremail, strpassword);
         itemspage = new ItemsPage(driver);
         itemspage.addNewItem(itemTitle, itemDescription, itemunittype, itemRate);
         Assert.assertTrue(itemspage.checkTableDescription(itemDescription));
         
        
       
     }
        
     }

