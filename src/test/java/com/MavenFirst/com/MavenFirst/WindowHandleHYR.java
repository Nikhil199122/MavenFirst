package com.MavenFirst.com.MavenFirst;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class WindowHandleHYR 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        
        // Step 2: Open HYR Tutorials Window Handles Practice page
        driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
        Thread.sleep(5000);
        
        // Step 3: Click the "Open New Tab" button
        driver.findElement(By.id("newTabBtn")).click();
        System.out.println("Clicked on 'Open New Tab' button");
        Thread.sleep(5000);
        
        // Step 4: Get window handles
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        System.out.println("Parent Window ID: " + parentWindow);
        String childWindow = it.next();
        System.out.println("Child Window ID: " + childWindow);
        Thread.sleep(5000);
        
        // Step 5: Switch to the new tab
        driver.switchTo().window(childWindow);
        System.out.println("Switched to Child Window");
        System.out.println("Child Window URL: " + driver.getCurrentUrl());
        System.out.println("Child Window Title: " + driver.getTitle());
        Thread.sleep(5000);
        
        // Step 6: Close child window
        driver.close();
        System.out.println("Child window closed");
        Thread.sleep(5000);
        
        // Step 7: Switch back to parent window
        driver.switchTo().window(parentWindow);
        System.out.println("Back to Parent Window");
        System.out.println("Parent Window URL: " + driver.getCurrentUrl());
        System.out.println("Parent Window Title: " + driver.getTitle());
        Thread.sleep(5000);
        
        // Step 8: Quit browser
        driver.quit();
        System.out.println("Browser closed successfully.");

	}

}
