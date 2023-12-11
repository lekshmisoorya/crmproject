package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.WaitUtilities;

public class Announcements {
	WebDriver driver;
	ElementUtilities element;
	WaitUtilities wait;
	JavascriptExecutor js;
	 public Announcements(WebDriver driver)
	 {
	      this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
	      js = (JavascriptExecutor) driver;
         PageFactory.initElements(driver,this);
         
	    }
	    @FindBy(xpath ="//a[contains(@href,'announcements')]")
	    WebElement announcements;
	    @FindBy(xpath = "//a[@class='btn btn-default']")
	    WebElement addannouncements;
	    @FindBy(name="title")
	    WebElement title;    
	    @FindBy(xpath = "//div[@class='note-editable panel-body']")
	    WebElement notes;  
	    @FindBy(xpath ="(//input[@type='text'])[6]")
	    WebElement startdate;
	    @FindBy(xpath ="(//input[@type='text'])[7]")
	    WebElement enddate;
	    @FindBy(xpath ="(//input[@type='checkbox'])[2]")
	    WebElement allTeammembers;
	    @FindBy(xpath ="//button[@class='btn btn-primary pull-right']")	    
	    WebElement saveButton;
	    public void setAnnouncements()
	    {
	    	wait.waitForElementToBeClickable(announcements);
	    	announcements.click();
	    }
	    public void setAddannouncements()
	    {
	    	wait.waitForElementToBeClickable(addannouncements);
	    	addannouncements.click();
	    }
	    public void setTitle(String announcementTitle)
	    {
	    	wait.waitForElementToBeVisible(title);
	    	title.sendKeys(announcementTitle);
	    }	
	    public void setNotes(String announcementNotes)
	    {
	    	wait.waitForElementToBeVisible(notes);
	    	notes.sendKeys(announcementNotes);
	    }	
	    public void setStartdate(String announcementStartdate)
	    {
	    	wait.waitForElementToBeVisible(startdate);
	    	startdate.sendKeys(announcementStartdate);
	    }
	    public void setEnddate(String announcementEnddate)
	    {
	    	wait.waitForElementToBeVisible(enddate);
	    	enddate.sendKeys(announcementEnddate);
	    }	
	    public void saveAnnouncement()
	    {
	    	 	    	       
	    	        element.mouseHoverAndClickonElement(saveButton);
	    	     
	  		}
	    public void clickTeammembers(String announcementTeammember)
	    {
	    	wait.waitForElementToBeClickable(allTeammembers);
	    	allTeammembers.click();
	    	
	    }
	    public boolean checkTitle(String announcementTitle) {
		    wait.waitForElementToBeVisible(title);
		    String actualText = title.getAttribute("value").trim();
		    String expectedText = announcementTitle.trim();
    		return actualText.equalsIgnoreCase(expectedText);
		}
	  /*  public boolean checkAddress(String Address) {
		    wait.waitForElementToBeVisible(alternativeAddress);
		    String actualText = alternativeAddress.getAttribute("value").trim();
		    String expectedText = Address.trim();
    		return actualText.equalsIgnoreCase(expectedText);
		}*/

	  
	    public void createAnnouncements(String announcementTitle,String announcementNotes,String announcementStartdate,String announcementEnddate)
	    {
	    	this.setAnnouncements();
	    	this.setAddannouncements();
	    	this.setTitle(announcementTitle);
	    	this.setNotes(announcementNotes);
	    	this.setStartdate(announcementStartdate);
	    	this.setEnddate(announcementEnddate);
	    	//this.clickTeammembers(announcementTeammember);
	    	this.saveAnnouncement();
	    	
	    	
	    }
		/*public String getTitleOfCreatedAnnouncement() {
			// TODO Auto-generated method stub
			   wait.waitForElementToBeVisible(title);
		        return title.getAttribute("value").trim();
		}*/
	    
}
