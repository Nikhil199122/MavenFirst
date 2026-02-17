package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FrameHandlingDemo 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser using BrowserUtility
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");

        // Step 2: Open the DemoQA Frames page
        brUtil.lunchUrl("https://demoqa.com/frames");
        System.out.println("Opened DemoQA Frames page.");
        Thread.sleep(3000);

        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);

        // -------------------- FRAME 1 --------------------
        driver.switchTo().frame("frame1");
        System.out.println("Switched to Frame 1.");
        Thread.sleep(5000);

        // Locate and get text inside Frame 1
        By frame1Text = By.id("sampleHeading");
        System.out.println("Frame 1 Text: " + eleUtil.doGetText(frame1Text));
        Thread.sleep(5000);

        // Switch back to main page
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page.");
        Thread.sleep(5000);

        // -------------------- FRAME 2 --------------------
        driver.switchTo().frame("frame2");
        System.out.println("Switched to Frame 2.");
        Thread.sleep(5000);

        // Locate and get text inside Frame 2
        By frame2Text = By.id("sampleHeading");
        System.out.println("Frame 2 Text: " + eleUtil.doGetText(frame2Text));
        Thread.sleep(5000);

        // Switch back to main page again
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page.");
        Thread.sleep(5000);

        // Step 4: Close browser
        brUtil.quitBrowser();
        System.out.println("Test completed successfully!");
	}

}
