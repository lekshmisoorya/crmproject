package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import utilities.ElementUtilities;
import utilities.WaitUtilities;

public class Notes {
	WebDriver driver;
	WaitUtilities wait;
	ElementUtilities element;
	JavascriptExecutor js;
	 public Notes(WebDriver driver)
	 {
		  this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
	      js = (JavascriptExecutor) driver;
          PageFactory.initElements(driver,this);
	    }
	 @FindBy(xpath ="//a[contains(@href,'notes')]")
	 WebElement notes;
	 @FindBy(xpath = "//a[@class='btn btn-default']")
	 WebElement addNoteButton;
	 @FindBy(name="title")
	 WebElement title;    
	 @FindBy(id="description")
	 WebElement description;
	 @FindBy(id="s2id_autogen3")
	 WebElement labels;
	 @FindBy(xpath = "//button[@type='submit']")
	 WebElement saveButton;
	 @FindBy(xpath ="//input[@aria-controls='note-table']")
	 WebElement searchnotes;
	 @FindBy(xpath="//a[@class='paginate_button current']")
	 WebElement firstpageoftable;
	@FindBy(xpath="//table[@id='note-table']//tr[1]//td[2]")
	WebElement tabletitle;
		@FindBy(xpath="(//a[@title='Delete note'])[3]")
		WebElement deletenote;
		@FindBy(xpath="//button[@id='confirmDeleteButton']")
		WebElement deletebutton;
		@FindBy(xpath="//div[@class='app-alert-message']")
		WebElement deletedmessagealert;
		 @FindBy(xpath ="(//i[@class='fa fa-pencil'])[1])")
	     WebElement editnotes;
		 @FindBy(xpath="//ul[@class='select2-results']")
		 List<WebElement> labelOptions;
	     public void clickNotes() {
		 wait.waitForElementToBeClickable(notes);
	      notes.click();
	        
	    }

	    public void clickAddNoteButton() {
	    	wait.waitForElementToBeClickable(addNoteButton);
	        addNoteButton.click();
	    }

	    public void setTitle(String noteTitle) {
	    	
	        title.sendKeys(noteTitle);
	    }

	    public void setDescription(String noteDescription) {
	    	wait.waitForElementToBeVisible(description);
	        description.sendKeys(noteDescription);
	    }

	    public void clickSaveButton() {
	    	wait.waitForElementToBeClickable(saveButton);
	        saveButton.click();
	    }
	    public void clickSearchNotes(String noteTitle)
	    {
	    try {
			wait.waitForElementToBeClickable(searchnotes);
			searchnotes.click();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    
	  	   try {
	    	wait.waitForElementToBeVisible(searchnotes);
	    	searchnotes.sendKeys(noteTitle);
	    

	    	
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
	        System.out.println("Scrolled back to the top");
	    }
	     
	      public boolean checkTableTitle(String noteTitle)
	    {
		    
	    	String titleofnotes=element.getElementText(tabletitle);
	    	if(titleofnotes.equalsIgnoreCase(noteTitle))
	    	{
	    		
	    		return true;
	    	}
	    	return false;
	    }
	    public void verifyDeleteNoteIsWorking()
	    {
	    	deletenote.click();
	    	deletebutton.click();
	    }
	    public void clickEditNotes() {
	        editnotes.click();
	    }
	   
	 	 public void notes(String noteTitle, String noteDescription) throws InterruptedException
	 	 {
	 		this.clickNotes();
	 		this.clickAddNoteButton();
	 		this.setTitle(noteTitle);
	 		this.setDescription(noteDescription);
	 		this.clickSaveButton();
	 		this.clickSearchNotes(noteTitle);
	 		this.clickFirstPageOfTable();
	 		this.checkTableTitle(noteTitle);
	 		this.verifyDeleteNoteIsWorking();
	 	  
	 		 
	 	 }
		    
}

		
		
	
			
	
	 	 

