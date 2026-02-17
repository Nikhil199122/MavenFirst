package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class HotelReservationForm 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open webpage
        String url = "https://proleed.academy/exercises/selenium/hotel-reservation-form-for-practice.php";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        System.out.println("Filling form...");
        
        // FIRST NAME
        clear(By.cssSelector("input[name='firstname']"));
        type(By.cssSelector("input[name='firstname']"), "Nikhil");
        Thread.sleep(5000);
        
        // LAST NAME
        clear(By.cssSelector("input[name='lastname']"));
        type(By.cssSelector("input[name='lastname']"), "Shahane");
        Thread.sleep(5000);
        
        // ADDRESS 1
        clear(By.cssSelector("input[name='address1']"));
        type(By.cssSelector("input[name='address1']"), "Pune, Maharashtra");
        Thread.sleep(5000);

        // ADDRESS 2
        clear(By.cssSelector("input[name='address2']"));
        type(By.cssSelector("input[name='address2']"), "Near City Center");
        Thread.sleep(5000);

        // CITY
        clear(By.cssSelector("input#city"));
        type(By.cssSelector("input#city"), "Pune");
        Thread.sleep(5000);

        // STATE
        clear(By.cssSelector("input#state"));
        type(By.cssSelector("input#state"), "Maharashtra");
        Thread.sleep(5000);

        // ZIP CODE
        clear(By.cssSelector("input#zipcode"));
        type(By.cssSelector("input#zipcode"), "411014");
        Thread.sleep(5000);
        
        // PHONE
        clear(By.cssSelector("input#phone"));
        type(By.cssSelector("input#phone"), "9876543210");
        Thread.sleep(5000);
        
        // EMAIL
        clear(By.cssSelector("input#email"));
        type(By.cssSelector("input#email"), "nikhil@gmail.com");
        Thread.sleep(5000);
        
        // CHECK-IN DATE
        clear(By.cssSelector("input#checkindate"));
        type(By.cssSelector("input#checkindate"), "20-02-2025");
        Thread.sleep(5000);
        
        // CHECK-IN TIME
        clear(By.cssSelector("input#checkintime"));
        type(By.cssSelector("input#checkintime"), "11:00");
        Thread.sleep(5000);
        
        // CHECK-OUT DATE
        clear(By.cssSelector("input#checkoutdate"));
        type(By.cssSelector("input#checkoutdate"), "25-02-2025");
        Thread.sleep(5000);

        // CHECK-OUT TIME
        clear(By.cssSelector("input#checkouttime"));
        type(By.cssSelector("input#checkouttime"), "09:00");
        Thread.sleep(5000);
        
        // ROOM PREFERENCE (Radio)
        click(By.cssSelector("input#standard"));   // Standard room;
        Thread.sleep(5000);
        
        // ADULTS DROPDOWN
        click(By.cssSelector("select[name='adults']"));
        click(By.cssSelector("select[name='adults'] option:nth-child(4)")); // 2 adults
        Thread.sleep(5000);

        // CHILDREN DROPDOWN
        click(By.cssSelector("select[name='children']"));
        click(By.cssSelector("select[name='children'] option:nth-child(3)")); // 1 child
        Thread.sleep(5000);

        // UPLOAD ID PROOF
        uploadFile(By.cssSelector("input#idproof"),"C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop");
        Thread.sleep(5000);

	    // SUBMIT BUTTON
        click(By.cssSelector("input#add"));
        System.out.println("Form Submitted Successfully.");
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
        System.out.println("Uploaded File: " + path);
    }

}
