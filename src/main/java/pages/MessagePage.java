package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

import utilities.ElementUtilities;
import utilities.WaitUtilities;
public class MessagePage{
	private static final String String = null;
	WebDriver driver;
	WaitUtilities wait;
	ElementUtilities element;
	JavascriptExecutor js;
	 public MessagePage(WebDriver driver)
	 {
		
		 this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
        PageFactory.initElements(driver,this);
	    }
	 @FindBy(xpath ="(//a[contains(@href,'messages')])[2]")
	 WebElement messages;
	 @FindBy(xpath = "//a[@title='Send message']")
	 WebElement compose;
	 @FindBy(xpath ="(//div[contains(@class, 'select2')])[4]")
	 WebElement toAddress; 
	 @FindBy(xpath ="(//input[@type='text'])[5]")
	 WebElement subject;
	 @FindBy(xpath ="//textarea[@name='message']")
	 WebElement textarea;
	 @FindBy(xpath ="//button[@type='submit']")
	 WebElement sentButton;
	 @FindBy(xpath = "//input[@id='s2id_autogen3_search']")
	 WebElement dropdownsearch;
	 @FindBy(xpath = "//div[@class='app-alert-message']")
	 WebElement messagealert;
	 @FindBy(xpath = "//span[@id='subject-error']")
	 WebElement subjectRequired;

	 public void clickMessages() {
	        wait.waitForElementToBeClickable(messages);
	        messages.click();
	    }

	    public void clickCompose() {
	        wait.waitForElementToBeClickable(compose);
	        compose.click();
	    }
	    
	    public void enterRecipient(String address)
	    {
	      wait.waitForElementToBeVisible(toAddress);
	      wait.waitForElementToBeClickable(toAddress);
	  	  element.mouseHoverAndClickonElement(toAddress);
	  	  element.sendKeysUsingJavaScript(dropdownsearch,address);
	  	  element.pressDownArrow(dropdownsearch);
	  	  element.pressEnter(dropdownsearch);
	  	  
	    	    	
	    }
	    	   	        		    
	    public void enterSubject(String messageSubject) 
	    {
	        wait.waitForElementToBeVisible(subject);
	        subject.sendKeys(messageSubject);
	    }

	    public void enterMessageText(String message) {
	        wait.waitForElementToBeVisible(textarea);
	        textarea.sendKeys(message);
	    }

	    public void clickSend() {
	        wait.waitForElementToBeClickable(sentButton);
	        sentButton.click();
	    }
	    public boolean checkMessageGone() throws TimeoutException 
		{
		    wait.waitForElementToBeVisible(messagealert);
			
			return(element.isElementDisplayed(messagealert));
			
		}
	    public boolean requiredField() 
	     {
	     return subjectRequired.getText() != null;
	     } 
	   
 	 }
