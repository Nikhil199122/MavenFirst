package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SecondApproachRegisterPage 
{

	public static void main(String[] args) throws InterruptedException 
	{
		 // Launch browser
		 WebDriver driver = new ChromeDriver();
		 // Open Register Account page
		 driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
	     driver.manage().window().maximize();
	     // 1.First Name
	     WebElement firstname= driver.findElement(By.id("input-firstname"));
	     // 2. Last Name
	     WebElement lastname= driver.findElement(By.id("input-lastname"));
	     // 3.Email
	     WebElement email= driver.findElement(By.id("input-email"));
	     // 4.Telephone
	     WebElement telephone= driver.findElement(By.id("input-telephone"));
	     //5.Password
	     WebElement password= driver.findElement(By.id("input-password"));
	     //6.Confirm Password
	     WebElement cp= driver.findElement(By.id("input-confirm"));
	     
	     // Fill fields
	     firstname.sendKeys("Nikhil");
	     lastname.sendKeys("Shahane");
	     email.sendKeys("test@gmail.com");
	     telephone.sendKeys("9876543210");
	     password.sendKeys("test@123");
	     cp.sendKeys("test@123");
	     Thread.sleep(5000); // Just for Observe
		 driver.quit();
	}

}
