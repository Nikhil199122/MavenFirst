package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FrameHandling2 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser using BrowserUtility
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");

        // Step 2: Open Frames practice page
        brUtil.lunchUrl("https://www.tutorialspoint.com/selenium/practice/frames.php");
        System.out.println("Opened TutorialsPoint Frames Practice Page");
        Thread.sleep(3000);

        // Step 3: Create ElementUtility instance
        ElementUtil eleUtil = new ElementUtil(driver);

        // ---------------- FRAME 1 ----------------
        WebElement frame1 = driver.findElement(By.xpath("(//iframe)[1]"));
        switchToFrame(frame1);

        By frame1Heading = By.tagName("h1");
        By frame1Text = By.xpath("(//h2[contains(text(),'Selenium - Automation Practice Form')])[1]");
        System.out.println("Frame 1 Heading: " + eleUtil.doGetText(frame1Heading));
        System.out.println("Frame 1 Text: " + eleUtil.doGetText(frame1Text));

        switchToMainPage();
        Thread.sleep(2000);

        // ---------------- FRAME 2 ----------------
        WebElement frame2 = driver.findElement(By.xpath("(//Iframe)[2]"));
        switchToFrame(frame2);

        By frame2Heading = By.tagName("h1");
        By frame2Text = By.xpath("(//h2[contains(text(),'Selenium - Automation Practice Form')])[1]");
        System.out.println("Frame 2 Heading: " + eleUtil.doGetText(frame2Heading));
        System.out.println("Frame 2 Text: " + eleUtil.doGetText(frame2Text));

        switchToMainPage();
        Thread.sleep(2000);

        // ---------------- MAIN PAGE ----------------
        By mainHeader = By.xpath("//h1[contains(text(),'Frames')]");
        System.out.println("Main Page Heading: " + eleUtil.doGetText(mainHeader));

        // Step 4: Close browser
        brUtil.quitBrowser();
        System.out.println("Test completed successfully!");
    }

    // ---------- GENERIC METHODS ----------

    // Switch to frame using WebElement
    public static void switchToFrame(WebElement frameElement)
    {
        driver.switchTo().frame(frameElement);
        System.out.println("Switched to frame successfully.");
    }

    // Switch back to main content
    public static void switchToMainPage() 
    {
        driver.switchTo().defaultContent();
        System.out.println("Switched back to main page.");
    }
}


