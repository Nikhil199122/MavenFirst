package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class SvgClickExample 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open webpage
        String url = "https://www.google.com";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        Thread.sleep(5000);Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Voice icon SVG (index based)
        By voiceIcon = By.xpath("(//*[local-name()='svg' and @class='goxjub'])[1]");
        Thread.sleep(5000);
        
        // Camera icon SVG (index based)
        By cameraIcon = By.xpath("(//*[local-name()='svg' and @class='Gdd5U'])[1]");
        Thread.sleep(5000);
        
        // TRUE clickable cancel button (NOT the SVG)
        By cancelButton = By.xpath("//*[@aria-label='Close']");
        
        // Click camera icon
        eleUtil.doClick(cameraIcon);
        System.out.println("Camera icon clicked successfully.");
        Thread.sleep(5000);
        
        // Click cancel
        eleUtil.doClick(cancelButton);
        System.out.println("Cancel button clicked.");
        Thread.sleep(5000);

        // Click voice icon
        eleUtil.doClick(voiceIcon);
        System.out.println("Voice icon clicked successfully.");
        Thread.sleep(5000);
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
        

	}
}
