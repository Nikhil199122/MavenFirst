package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JobAppForm 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: // Open webpage
        String url = "https://proleed.academy/exercises/selenium/online-job-application-form.php";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Fill the form using generic methods
        type(By.cssSelector("input#name"), "Nikhil Shahane"); // Name
        clear(By.cssSelector("input#email")); // clear
        type(By.cssSelector("input#email"), "nikhl@gmail.com");    // Email
        type(By.cssSelector("input#phone"), "9876543210");           // Phone
        Thread.sleep(5000);
        
        
        // Select Position dropdown
        click(By.cssSelector("form select[name='position']"));  
        click(By.cssSelector("select[name='position'] option:nth-child(2)"));
        Thread.sleep(5000);
        
        // Radio Button 
        click(By.cssSelector("#selfemployed")); 
        Thread.sleep(5000);
        
        // upload the file 
        uploadFile(By.cssSelector("#resume"), "C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop");
        Thread.sleep(5000);
     
        // Source
        click(By.cssSelector("form div:nth-child(7) select"));
        click(By.cssSelector("form div:nth-child(7) select option:nth-child(2)"));
        Thread.sleep(5000);
        
        // Submit form
        click(By.cssSelector("#add"));
        System.out.println("Form submitted.");
        Thread.sleep(5000);
        
        //Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	
	}
	
	 // ====================== GENERIC METHODS =======================

	// Type text
    public static void type(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }
    
    // Clear
    public static void clear(By locator) 
    {
        driver.findElement(locator).clear();
    }

    // Click
    public static void click(By locator) 
    {
        driver.findElement(locator).click();
    }

    // Upload file
    public static void uploadFile(By locator, String filePath) {
        driver.findElement(locator).sendKeys(filePath);
    }

}
