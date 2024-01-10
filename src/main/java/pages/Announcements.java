package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
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
	    @FindBy(xpath="//input[@type='checkbox']")
		List<WebElement> checkboxes;
	    @FindBy(xpath="(//span[@class='help-block'])[1]")
	    WebElement titleRequired;
	    @FindBy(xpath ="//a[contains(@href,'announcements')]")
	    WebElement announcements1;
	    @FindBy(xpath="//a[@class='paginate_button current']")
	    WebElement Pagination;
	    @FindBy(xpath="//input[@type='search']")
	    WebElement search;
	    @FindBy(xpath="(//a[contains(@href,'announcements')])[2]")
	    WebElement viewbutton;
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
	    
	    	public void setCheckBoxClick(String checkboxText)
	    	{
	    		element.checkBox(checkboxes,checkboxText);
	    		element.scrollToElement(saveButton);
	    	}
	    	public void setAnnouncements1() {
	    	   element.promptAlert(announcements1);
	    	}
	    	public void clickViewButton()
	    	{
	    		wait.waitForElementToBeVisible(viewbutton);
	    		wait.waitForElementToBeClickable(viewbutton);
	    		viewbutton.click();
	    	}
	    	
	    	   	      
	  	    	   public boolean checkTitle() {
	    		 
	  	    		 return title.getText() != null;
		}
	    	  
        	
	    	     	    
	    	   public boolean requiredField() 
			     {
			     return titleRequired.getText() != null;
			     } 
	    	    
		
	   
}
