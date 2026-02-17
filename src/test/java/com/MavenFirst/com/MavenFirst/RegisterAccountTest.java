package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterAccountTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtility bu = new BrowserUtility();
		WebDriver driver = bu.launchBrowser("chrome");
		// Open Register Page
        bu.lunchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        // Maximize window after launching
        driver.manage().window().maximize();
        
        // Fill in user details
        driver.findElement(By.id("input-firstname")).sendKeys("Nikhil");
        driver.findElement(By.id("input-lastname")).sendKeys("Shahane");
        driver.findElement(By.id("input-email")).sendKeys("nikhil@gmail.com");
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
        driver.findElement(By.id("input-password")).sendKeys("Test@123");
        driver.findElement(By.id("input-confirm")).sendKeys("Test@123");
        // Agree to Privacy Policy
        WebElement agree = driver.findElement(By.name("agree"));
        if (!agree.isSelected()) 
        {
            agree.click();
        }

        // Click Continue
        driver.findElement(By.xpath("//input[@value='Continue']")).click();

        // Wait for page to load
        Thread.sleep(5000);

        // Expected vs Actual verification
        String expectedResult = "Your Account Has Been Created!";
        String actualResult = driver.findElement(By.tagName("h1")).getText();

        System.out.println("Expected Result: " + expectedResult);
        System.out.println("Actual Result: " + actualResult);

        if (actualResult.equals(expectedResult)) 
        {
            System.out.println("Test Passed - Registration successful!");
        } else {
            System.out.println("Test Failed - Expected '" + expectedResult + "' but got '" + actualResult + "'");
        }

        // Close browser
        Thread.sleep(5000);
        bu.quitBrowser();
	}

}
