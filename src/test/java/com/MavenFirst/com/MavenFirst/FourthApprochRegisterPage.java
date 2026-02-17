package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FourthApprochRegisterPage 
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
	    // Locate
	    WebElement Web_fn = driver.findElement(firstName);
	    WebElement Web_ln = driver.findElement(lastName);
	    WebElement Web_Email = driver.findElement(email);
	    WebElement Web_ph = driver.findElement(phone);
	    WebElement Web_pw = driver.findElement(pass);
	    WebElement Web_cf = driver.findElement(confirm);
	    // Interactions
	    Web_fn= getElement(firstName);
	    Web_ln= getElement(lastName);
	    Web_Email= getElement(email);
	    Web_ph= getElement(phone);
	    Web_pw= getElement(pass);
	    Web_cf= getElement(confirm);
	    // Interactions
	    Web_fn.sendKeys("Nikhil");
	    Web_ln.sendKeys("Shahane");
	    Web_Email.sendKeys("nikhil@gmail.com");
	    Web_ph.sendKeys("9876543210");
	    Web_pw.sendKeys("Nikhil@123");
	    Web_cf.sendKeys("test@123");
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
