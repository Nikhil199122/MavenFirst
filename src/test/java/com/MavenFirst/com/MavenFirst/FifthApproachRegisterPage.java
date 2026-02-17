package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FifthApproachRegisterPage 
{
	static WebDriver driver=null;
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser
		driver = new ChromeDriver();
		// Open Register Account page
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		driver.manage().window().maximize();
		// Define locators
	    By firstName= By.id("input-firstname");
	    By lastName= By.id("input-lastname");
	    By email= By.id("input-email");
	    By phone= By.id("input-telephone");
	    By pass= By.id("input-password");
	    By confirm= By.id("input-confirm");
	    // Use generic functions
        doSendKeys(firstName, "Nikhil");
        doSendKeys(lastName,  "Shahane");
        doSendKeys(email, "nikhil@gmail.com");
        doSendKeys(phone, "9876543210");
        doSendKeys(pass, "test@123");
        doSendKeys(confirm, "test@123");
		Thread.sleep(5000); // Just for Observe
		driver.quit();

	}
	public static WebElement getElement(By locator)
	{
		return driver.findElement(locator);
	}
	public static void doSendKeys(By locator, String value)
	{
		getElement(locator).sendKeys(value);
	}

}
