package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {
	private WebDriver driver;
    JavascriptExecutor js;
    WebDriverWait wait;
	
    // Constructor to initialize the WebDriver
    public ElementUtilities(WebDriver driver) {
    	js=(JavascriptExecutor) driver;
        this.driver = driver;
    }



 

    // Method to enter text into a text field
    public  void enterText(WebElement element,String text){
        element.sendKeys(text);
    }

   // Method to get the text of a WebElement
       public String getElementText(WebElement element) {
	        String text = element.getText();
	        return text;
	    }


    // Method to check if a WebElement is displayed
    public boolean isElementDisplayed(WebElement element) 
    {
        return element.isDisplayed();
    }
    //method to check element is enabled
    public boolean isElementEnabled(WebElement element) {
        return element.isEnabled();
    }
    
    //click
    public  void clickOnElement(WebElement element){
        element.click();
    }
    public void radioButtonClick(List<WebElement> radiobuttons, String radioText) 
    {
					for(int i=0;i<radiobuttons.size();i++)
					{
						if(radiobuttons.get(i).getText().equals(radioText))
							js.executeScript("arguments[0].click();",radiobuttons.get(i));
						
					}
					
				}
    
    //dropdown with select tag
    public String selectDropdown(WebElement element,String value) {
    	
    	Select drpobject = new Select(element);
    	drpobject.selectByVisibleText("value");
		return value;
    }
    //vertical scroll to a particular element
    public Object scrollToElement(WebElement element) 
    {
    	
    	return js.executeScript("arguments[0].scrollIntoView();", (element));
    }
    public Object scrollToBottom(WebElement element) {
    	
    	return js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }
    //scrollback to the top of the page
    public Object scrollBack()
    {
    	return js.executeScript("window.scrollTo(0, 0)");
    }
    
   //dropdown without select


	/*public void dropDownWithoutSelect(List<WebElement> element,String value) {
		for(WebElement w:element)
	    {
	    	
			System.out.println(w.getText());
    		System.out.println("value is"+value);
	    	
	    	if (w.getText().equals(value))
	    	{
	    		
	         w.click();
	    	}
	    }
		
	}*/
    
    
    public void dropDownWithoutSelect(List<WebElement> elements, String value) {
        if (elements == null || value == null) {
            throw new IllegalArgumentException("Input parameters cannot be null");
        }

        for (WebElement element : elements) {
            System.out.println(element.getText());
            System.out.println("value is " + value);

            if (element.getText().trim().equalsIgnoreCase(value.trim())) {
            	 js.executeScript("arguments[0].scrollIntoView();", (element));
                //element.click();
                break; // Assuming you want to exit the loop after finding a match
            }
        }
    }
		//File upload using robot class

			public void FileUploadUsingRobotClass(WebDriver driver, String path) throws AWTException, InterruptedException
			{
			   StringSelection s = new StringSelection(path);
			   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
			   Robot r = new Robot();
			   Thread.sleep(5000);
			   r.keyPress(KeyEvent.VK_ENTER);
			   r.keyRelease(KeyEvent.VK_ENTER);
			   Thread.sleep(5000);
			   r.keyPress(KeyEvent.VK_CONTROL);
			   r.keyPress(KeyEvent.VK_V);
			   Thread.sleep(5000);
			   r.keyRelease(KeyEvent.VK_CONTROL);
			   r.keyRelease(KeyEvent.VK_V);
			   Thread.sleep(5000);
			   r.keyPress(KeyEvent.VK_ENTER);
			   r.keyRelease(KeyEvent.VK_ENTER);
			}
			public void sendKeysUsingJavaScript(WebElement element,String text)
		    
		    {
		    	
		    	js.executeScript("arguments[0].value = arguments[1];", element, text);
		    }
		    public void pressEnter(WebElement element)
		    {
		    	element.sendKeys(Keys.ENTER);
		    }
		    public void pressDownArrow(WebElement element)
		    {
		    	element.sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN);
		    }
		    
         //gettitle
			public String getPageTitle(WebDriver driver){
		        String title=driver.getTitle();
		        return title;
		    }
			public void checkBox(List<WebElement> checkboxes, String checkboxText) 
		     {
							for(int i=0;i<checkboxes.size();i++)
							{
								if(checkboxes.get(i).getText().equals(checkboxText))
									js.executeScript("arguments[0].click();",checkboxes.get(i));
								
							}
							
						}
		   //alert accept
		public void simpleAlert(WebDriver driver){
		        Alert alert = driver.switchTo().alert();
		        alert.accept();
		    }
		//allert dismiss
		    public void confirmationAlert(WebDriver driver){
		        Alert alert = driver.switchTo().alert();
		        alert.dismiss();
		    }
		    //prompt alert
		    public void promptAlert(WebDriver driver, String text) {
		        Alert alert = driver.switchTo().alert();
		        alert.sendKeys(text);
		        alert.accept();
		    }
		    //javascript executer
		    public void promptAlert(WebElement element) {

		    JavascriptExecutor js=(JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();",element );  
		    }
		    
	      
		 //take screenshot
		    public void fullPageScreenshot() throws IOException {
		    	TakesScreenshot ts=(TakesScreenshot) driver;
		        File src=ts.getScreenshotAs(OutputType.FILE);
		        File targ=new File("C:\\Users\\user\\eclipse-workspace\\crmproject\\screenshot\\fullpage.png");
		        FileUtils.copyFile(src, targ);
		    }
		    
		    public void mouseHoverAndClickonElement(WebElement element){
		        Actions action=new Actions(driver);
		        action.moveToElement(element).click().build().perform();
		    }
		    public void enterDate(WebElement element,String day, String month, String year) {
		    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        element.click();      
		        System.out.println(day+"-"+ month+"-"+ year);
		        List<WebElement> allDates = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
		                By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td")));
		        
		        for (WebElement date : allDates) {
		            if (date.getText().equals(day)) {
		                wait.until(ExpectedConditions.elementToBeClickable(date)).click();
		                break;
		            }
		        }
		    }
		   
		
	}

