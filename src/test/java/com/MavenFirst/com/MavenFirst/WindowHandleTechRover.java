package com.MavenFirst.com.MavenFirst;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandleTechRover 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Step 2: Open HYR Tutorials Window Handles Practice page
        driver.get("https://www.techrover.us/");
        Thread.sleep(5000);
        
        // Step 3: Click on WhatsApp icon in the footer
     	driver.findElement(By.xpath("//a[contains(@href,'whatsapp')]")).click();
     	System.out.println("Clicked on WhatsApp icon");
     	Thread.sleep(5000);

     	// Step 4: Get all window handles
     	Set<String> handles = driver.getWindowHandles();
     	Iterator<String> it = handles.iterator();
     	String parentWindow = it.next();
     	System.out.println("Parent Window ID: " + parentWindow);
     	String childWindow = it.next();
     	System.out.println("Child Window ID: " + childWindow);
     	Thread.sleep(5000);

     	System.out.println("++++++++++++++++++++++++++++++++++++");
     	System.out.println(" ");

     	// Step 5: Switch to WhatsApp tab
     	driver.switchTo().window(childWindow);
     	System.out.println("Switched to Child Window");
     	System.out.println("Child Window URL: " + driver.getCurrentUrl());
     	System.out.println("Child Window Title: " + driver.getTitle());
     	Thread.sleep(5000);

     	System.out.println("++++++++++++++++++++++++++++++++++++");
     	System.out.println(" ");

     	// Step 6: Close the child tab
     	driver.close();
     	System.out.println("Child window closed");
     	Thread.sleep(5000);

     	System.out.println("++++++++++++++++++++++++++++++++++++");
     	System.out.println(" ");

     	// Step 7: Switch back to main window
     	driver.switchTo().window(parentWindow);
     	System.out.println("Switched back to Parent Window");
     	System.out.println("Parent Window URL: " + driver.getCurrentUrl());
     	System.out.println("Parent Window Title: " + driver.getTitle());
     	Thread.sleep(5000);

     	System.out.println("++++++++++++++++++++++++++++++++++++");
     	System.out.println(" ");
     	
     	// Step 8: Quit browser
     	driver.quit();
     	System.out.println("Browser closed successfully.");
	}
}
