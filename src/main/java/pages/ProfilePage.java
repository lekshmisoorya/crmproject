package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.FakerUtility;
import utilities.WaitUtilities;

public class ProfilePage {
	WebDriver driver;
	ElementUtilities element;
	WaitUtilities wait;
	 public ProfilePage(WebDriver driver)
	 {
	      this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
          PageFactory.initElements(driver,this);
	    }
	    @FindBy(id="user-dropdown-icon")
		WebElement icon;
		@FindBy(xpath="//i[@class='fa fa-user mr10']")
		WebElement myprofile;
		@FindBy(id="first_name") 
		WebElement firstName;
		@FindBy(id="last_name")
		WebElement lastName;
		@FindBy(id="address")
		WebElement emailAddress;
		@FindBy(id="alternative_address")
		WebElement alternativeAddress;
		@FindBy(id="phone")
		WebElement phone;
		@FindBy(id="skype")
		WebElement skype;
		@FindBy(id="ssn")
		WebElement ssn;
       @FindBy(id="gender_male")
       WebElement male;
		@FindBy(id="gender_female")
		WebElement female;
		@FindBy(xpath="//button[@type='submit']")
		WebElement save;
		@FindBy(id="dob")
		WebElement datefield;
		@FindBy(xpath="//th[@class='datepicker-switch'][1]")
		WebElement datemonth;
		@FindBy(xpath="//span[@id='first_name-error']")
		WebElement requiredfield;
		public void clickProfile()
		{
		 wait.waitForElementToBeClickable(icon);
	    icon.click();	
			
		}	
		public void clickMyProfile()
		{

			wait.waitForElementToBeClickable(myprofile);
			myprofile.click();	
		}	


		public void setFirstName(String profilefirstname)
		{
			wait.waitForElementToBeClickable(firstName);
			firstName.clear();
			firstName.sendKeys(profilefirstname);
		
		}	
		public void setLastName(String profilelastname)
		{
			wait.waitForElementToBeClickable(lastName);
			lastName.clear();
			lastName.sendKeys(profilelastname);
			}	
		
		public void setEmail(String email)
		{
			wait.waitForElementToBeClickable(emailAddress);
			emailAddress.clear();
			emailAddress.sendKeys(email);
			element.scrollToElement(emailAddress);
			
		}
		public void setAlternativeAddress(String Address)
		{
			wait.waitForElementToBeClickable(alternativeAddress);
			alternativeAddress.clear();
			alternativeAddress.sendKeys(Address);
			element.scrollToElement(alternativeAddress);
					
		}
		
		public void setPhone(String phoneNumber)
		{
			wait.waitForElementToBeClickable(phone);
			phone.clear();
			phone.sendKeys(phoneNumber);
			element.scrollToElement(phone);
			}	
		public void setSkype(String skypeData)
		{
			wait.waitForElementToBeClickable(skype);
			skype.clear();
			skype.sendKeys(skypeData);
			element.scrollToElement(skype);
			}	
		public void setSSN(String ssnNum)
		{
			wait.waitForElementToBeClickable(ssn);
			ssn.clear();
			ssn.sendKeys(ssnNum);
			element.scrollToElement(ssn);
			}	
		public void setGender(String gender)
		{
			
			if (gender=="female")
			{
			wait.waitForElementToBeClickable(female);
			female.click();
		
			}
			else
			{
				wait.waitForElementToBeClickable(male);
				male.click();
			}
		}
		public void saveProfile()
		{
			wait.waitForElementToBeClickable(save);
			save.click();
			
		}
		public boolean checkAddress(String Address) {
		    wait.waitForElementToBeVisible(alternativeAddress);
		    String actualText = alternativeAddress.getAttribute("value").trim();
		    String expectedText = Address.trim();
    		return actualText.equalsIgnoreCase(expectedText);
		}
		public boolean checkfirstName(String profilefirstname) {
		    wait.waitForElementToBeVisible(firstName);
		    String actualText = firstName.getAttribute("value").trim();
		    String expectedText = profilefirstname.trim();
    		return actualText.equalsIgnoreCase(expectedText);
		}
		 public boolean nameRequiredField() 
	     {
	    	wait.waitForElementToBeVisible(requiredfield);
            return element.isElementDisplayed(requiredfield);
	     } 
	    
		public boolean validateFirstname () {
			
	        return firstName.getText() != null;
	    }
		
}
		
		
