package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Iterator;
import java.util.Set;

public class WindowSwitchTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Initialize Driver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Navigate to the specific URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(2000);

        // 1. Click the 'Open Window' button
        driver.findElement(By.id("openwindow")).click();

        // 2. Capture all window handles
        Set<String> windows = driver.getWindowHandles(); 
        Iterator<String> it = windows.iterator();

        String parentId = it.next(); // ID of the main practice page
        String childId = it.next();  // ID of the newly opened window

        // 3. Switch focus to the child window
        driver.switchTo().window(childId);
        
        // Log the child window details
        System.out.println("--- Child Window Info ---");
        System.out.println("Title: " + driver.getTitle());
        System.out.println("URL: " + driver.getCurrentUrl());

        // 4. Close the child window and switch back to parent
        driver.close(); 
        driver.switchTo().window(parentId);
        
        System.out.println("\n--- Back to Parent Window ---");
        System.out.println("Parent Title: " + driver.getTitle());

        // Cleanup
        driver.quit();

	}

}
