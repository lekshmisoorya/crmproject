package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import retryAnalyser.RetryAnalyser;
import pages.Dashboard;
import pages.ItemsPage;
import pages.LoginPage;
import utilities.ExcelUtilities;

public class ItemsPageTest extends BaseClass {
	 LoginPage login;
	 Dashboard dashboard;
     ItemsPage itemspage;
     @Test
     public void verifyAddItemsDescription() throws InterruptedException, IOException {
    	 login = new LoginPage(driver);
         dashboard= new Dashboard(driver);
         ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Itemstest");
	   	  String email = excel.getCellData(1, 0);
	   	  String password = excel.getCellData(1, 1);
	   	  String itemTitle = excel.getCellData(1, 2);
	   	 String itemDescription = excel.getCellData(1, 3);
	   	 String itemunittype = excel.getCellData(1, 4);
	   	 String itemRate = excel.getCellData(1, 5);
	 	  login = new LoginPage(driver);
	 	  login.setEmail(email);
		  login.setPassword(password);
		  login.signin();
         itemspage = new ItemsPage(driver);
         itemspage.clickItems();
         itemspage.additems();
         itemspage.setTitle(itemTitle);
         itemspage.setDescription(itemDescription);
         itemspage.setUnitType(itemunittype);
         itemspage.setItemrate(itemRate);
         itemspage.clickSaveButton();
         itemspage.clickSearchNotes(itemDescription);
         itemspage.clickFirstPageOfTable();
         itemspage.checkTableDescription(itemDescription);
         itemspage.verifyDeleteItem();
         Assert.assertTrue(itemspage.checkTableDescription(itemDescription));
                     
     }
     @Test
     public void verifyItemsTitle() throws InterruptedException, IOException 
     {
    	 login = new LoginPage(driver);
         dashboard= new Dashboard(driver);
         itemspage = new ItemsPage(driver);
         ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Itemstest");
	   	  String email = excel.getCellData(1, 0);
	   	  String password = excel.getCellData(1, 1);
	   	  String itemTitle = excel.getCellData(1, 2);
	   	 String itemDescription = excel.getCellData(1, 3);
	   	 String itemunittype = excel.getCellData(1, 4);
	   	 String itemRate = excel.getCellData(1, 5);
	 	  login = new LoginPage(driver);
	 	  login.setEmail(email);
		  login.setPassword(password);
		  login.signin();
        itemspage = new ItemsPage(driver);
        itemspage.clickItems();
        itemspage.additems();
        itemspage.setTitle(itemTitle);
        itemspage.setDescription(itemDescription);
        itemspage.setUnitType(itemunittype);
        itemspage.setItemrate(itemRate);
        itemspage.clickSaveButton();
        itemspage.clickSearchNotes(itemDescription);
        itemspage.clickFirstPageOfTable();
        itemspage.checkTableDescription(itemDescription);
        itemspage.verifyDeleteItem();
         Assert.assertTrue(itemspage.checkTableTitle(itemTitle));
         
                     
     }
        
     }

