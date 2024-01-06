package testcase;


import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constant;

import pages.Timecards;
import utilities.DataProviderExcel;
import utilities.ExcelUtilities;


public class TimecardTest extends BaseClass{
	
	 Timecards timecards;
	  @Test
  public void verifyInTimerequired() throws InterruptedException, IOException {
	   ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Timecardtest");
		 Login(excel.getCellData(1,0),excel.getCellData(1,1));
		 timecards = new Timecards(driver);
		 timecards.clickTimeCards();
		 timecards.clickAddtime();
		 timecards.setTeamMemberName(excel.getCellData(2, 2));
		 timecards.setIndate(excel.getCellData(2, 3));
		 timecards.setOutdate(excel.getCellData(2, 5));
		 timecards.setOutTime(excel.getCellData(2, 6));
		 timecards.setNotes(excel.getCellData(2, 7));
		 timecards.saveTime();
 	    Assert.assertTrue(timecards.checkRequiredinTime());
         }
  
   @Test
public void verifyTimeTeammember() throws InterruptedException, IOException
{
	 ExcelUtilities excel= new ExcelUtilities(Constant.EXCEL_FILE_PATH, "Timecardtest");
	 Login(excel.getCellData(1,0),excel.getCellData(1,1));
	 timecards = new Timecards(driver);
	 timecards.clickTimeCards();
	 timecards.clickAddtime();
	 timecards.setTeamMemberName(excel.getCellData(1, 2));
	 timecards.setIndate(excel.getCellData(1, 3));
	 timecards.setInTime(excel.getCellData(1, 4));
	 timecards.setOutdate(excel.getCellData(1, 5));
	 timecards.setOutTime(excel.getCellData(1, 6));
	 timecards.setNotes(excel.getCellData(1, 7));
	 timecards.saveTime();
     Assert.assertTrue(timecards.checkTableTeamMember());
}
    }  

