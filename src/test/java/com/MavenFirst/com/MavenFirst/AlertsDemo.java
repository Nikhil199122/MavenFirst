package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class AlertsDemo 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://www.hyrtutorials.com/p/alertsdemo.html");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Define locators for buttons
        By alertButton = By.id("alertBox");
        By confirmButton = By.id("confirmBox");
        By promptButton = By.id("promptBox");
        
        // Step 5: Perform alert handling using Actions
        System.out.println("=== Handling Simple Alert ===");
        ElementUtil.handleAlertWithActions(alertButton, "accept", null);

        System.out.println("=== Handling Confirm Alert (Dismiss) ===");
        ElementUtil.handleAlertWithActions(confirmButton, "dismiss", null);

        System.out.println("=== Handling Prompt Alert (Enter Text + Accept) ===");
		ElementUtil.handleAlertWithActions(promptButton, "accept", "Selenium Test");

        // Step 6: Close browser
        driver.quit();  

	}

}
