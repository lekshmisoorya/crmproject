package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utilities.ElementUtilities;
import utilities.WaitUtilities;

public class Dashboard {
	
		 WebDriver driver;
		 WaitUtilities wait;
	     ElementUtilities element;
             
	    public Dashboard(WebDriver driver){
	    this.driver = driver;
	    wait=new WaitUtilities(driver);
	    element=new ElementUtilities(driver);
	    PageFactory.initElements(driver, this);
	    }
	    @FindBy(xpath="//img[@class='dashboard-image']")
	     WebElement loginchecktodashboard;
	   // @FindBy(xpath="//textarea[@name='note']")
	     //WebElement stickynotes;
	    @FindBy(xpath="//i[@class='fa fa-comments']")
	    WebElement notes;
	    @FindBy(xpath="//textarea[@name='description']")
	    WebElement description;
	    @FindBy(xpath="(//button[@type='button'])[3]")
	    WebElement fileupload;
	    @FindBy(xpath="//button[@type='submit']")
	    WebElement post;
	    public boolean isLoginCheckToDashboardDisplayed() {
	        return loginchecktodashboard.isDisplayed();
	    }
	   /* public boolean verifyStickyNoteAdded(String expectedNote) {
	        try {
	            wait.waitForElementToBeVisible(stickynotes);
	            element.scrollToBottom(stickynotes);
	            String actualNote = stickynotes.getAttribute("value");
	            return actualNote.equals(expectedNote);
	        } catch (Exception e) {
	            System.out.println("Exception occurred: " + e.getMessage());
	            return false; // Return false or handle the situation accordingly
	        }
	    }
	    public void setStickyNoteText(String notesticky) {
	        wait.waitForElementToBeVisible(stickynotes);
	        stickynotes.clear();
	        element.scrollToBottom(stickynotes);
	        element.scrollToElement(stickynotes);
	        stickynotes.sendKeys(notesticky);;
	    }
		public void addDashboardNoteAndVerify(String notesticky) {
			// TODO Auto-generated method stub
			this.verifyStickyNoteAdded(notesticky);
		}*/
	    public void clickNotes() {
			 wait.waitForElementToBeClickable(notes);
		      notes.click();
	    }
	    public void setDescription(String Descriptions)
	    {
	    	wait.waitForElementToBeVisible(description);
	    	description.sendKeys(Descriptions);
	    }		
	    public void uploadFile() throws AWTException, InterruptedException
		{
			
			element.clickOnElement(fileupload);
			element.FileUploadUsingRobotClass(driver,Constant.FILEUPLOAD_PATH);
			
		}
	    public void clickpost()
		{
			element.clickOnElement(post);
		}
	    
	    public void sharedocDashboard(String Descriptions) throws AWTException, InterruptedException
	    {
	    	this.clickNotes();
	    	this.setDescription(Descriptions);
	    	this.uploadFile();
	    	this.clickpost();
	    	
	    	
	    }
	
}
