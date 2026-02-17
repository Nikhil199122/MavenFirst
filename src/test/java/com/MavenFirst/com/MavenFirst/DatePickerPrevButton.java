package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DatePickerPrevButton 
{
	 static WebDriver driver;
	 static WebDriverWait wait;
	 public static void main(String[] args)  
	{  		
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
				        
		//  Open webpage
		driver.get("https://www.tutorialspoint.com/selenium/practice/date-picker.php");
		System.out.println("Page opened.");
				
		// Create WebDriverWait Object        
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		selectDateTime("1", "10", "30", "PM");

        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!"); 
	}
	
	// ---------------------------------------------------------
	    //               GENERIC METHOD (FINAL)
	    // ---------------------------------------------------------
	    public static void selectDateTime(String dateNumber,
	                                      String hourValue,
	                                      String minuteValue,
	                                      String amPmValue) 
	    {

	        // 1. Open the Date-time picker
	        WebElement dateTimeBox = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//*[@id='datetimepicker1']")));
	        dateTimeBox.click();

	        // 2. Click the date based on number
	        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[contains(@class,'flatpickr-day') and text()='" + dateNumber + "']")));
	        date.click();

	        // 3. Enter hour
	        WebElement hour = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//input[@class='numInput flatpickr-hour']")));
	        hour.clear();
	        hour.sendKeys(hourValue);

	        // 4. Enter minute
	        WebElement minute = wait.until(ExpectedConditions.visibilityOfElementLocated(
	                By.xpath("//input[@class='numInput flatpickr-minute']")));
	        minute.clear();
	        minute.sendKeys(minuteValue);

	        // 5. Select AM / PM
	        WebElement ampm = wait.until(ExpectedConditions.elementToBeClickable(
	                By.xpath("//span[@class='flatpickr-am-pm']")));

	        if (!ampm.getText().equalsIgnoreCase(amPmValue)) 
	        {
	            ampm.click();
	        }

	        System.out.println(
	                "Selected: Date " + dateNumber + ", Time " + hourValue + ":" + minuteValue + " " + amPmValue);
	    }
}
