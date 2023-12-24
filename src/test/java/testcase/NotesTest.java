package testcase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard;
import pages.LoginPage;
import pages.Notes;
import utilities.DataProviderExcel;


public class NotesTest extends BaseClass{
	 LoginPage login;
	 Dashboard dashboard;
     Notes     notesPage;
     @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata",groups= {"Regression"})
     public void verifyAddNotesTestTitle(String stremail, String strpassword,String noteTitle,String noteDescription) throws InterruptedException {
         login = new LoginPage(driver);
         dashboard= new Dashboard(driver);
         login.loginPage(stremail, strpassword);
         notesPage = new Notes(driver);
         notesPage.notes(noteTitle,noteDescription);
         Assert.assertTrue(notesPage.checkTableTitle(noteTitle));
       
     }
     @Test(dataProviderClass = DataProviderExcel.class, dataProvider = "logdata",groups= {"Regression"})
     public void verifyAddNotesDescription(String stremail, String strpassword,String noteTitle,String noteDescription) throws InterruptedException {
         login = new LoginPage(driver);
         dashboard= new Dashboard(driver);
         login.loginPage(stremail, strpassword);
         notesPage = new Notes(driver);
         notesPage.notes(noteTitle,noteDescription);
         Assert.assertTrue(notesPage.checkTableDescription(noteTitle));
       
     } 
     }
         
         
    