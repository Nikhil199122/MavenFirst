package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMUrlContainsTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtility bu = new BrowserUtility();
        WebDriver driver = bu.launchBrowser("chrome");
        // 1) Open login page
        bu.lunchUrl("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(5000);
       // 2) Enter demo credentials and login
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(5000);
        // 3) Wait for post-login URL and verify keyword
        Thread.sleep(5000);
        String current = driver.getCurrentUrl();
        if (!current.toLowerCase().contains("orange")) {
            throw new AssertionError("Expected URL to contain 'Orange', but was: " + current);
        }
        System.out.println("PASS: URL contains 'Orange' -> " + current);

        // 4) Close
        bu.quitBrowser();
        
	}

}
