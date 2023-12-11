package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.WaitUtilities;

public class EventsPage {
	WebDriver driver;
	ElementUtilities element;
	WaitUtilities wait;
	 public EventsPage(WebDriver driver)
	 {
	      this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
         PageFactory.initElements(driver,this);
	    }
	    @FindBy(xpath = "//a[contains(@href,'events')]")
	    WebElement events;
	    @FindBy(xpath = "//a[@class='btn btn-default']")
	    WebElement addevent;
	    @FindBy(name="title")
	    WebElement title;    
	    @FindBy(id="description")
	    WebElement description;
	    @FindBy(id="location")
	    WebElement location;  
	    @FindBy(xpath ="(//input[@type='text'])[2]")
		WebElement startdate;
	    @FindBy(name="start_time")
	    WebElement starttime;
	    @FindBy(xpath ="(//input[@type='text'])[4]")
		WebElement enddate;
	    @FindBy(name="end_time")
	    WebElement endtime;
	    @FindBy(xpath = "//li[@class='select2-search-field']")
	    WebElement labels;
	    @FindBy(xpath = "//span[@id='select2-chosen-5']")
	    WebElement client;
	    @FindBy(xpath ="//input[@id='only_me']")
	    WebElement radiobuttononlyme;
	    @FindBy(xpath ="//button[@type='submit']")
	    WebElement savebutton;
	    @FindBy(xpath="//td[@class='active day']")
	    WebElement day;
	    @FindBy(xpath="//span[@class='month focused active']")
	    WebElement month;
	    @FindBy(xpath="//span[@class='year active focused']")
	    WebElement year;
	    public void events()
	    {
	    	wait.waitForElementToBeClickable(events);
	    	events.click();
	    }
	    public void addevent()
	    {
	    	wait.waitForElementToBeClickable(addevent);
	    	addevent.click();
	    }
	    public void setTitle(String eventsTitle)
	    {
	    	wait.waitForElementToBeVisible(title);
	    	title.sendKeys(eventsTitle);
	    }	
	    public void setDescription(String eventsDescription)
	    {
	    	wait.waitForElementToBeVisible(description);
	    	description.sendKeys(eventsDescription);
	    }	
	    public void setStartdate(String eventsStartdate)
	    {
	    	wait.waitForElementToBeVisible(startdate);
	    	startdate.sendKeys(eventsStartdate);
	    }
	    public void setEnddate(String eventsEnddate)
	    {
	    	wait.waitForElementToBeVisible(enddate);
	    	enddate.sendKeys(eventsEnddate);
	    }	
	    public void setLocation(String eventsLocation)
	    {
	    	wait.waitForElementToBeVisible(location);
	    	location.sendKeys(eventsLocation);
	    }	
	    
	    public void clickSaveButton() {
	    	wait.waitForElementToBeClickable(savebutton);
	    	savebutton.click();
	    	System.out.println("save");
	    }
	    public void strdate(String day, String month, String year) {
        	startdate.click();
        	element.enterDate(startdate, day, month, year);
        }
	    public boolean checkDescription(String eventsDescription) {
		    wait.waitForElementToBeVisible(description);
		    String actualText = description.getAttribute("value").trim();
		    String expectedText = eventsDescription.trim();
    		return actualText.equalsIgnoreCase(expectedText);
		}
	    public void addingEvents(String eventsTitle,String eventsDescription,String eventsStartdate,String eventsEnddate,String eventsLocation)
	    		{
	    	this.events();
	    	this.addevent();
	    	this.setTitle(eventsTitle);
	    	this.setDescription(eventsDescription);
	    	this.setStartdate(eventsStartdate);
	    	this.setEnddate(eventsEnddate);
	    	this.setLocation(eventsLocation);
	    	this.clickSaveButton();
	    	
	    }
	    
}
