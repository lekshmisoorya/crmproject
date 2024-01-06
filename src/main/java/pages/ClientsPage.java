package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.FakerUtility;
import utilities.WaitUtilities;

public class ClientsPage {
	WebDriver driver;
	WaitUtilities wait;
	ElementUtilities element;
	JavascriptExecutor js;
	 public ClientsPage(WebDriver driver)
	 {
		  this.driver = driver;
	      wait=new WaitUtilities(driver);
	      element=new ElementUtilities(driver);
          PageFactory.initElements(driver,this);
	    }
	 @FindBy(xpath ="//a[contains(@href,'clients')]")
	 WebElement clients;
	 @FindBy(xpath = "//a[@title='Add client']")
	 WebElement addclient;
	 @FindBy(name="company_name")
	 WebElement companyname;    
	 @FindBy(id="address")
	 WebElement address;
	 @FindBy(name="city")
	 WebElement city;
	 @FindBy(name="state")
	 WebElement state;
	 @FindBy(name="zip")
	 WebElement zip;
	 @FindBy(name="country")
	 WebElement country;
	 @FindBy(name="phone")
	 WebElement  phone;
	 @FindBy(name="website")
	 WebElement  website;
	 @FindBy(name="vat_number")
	 WebElement vat_number;
     @FindBy(xpath ="//button[@type='submit']")
	 WebElement savebutton;
	 @FindBy(xpath ="//input[@aria-controls='client-table']")
		WebElement searchclients;
		@FindBy(xpath="//a[@class='paginate_button current']")
		WebElement firstpageoftable;
	    @FindBy(xpath="//table[@id='client-table']//tr[1]//td[2]")
		WebElement tableCompanyName;
	    @FindBy(xpath="(//a[@title='Delete client'][1]")
		WebElement deleteClient;
	   @FindBy(xpath="//a[@class='dt-button buttons-print']")
	    WebElement printClient;
	   @FindBy(xpath="//table[@class='display dataTable no-footer']//td[1]")
	   WebElement printID;
	   @FindBy(xpath="//span[@id='company_name-error']")
	   WebElement companynameRequired;
	   @FindBy(xpath="//table[@class='display dataTable no-footer']//tr[1]//td[2]")
	   WebElement companyNameTable;
	
	    public void clickclients() {
		 wait.waitForElementToBeClickable(clients);
		 clients.click();
	        
	    }

	    public void clickAddclientButton() {
	    	wait.waitForElementToBeClickable(addclient);
	    	addclient.click();
	    }
       public void setCompanyName(String clientCompanyName) {
	    	
    	   companyname.sendKeys(clientCompanyName);
	    }

	    public void setAddress(String clientAddress) 
	    {
	    	wait.waitForElementToBeVisible(address);
	    	address.sendKeys(clientAddress); 
       }
	    public void setCity(String clientCity) 
	    {
	    	wait.waitForElementToBeVisible(city);
	    	city.sendKeys(clientCity); 
        }
	    public void setState(String clientState) 
	    {
	    	wait.waitForElementToBeVisible(state);
	    	state.sendKeys(clientState); 
         }
	    public void setZip(String clientZip) 
	    {
	    	wait.waitForElementToBeVisible(zip);
	    	zip.sendKeys(clientZip); 
         }
	    public void setCountry(String clientCountry) 
	    {
	    	wait.waitForElementToBeVisible(country);
	    	country.sendKeys(clientCountry); 
         }
	    public void setPhone(String clientPhone) 
	    {
	    	wait.waitForElementToBeVisible(phone);
	    	phone.sendKeys(clientPhone); 
         }
	    public void setWebsite(String clientWebsite) 
	    {
	    	wait.waitForElementToBeVisible(website);
	    	website.sendKeys(clientWebsite); 
         }
	    
	    public void setVatNumber(String clientVatNumber) 
	    {
	    	wait.waitForElementToBeVisible(vat_number);
	    	vat_number.sendKeys(clientVatNumber); 
         }
	   
	    public void clickSaveButton() {
	    	wait.waitForElementToBeClickable(savebutton);
	    	savebutton.click();
	    }
	    public void clickSearchItems(String clientCompanyName)
	    {
	    try {
			wait.waitForElementToBeClickable(searchclients);
			searchclients.click();
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    
	  	   try {
	    	wait.waitForElementToBeVisible(searchclients);
	    	searchclients.sendKeys(clientCompanyName);
	    

	    	
	    }  catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	 
	   public void setPrintClients()
	    {
	    	wait.waitForElementToBeClickable(printClient);
	    	
	    	printClient.click();
	    		    }
	   public boolean setPrintID()
	   {
		   element.scrollToElement(printID);
	    	wait.waitForElementToBeClickable(printID);
	    	printID.click();
			return true;
	   }
	   public boolean checkCompanyName()
	   {
		   wait.waitForElementToBeVisible(companyNameTable);
  			
  			return(element.isElementDisplayed(companyNameTable));
	   }
	   
	   public String requiredField() 
	     {
	     return companynameRequired.getText();
	     } 
	   public boolean checkAddress(String clientAddress) {
		    wait.waitForElementToBeVisible(address);
		    String actualText = address.getAttribute("value").trim();
		    String expectedText = clientAddress.trim();
   		return actualText.equalsIgnoreCase(expectedText);
		}
	    public void addClient(String clientCompanyName,String clientAddress,String clientCity,String clientState,String clientZip,String clientCountry,String clientPhone,String clientWebsite,String clientVatNumber) throws InterruptedException
	    {
	    	this.clickclients();
	    	this.clickAddclientButton();
	    	this.setCompanyName(clientCompanyName);
	    	this.setAddress(clientAddress);
	    	this.setCity(clientCity);
	    	this.setState(clientState);
	    	this.setZip(clientZip);
	    	this.setCountry(clientCountry);
	    	this.setPhone(FakerUtility.phoneNumber());
	    	this.setWebsite(clientWebsite);
	    	this.setVatNumber(clientVatNumber);
	    	
	    	this.clickSaveButton();
	    	this.clickSearchItems(clientCompanyName);
	    	this.setPrintClients();
	    	this.setPrintID();
	    	
	 	
	    }
}  
	    


	    
