package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocatorWebTable 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
				        
		// Step 2: Open webpage
		driver.get("https://www.tutorialspoint.com/selenium/practice/webtables.php");
		System.out.println("Page opened: https://vinothqaacademy.com/webTable/");
				        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				        
		// Step 3: Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// -------------------------------
        // Example 1: Get Last Name to the right of First Name "Cierra"
        // -------------------------------
        WebElement firstName = driver.findElement(By.xpath("//td[text()='Cierra']"));
        WebElement lastName = getRelativeElement(driver,By.tagName("td"),firstName,"right");
        System.out.println("Last Name of Cierra: " + lastName.getText());
        
        // -------------------------------
        // Example 2: Get Salary above "2000"
        // -------------------------------
        WebElement salary2000 = driver.findElement(By.xpath("//td[text()='2000']"));
        WebElement salaryAbove = getRelativeElement(driver,By.tagName("td"),salary2000,"above");
        System.out.println("Salary above 2000 row: " + salaryAbove.getText());
        
        // -------------------------------
        // Example 3: Get Email left of Salary "10000"
        // -------------------------------
        WebElement salary10000 = driver.findElement(By.xpath("//td[text()='10000']"));
        WebElement emailLeft = getRelativeElement(driver,By.tagName("td"),salary10000,"left");
        System.out.println("Email left of 10000 salary: " + emailLeft.getText());
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!"); 
	}
	
	// ---------------------------------------------------
    // GENERIC METHOD FOR RELATIVE LOCATORS
    // direction → "right", "left", "above", "below", "near"
    // ---------------------------------------------------
    public static WebElement getRelativeElement(WebDriver driver, By tag, WebElement base, String direction) {

        switch (direction.toLowerCase()) {

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
