package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ElementUtilities;
import utilities.WaitUtilities;

public class LoginPage {
	
		  WebDriver driver;
		  WaitUtilities wait;
		  public LoginPage(WebDriver driver)
		 {
		      this.driver = driver;
		      wait=new WaitUtilities(driver);
	          PageFactory.initElements(driver,this);
		    }
		    @FindBy(name="email")
		    WebElement email;
		    @FindBy(name="password")
		    WebElement password;    
		   	@FindBy(xpath ="//button[text()='Sign in']")
		    WebElement signin;
		   	@FindBy (xpath="//span[text()='Dashboard']")
		   	WebElement homePageTitle ;
		   	@FindBy (xpath="//span[text()='Authentication failed!']")
		   	WebElement authenticationfailed ;
		    @FindBy(id="password-error")
		    WebElement passwordrequired;
		    public void setEmail(String stremail)
		    {
		    	email.sendKeys(stremail);
		    	email.click();
		    }
		    public void setPassword(String strpassword)
		    {
		    	password.sendKeys(strpassword);
		    }
		    public void signin()
		    {
		    	signin.click();
		    	System.out.println("sign in ");
		    }
		         public void loginPage(String stremail,String strpassword)
			 {
				    //System.out.println("Username: " + stremail);
				    //System.out.println("Password: " + strpassword);
			        this.setEmail(stremail);
			        wait.waitForElementToBeVisible(password);
			        this.setPassword(strpassword);
			       // System.out.println("password field set.");
			        this.signin();  
			     //   System.out.println("login field set.");
			  }
		     public String getAuthenticationFailed() 
		     {
		     return authenticationfailed.getText();
	         } 
		     public String requiredField() 
		     {
		     return passwordrequired.getText();
		     } 
	}
