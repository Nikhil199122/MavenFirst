package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IFrameHandlingDemo 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the iframe practice page
        String url = "https://sriptings.com/practice-site/selenium-iframe-automation-practice/";
        brUtil.lunchUrl(url);
        System.out.println("Opened IFrame Practice Page.");
        Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // ---------------- SIMPLE IFRAME ----------------
        System.out.println("\n=== SIMPLE IFRAME SECTION ===");
        // Switch to the first iframe (index 0)
        driver.switchTo().frame(0);
        System.out.println("Switched to Simple IFrame.");
        Thread.sleep(5000);
        
        // Locate the text inside iframe
        By simpleFrameText = By.xpath("//p[contains(text(),'This is a simple iframe for Selenium practice.')]");
        String simpleText = eleUtil.doGetText(simpleFrameText);
        System.out.println("Simple Frame Text: " + simpleText);
        Thread.sleep(5000);
        
        // Click the button inside iframe
        By clickMeButton = By.xpath("//button[text()='Click Me']");
        eleUtil.getElement(clickMeButton).click();
        System.out.println("Clicked 'Click Me' button inside Simple IFrame.");
        Thread.sleep(5000);
        
        // Switch back to main page
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page.");
        Thread.sleep(5000);
        
        // ---------------- NESTED IFRAME ----------------
        System.out.println("\n=== NESTED IFRAME SECTION ===");
        // Switch to the parent iframe (index 1)
        driver.switchTo().frame(1);
        System.out.println("Switched to Parent IFrame.");
        Thread.sleep(5000);
        
        // Locate text inside parent iframe
        By parentText = By.xpath("//p[contains(text(),'This is the parent iframe containing a nested frame.')]");
        System.out.println("Parent Frame Text: " + eleUtil.doGetText(parentText));
        Thread.sleep(5000);
        
        // Now switch to the nested iframe inside parent
        WebElement nestedFrame = driver.findElement(By.xpath("//iframe[@title='nestedIframe']"));
        driver.switchTo().frame(nestedFrame);
        System.out.println("Switched to Nested IFrame.");
        Thread.sleep(5000);
        
        // Locate text inside nested iframe
        By nestedText = By.xpath("//p[contains(text(),'This is the nested iframe content.')]");
        System.out.println("Nested Frame Text: " + eleUtil.doGetText(nestedText));
        Thread.sleep(5000);

        // Switch back to parent, then to main content
        driver.switchTo().parentFrame();
        System.out.println("Back to Parent IFrame.");
        driver.switchTo().defaultContent();
        System.out.println("Back to Main Page.");
        Thread.sleep(5000);
        
        // Step 4: Close browser
        brUtil.quitBrowser();
        System.out.println("Test completed successfully!");
	}
}
