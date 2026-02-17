package com.MavenFirst.com.MavenFirst;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenLinkInNewTabTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Open the website
        driver.get("https://omayo.blogspot.com/2013/05/page-one.html");
        Thread.sleep(3000);

        // Step 3: Click the Selenium143 link (simple click)
        driver.findElement(By.xpath("//*[@id='selenium143']")).click();
        System.out.println("Clicked on Selenium143 link");
        Thread.sleep(5000);

        // Step 4: Handle multiple windows
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> it = handles.iterator();
        String parentWindow = it.next();
        System.out.println("Parent Window ID: " + parentWindow);
        String childWindow = it.next();
        System.out.println("Child Window ID: " + childWindow);
        Thread.sleep(5000);

        // Step 5: Switch to child window
        driver.switchTo().window(childWindow);
        System.out.println(driver.getCurrentUrl());
        //System.out.println("Child Window Title: " + driver.getTitle());
        Thread.sleep(5000);

        // Step 6: Close child window
        driver.close();
        System.out.println("Child window closed");
        Thread.sleep(5000);

        // Step 8: Switch back to parent window
        driver.switchTo().window(parentWindow);
        System.out.println(driver.getCurrentUrl());
        //System.out.println("Parent Window Title: " + driver.getTitle());
        Thread.sleep(5000);

        // Step 9: Quit browser
        driver.quit();
        System.out.println("Browser session ended successfully.");
	}	
}
