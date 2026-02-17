package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstApproachRegisterPage {

	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser
		WebDriver driver = new ChromeDriver();
		// Open Register Account page
	    driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	    driver.manage().window().maximize();
	    
	    // 1. Fill First Name
	    driver.findElement(By.id("input-firstname")).sendKeys("Nikhil");
	    // 2. Fill Last Name
	    driver.findElement(By.id("input-lastname")).sendKeys("Shahane");
	    // 3. Fill Email
	    driver.findElement(By.id("input-email")).sendKeys("test@gmail.com");
	    // 4. Fill Telephone
        driver.findElement(By.id("input-telephone")).sendKeys("9876543210");
        // 5. Fill Password
        driver.findElement(By.id("input-password")).sendKeys("test@123");
        // 6. Fill Confirm Password
        driver.findElement(By.id("input-confirm")).sendKeys("test@123");
        Thread.sleep(5000); // Just for Observe
	    driver.quit();
	}

}
