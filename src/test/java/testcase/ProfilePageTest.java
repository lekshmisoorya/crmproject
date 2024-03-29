package testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;
import pages.Dashboard;
import pages.LoginPage;

import pages.ProfilePage;
import utilities.DataProviderExcel;
import utilities.ExcelUtilities;
import utilities.FakerUtility;

public class ProfilePageTest extends BaseClass {
	 
	 ProfilePage profilepage;
   @Test(groups= {"Regression"})
   public void verifyvalidationFirstname() throws InterruptedException, IOException {
  	   
  	   ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Profiletest");
  	 Login(excel.getCellData(1,0),excel.getCellData(1,1));
       profilepage = new ProfilePage(driver);
       profilepage.clickProfile();
       profilepage.clickMyProfile();
       profilepage.setFirstName(excel.getCellData(1,2));
       profilepage.setLastName(excel.getCellData(1, 3));
       profilepage.setEmail(excel.getCellData(1, 4));
       profilepage.setAlternativeAddress(excel.getCellData(1, 5));
       profilepage.setPhone(excel.getCellData(1, 6));
       profilepage.setSkype(excel.getCellData(1, 7));
       profilepage.setSSN(excel.getCellData(1, 8));
       profilepage.setGender(excel.getCellData(1, 9));
       profilepage.saveProfile();

        Assert.assertTrue(profilepage.validateFirstname());
   }
  @Test(groups= {"Sanity"})
   public void verifyRequiredFirstName() throws InterruptedException, IOException 
  {
	  
 	   ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Profiletest");
 	  Login(excel.getCellData(1,0),excel.getCellData(1,1));
       profilepage = new ProfilePage(driver);
       profilepage.clickProfile();
       profilepage.clickMyProfile();
       profilepage.setFirstName(excel.getCellData(1, 10));
       profilepage.setLastName(excel.getCellData(1, 11));
       profilepage.setEmail(excel.getCellData(1, 12));
       profilepage.setAlternativeAddress(excel.getCellData(1, 13));
       profilepage.setPhone(excel.getCellData(1, 14));
       profilepage.setSkype(excel.getCellData(1, 15));
       profilepage.setSSN(excel.getCellData(1, 16));
       profilepage.setGender(excel.getCellData(1, 17));
       profilepage.saveProfile();
       Assert.assertTrue(profilepage.nameRequiredField());
  }}

