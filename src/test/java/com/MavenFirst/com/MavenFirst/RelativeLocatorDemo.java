package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorDemo 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
		        
		// Step 2: Open webpage
		driver.get("https://vinothqaacademy.com/webTable/");
		System.out.println("Page opened: https://vinothqaacademy.com/webTable/");
		        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        
		// Step 3: Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// -----------------------------------------
        // Example 1: Get Role where Name = "John Doe"
        // -----------------------------------------
		
		WebElement johnDoe = driver.findElement(By.xpath("//td[text()='John Doe']"));

        WebElement roleOfJohn = getRelativeElement(driver,By.tagName("td"),johnDoe,"right" );
        System.out.println("Role of John Doe: " + roleOfJohn.getText());
        
        // -----------------------------------------
        // Example 2: Get Location above "Operations"
        // -----------------------------------------
        WebElement operations = driver.findElement(By.xpath("//td[text()='Operations']"));

        WebElement locationAbove = getRelativeElement(driver,By.tagName("td"),operations,"above");
        System.out.println("Location above Operations: " + locationAbove.getText());
        
        // -----------------------------------------
        // Example 3: Get Email left of "Toronto"
        // -----------------------------------------
        WebElement toronto = driver.findElement(By.xpath("//td[text()='Toronto']"));

        WebElement emailLeft = getRelativeElement(driver,By.tagName("td"),toronto,"left");
        System.out.println("Email left of Toronto: " + emailLeft.getText());
        
        // Example 4: find first Role cell below header "Role"
        WebElement roleHeader = driver.findElement(By.xpath("//th[normalize-space()='Role']"));
        WebElement firstRole = getRelativeElement(driver, By.tagName("td"), roleHeader, "below");
        System.out.println("First role under header 'Role': " + firstRole.getText());
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");       
	}
	
	/**
     * Generic helper that returns a WebElement found using Selenium 4 Relative Locators.
     *
     * @param driver  WebDriver instance
     * @param tag  the By locator for the target element type (e.g. By.tagName("td"))
     * @param base the reference element (the element to the left/right/above/below/near)
     * @param direction "right", "left", "above", "below", or "near"
     * @return located WebElement
     */
    public static WebElement getRelativeElement(WebDriver driver, By tag, WebElement base, String direction) 
    {

        switch (direction.toLowerCase()) 
        {

            case "right":
                return driver.findElement(with(tag).toRightOf(base));

            case "left":
                return driver.findElement(with(tag).toLeftOf(base));

            case "above":
                return driver.findElement(with(tag).above(base));

            case "below":
                return driver.findElement(with(tag).below(base));

            case "near":
                return driver.findElement(with(tag).near(base));

            default:
                throw new IllegalArgumentException("Invalid direction: " + direction);
        }
    }
}
