package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.WaitUtilities;

public class Timecards {
	private static final String String = null;
	WebDriver driver;
	WaitUtilities wait;
	ElementUtilities element;
	JavascriptExecutor js;
	 public Timecards(WebDriver driver)
	 {
		
		 this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
        PageFactory.initElements(driver,this);
	    }
	 @FindBy(xpath ="//a[contains(@href,'attendance')]") 
	 WebElement attendance;
	 @FindBy(xpath="//a[@title='Add time manually']") 
	 WebElement addtime; 
	 @FindBy(xpath="(//div[contains(@class, 'select2')])[7]")  
     WebElement teammember; 
	 @FindBy(name="in_date")
	 WebElement indate;
	 @FindBy(name="in_time")
	 WebElement intime; 
	 @FindBy(name="out_date")
	 WebElement outdate;
	 @FindBy(name="out_time")
	 WebElement outtime;
	 @FindBy(name="note")
	 WebElement note;
	 @FindBy(xpath="//input[@id='s2id_autogen5_search']")	 
	 WebElement teammemberslist;
	 @FindBy(xpath ="//button[@class='btn btn-primary']")	    
	 WebElement saveButton;
	 @FindBy(xpath="//input[@type='search']")
	  WebElement search;
	 @FindBy(xpath="//span[@id='attendance_user_id-error']")
	 WebElement teammemberrequired;
	 public void clickTimeCards()
		{
		 wait.waitForElementToBeClickable(attendance);
		 attendance.click();	
				
		}	
		public void clickAddtime()
		{

			wait.waitForElementToBeClickable(addtime);
			addtime.click();	
		}	

		public void setTeammember(String timeTeammembers)
		{
			
			  wait.waitForElementToBeVisible(teammember);
		      wait.waitForElementToBeClickable(teammember);
		  	  element.mouseHoverAndClickonElement(teammember);
		  	  element.sendKeysUsingJavaScript(teammemberslist,timeTeammembers);
			  element.pressDownArrow(teammemberslist);
		  	  element.pressEnter(teammemberslist);
		}	
		 public void setIndate(String timeIndates)
		    {
		    	wait.waitForElementToBeVisible(indate);
		    	indate.sendKeys(timeIndates);
		    }
		    public void setInTime(String timeIntimes)
		    {
		    	wait.waitForElementToBeVisible(intime);
		    	intime.sendKeys(timeIntimes);
		    }	
		
		    public void setOutdate(String timeOutdates)
		    {
		    	wait.waitForElementToBeVisible(outdate);
		    	outdate.sendKeys(timeOutdates);
		    }
		    public void setOutTime(String timeOuttimes)
		    {
		    	wait.waitForElementToBeVisible(outtime);
		    	outtime.sendKeys(timeOuttimes);
		    }	
							
				
				 public void setNotes(String timeNotes)
		    {
		    	wait.waitForElementToBeVisible(note);
		    	note.sendKeys(timeNotes);
		    }	
		
				 public boolean checkRequiredteammember() {
						wait.waitForElementToBeVisible(teammemberrequired);
			            return element.isElementDisplayed(teammemberrequired);
					}
			
				public void saveTime()
				    {
				    	 	    	       
				   element.mouseHoverAndClickonElement(saveButton);
				    	     
				  		}
		 public void addTimeCards(String timeTeammembers,String timeIndates,String timeIntimes,String timeOutdates,String timeOuttimes,String timeNotes)
		    {
			    this.clickTimeCards();
			    this.clickAddtime();
		    	this.setTeammember(timeTeammembers);
		    	this.setIndate(timeIndates);
		    	this.setInTime(timeIntimes);
		    	this.setOutdate(timeOutdates);
		    	this.setOutTime(timeOuttimes);
		    	this.setNotes(timeNotes);
		    	this.saveTime();
		    
		    	
		    }
		
						
		}
