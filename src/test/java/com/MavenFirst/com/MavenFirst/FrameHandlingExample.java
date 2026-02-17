package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class FrameHandlingExample 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Step 2: Open HYR Tutorials Window Handles Practice page
        driver.get("https://www.londonfreelance.org/courses/frames/index.html");
        Thread.sleep(5000);

        // --- Switch to frame by index (0 = top frame) ---
        driver.switchTo().frame("main");
        Thread.sleep(5000);
        System.out.println(driver.findElement(By.xpath("//h2[text()='Title bar ']")).getText());
        //System.out.println("Top Frame Text: " + topText);

        // Go back to the main page
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        // --- Switch to frame by index (1 = left frame) ---
        driver.switchTo().frame("navbar");
        System.out.println(driver.findElement(By.xpath("//a[text()='No frames']")).getText());
        //System.out.println("Left Frame Text: " + leftText);
        Thread.sleep(5000);

        // Go back to the main page
        driver.switchTo().defaultContent();
        Thread.sleep(5000);

        // --- Switch to frame by index (2 = main frame) ---
        driver.switchTo().frame("content");
        Thread.sleep(5000);
        String mainHeading = driver.findElement(By.xpath("//p[2]")).getText();
        System.out.println("Main Frame Heading: " + mainHeading);

        String paraText = driver.findElement(By.xpath("//p[1]")).getText();
        System.out.println("Main Frame Paragraph: " + paraText);
        Thread.sleep(5000);

        // Back to main content again
        driver.switchTo().defaultContent();
        System.out.println("Returned to parent content");

        driver.quit();
        System.out.println("Browser closed successfully");
	}

}
