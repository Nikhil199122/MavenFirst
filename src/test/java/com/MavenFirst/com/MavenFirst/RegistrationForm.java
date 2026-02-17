package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class RegistrationForm 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open webpage
        String url = "https://proleed.academy/exercises/selenium/automate-the-signup-form-using-selenium-webdriver.php";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        System.out.println("Filling form...");
        
        // First Name
        clear(By.cssSelector("input[name='firstname']"));
        type(By.cssSelector("input[name='firstname']"), "Nikhil");
        Thread.sleep(5000);
        
        // Last Name
        clear(By.cssSelector("input[name='lastname']"));
        type(By.cssSelector("input[name='lastname']"), "Shahane");
        Thread.sleep(5000);
        
        // Gender
        click(By.cssSelector("input#male"));
        Thread.sleep(5000);
        
        // Years of Experience (Added)
        click(By.cssSelector("select[name='experience']"));  // open dropdown
        click(By.cssSelector("select[name='experience'] option:nth-child(2)")); // 1 Year
        Thread.sleep(5000);
        
        // Date
        clear(By.cssSelector("input#date"));
        type(By.cssSelector("input#date"), "10-02-2025");
        Thread.sleep(5000);
        
        // Profession (Radio)
        click(By.cssSelector("input#automation"));
        Thread.sleep(5000);

        // Skills (Checkbox)
        click(By.cssSelector("input#selenium"));
        click(By.cssSelector("input#java"));
        click(By.cssSelector("input#postman"));
        Thread.sleep(5000);

        // Country Dropdown
        click(By.cssSelector("select[name='country']"));
        click(By.cssSelector("select[name='country'] option:nth-child(102)"));
        Thread.sleep(5000);

        // Profile Picture Upload
        uploadFile(By.cssSelector("input[type='file']"), "C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop");
        Thread.sleep(5000);

        // Submit Button
        click(By.cssSelector("input#add"));
        System.out.println("Form submitted.");
        Thread.sleep(5000);
        
        //Close browser
        driver.quit();
        System.out.println("Test completed successfully!");

	}
	
	public static void type(By locator, String value) 
	{
        driver.findElement(locator).sendKeys(value);
        System.out.println("Typed: " + value);
    }

    public static void clear(By locator) 
    {
        driver.findElement(locator).clear();
    }

    public static void click(By locator) 
    {
        driver.findElement(locator).click();
        System.out.println("Clicked: " + locator);
    }

    public static void uploadFile(By locator, String path) 
    {
        driver.findElement(locator).sendKeys(path);
        System.out.println("Uploaded: " + path);
    }

}
