package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class FlipkartSVGSearch 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open webpage
        String url = "https://www.flipkart.com";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Type in Search Box
        type(By.xpath("//input[@title='Search for Products, Brands and More']"), "laptop");
        Thread.sleep(5000);
        
        // Click SVG Search Icon
        click(By.xpath("//*[local-name()='svg' and @width='24']"));
        System.out.println("Clicked on SVG Search Icon.");
        Thread.sleep(5000);
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
      
	}
	
	// ------------------ GENERIC METHODS ------------------

    public static void click(By locator) {
        driver.findElement(locator).click();
        System.out.println("Clicked: " + locator);
    }

    public static void type(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
        System.out.println("Typed: " + text);
    }

}
