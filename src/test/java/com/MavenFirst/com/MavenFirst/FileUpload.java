package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload 
{
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        
        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");


        // File path (change to your actual file path)
        String filePath = "C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop\\sample.txt";

        // Upload file
        driver.findElement(By.id("singleFileInput")).sendKeys(filePath);

        Thread.sleep(2000);

        // Click Upload button
        driver.findElement(By.xpath("//button[text()='Upload Single File']")).click();

        Thread.sleep(3000);
        driver.quit();

	}
	
}
