package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.WaitUtilities;

public class ItemsPage{
	WebDriver driver;
	ElementUtilities element;
	WaitUtilities wait;
	JavascriptExecutor js;
	 public ItemsPage(WebDriver driver)
	 {
	      this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
	      js = (JavascriptExecutor) driver;
         PageFactory.initElements(driver,this);
         
	    }
	    @FindBy(xpath ="//a[contains(@href,'items')]")
	    WebElement items;
	    @FindBy(xpath = "//a[@class='btn btn-default']")
	    WebElement additems;
	    @FindBy(name="title")
	    WebElement title;    
	    @FindBy(id="description")
	    WebElement description;
	    @FindBy(name="unit_type")
	    WebElement unittype; 
	    @FindBy(name="item_rate")
	    WebElement itemrate; 
	    @FindBy(xpath ="//button[@type='submit']")	    
	    WebElement saveButton;
	    @FindBy(xpath ="//input[@aria-controls='item-table']")
		WebElement searchitems;
		@FindBy(xpath="//a[@class='paginate_button current']")
		WebElement firstpageoftable;
	    @FindBy(xpath="//table[@id='item-table']//tr[1]//td[2]")
		WebElement tableDescription;
	    @FindBy(xpath="//table[@id='item-table']//tr[1]//td[1]")
	   
	    WebElement tableTitle;
	    @FindBy(xpath="(//a[@title='Delete'])[2]")
		WebElement deleteitem;
		@FindBy(xpath="//span[@id='item_rate-error']")
	    WebElement rateRequired;
	    public void clickItems()
	    {
	    	System.out.println("Before");
	    	wait.waitForElementToBeClickable(items);
	    		    	items.click();
	   
	    }
	    public void additems()
	    {
	    	wait.waitForElementToBeClickable(additems);
	    	additems.click();
	    }
	    public void setTitle(String itemTitle)
	    {
	    	wait.waitForElementToBeVisible(title);
	    	title.sendKeys(itemTitle);
	    }	
	    public void setDescription(String itemDescription)
	    {
	    	wait.waitForElementToBeVisible(description);
	    	description.sendKeys(itemDescription);
	    }		
	    public void setUnitType(String itemunittype)
	    {
	    	wait.waitForElementToBeVisible(unittype);
	    	unittype.sendKeys(itemunittype);
	    }
	    public void setItemrate(String itemRate)
	    {
	    	wait.waitForElementToBeVisible(itemrate);
	    	itemrate.sendKeys(itemRate);
	    }
	    public void clickSaveButton() {
	    	wait.waitForElementToBeClickable(saveButton);
	    	saveButton.click();
	    }
	    public void clickSearchNotes(String itemDescription)
	    {
	    try {
			wait.waitForElementToBeClickable(searchitems);
			searchitems.click();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    
	  	   try {
	    	wait.waitForElementToBeVisible(searchitems);
	    	searchitems.sendKeys(itemDescription);
	    

	    	
	    }  catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	   public void clickFirstPageOfTable() throws InterruptedException
	    {   
	       
	    	element.scrollToElement(firstpageoftable);
	    	wait.waitForElementToBeClickable(firstpageoftable);
	        firstpageoftable.click();
	        Thread.sleep(1000);
	        element.scrollBack();
	       
	    }
	           	
	      public boolean checkTableDescription()
	    {
	    	  wait.fluentWait(tableDescription);
	            return element.isElementDisplayed(tableDescription);
	    	
	    	
	    }
	      public boolean checkTableTitle()
		    {
	    	
	    	  wait.fluentWait(tableTitle);
		    	return element.isElementDisplayed(tableTitle);
		    	
		    }
	    public void verifyDeleteItem()
	    {
	    	deleteitem.click();
	    	
	    }
	    public boolean requiredField() 
	     {
	    	wait.waitForElementToBeVisible(rateRequired);
            return element.isElementDisplayed(rateRequired);
	     } 

	    public void addNewItem(String itemTitle, String itemDescription,String itemunittype,String itemRate) throws InterruptedException
	 	 {
	 		 this.clickItems();
	 		 this.additems();
	 		 this.setTitle(itemTitle);
	 		 this.setDescription(itemDescription);
	 		 this.setUnitType(itemunittype);
	 		 this.setItemrate(itemRate);
	 		
	 		this.clickSaveButton();
	 		this.clickSearchNotes(itemDescription);
	 		this.clickFirstPageOfTable();
	 		this.checkTableDescription();
	 		this.verifyDeleteItem();
		 	  
	 		 
	 	 }
		
	    
}
