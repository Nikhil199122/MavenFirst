package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarPreviousButton 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
		        
		//  Open webpage
		driver.get("https://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
		System.out.println("Page opened.");
		
		// Create WebDriverWait Object        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// Wait until date picker box is clickable
        WebElement dateBox = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("datepicker")));
        
        // Click to open calendar
        dateBox.click();

        // Use generic method to click previous button 3 times
        goToPreviousMonth(wait, 3);
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!"); 
	}
	// =================================================================
    // Generic Method: Click previous button 'n' times using WebDriverWait
    // =================================================================
    public static void goToPreviousMonth(WebDriverWait wait, int times) 
    {

        By prevBtnLocator = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']");

        for (int i = 0; i < times; i++) 
        {

            // Wait until previous button is clickable
            WebElement prevBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(prevBtnLocator));

            // Click previous button
            prevBtn.click();
            System.out.println("Previous button clicked: " + (i + 1));
        }
    }
}
