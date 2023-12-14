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
	  	 @FindBy(xpath="//i[@class='fa fa-comments']")
	    WebElement notes;
	    @FindBy(xpath="//textarea[@name='description']")
	    WebElement description;
	    @FindBy(xpath="(//button[@type='button'])[3]")
	    WebElement fileupload;
	    @FindBy(xpath="//button[@type='submit']")
	    WebElement post;
	    @FindBy(xpath="//span[@id='post_description-error']")
	    WebElement documentrequired;
	    public boolean isLoginCheckToDashboardDisplayed() {
	        return loginchecktodashboard.isDisplayed();
	    }
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
	    public String requiredField() 
	     {
	     return documentrequired.getText();
	     } 
	    
	    public void sharedocDashboard(String Descriptions) throws AWTException, InterruptedException
	    {
	    	this.clickNotes();
	    	this.setDescription(Descriptions);
	    	this.uploadFile();
	    	this.clickpost();
	    	
	    	
	    }
	
}
