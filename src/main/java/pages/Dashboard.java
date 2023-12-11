package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	    @FindBy(xpath="//textarea[@name='note']")
	     WebElement stickynotes;
	  
	    public boolean isLoginCheckToDashboardDisplayed() {
	        return loginchecktodashboard.isDisplayed();
	    }
	    public boolean verifyStickyNoteAdded(String expectedNote) {
	        wait.waitForElementToBeVisible(stickynotes);
	        String actualNote = stickynotes.getAttribute("value");
	        return actualNote.equals(expectedNote);
	    }

	    public void setStickyNoteText(String notesticky) {
	        wait.waitForElementToBeVisible(stickynotes);
	        stickynotes.clear();
	        stickynotes.sendKeys(notesticky);
	        element.scrollToElement(stickynotes);
	    }

	    public void addDashboardNoteAndVerify(String notesticky) {
	        setStickyNoteText(notesticky);
	    }
	/* public void setStickynote(String notesticky) {
		    	wait.waitForElementToBeVisible(stickynotes);
		    	stickynotes.sendKeys(notesticky);
		    }
public void addDashboardnote(String notesticky) {
	this.setStickynote(notesticky);
}*/
}
