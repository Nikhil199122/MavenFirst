package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ThirdApproachRegisterPage 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser
		WebDriver driver = new ChromeDriver();
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
	    WebElement fn = driver.findElement(firstName);
	    WebElement ln = driver.findElement(lastName);
	    WebElement em = driver.findElement(email);
	    WebElement ph = driver.findElement(phone);
	    WebElement pw = driver.findElement(pass);
	    WebElement cf = driver.findElement(confirm);
	    // Interactions
	    fn.sendKeys("Nikhil");
	    ln.sendKeys("Shahane");
	    em.sendKeys("nikhil@gmail.com");
	    ph.sendKeys("9876543210");
	    pw.sendKeys("Nikhil@123");
	    cf.sendKeys("test@123");
	    Thread.sleep(5000); // Just for Observe
	    driver.quit();

	}

}
