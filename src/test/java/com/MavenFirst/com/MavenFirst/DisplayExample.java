package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DisplayExample 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch Browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(5000);

        // Locate Elements
        WebElement textBox = driver.findElement(By.id("displayed-text"));
        WebElement hideBtn = driver.findElement(By.id("hide-textbox"));
        WebElement showBtn = driver.findElement(By.id("show-textbox"));

        // Click Hide Button
        hideBtn.click();
        System.out.println("After Hide Click: " + textBox.isDisplayed());
        Thread.sleep(5000);

        // Click Show Button
        showBtn.click();
        System.out.println("After Show Click: " + textBox.isDisplayed());
        Thread.sleep(5000);

        // Enter Text if Displayed
        if (textBox.isDisplayed()) 
        {
            textBox.clear();
            textBox.sendKeys("Nikhil Shahane");
            System.out.println("Entered Text: " + textBox.getAttribute("value"));
        }
        Thread.sleep(5000);

        // Close Browser
        driver.quit();

	}

}
