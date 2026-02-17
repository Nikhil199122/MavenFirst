package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DummyFormTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Initialize browser utility
		BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Launch Amazon India
        brUtil.lunchUrl("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(10);
        
        // Initialize element utility
        ElementUtil eleUtil = new ElementUtil(driver);

        // Locators
        By email = By.xpath("//*[@id=\"shub89\"]");
        By password = By.xpath("//*[@id=\"pass\"]");
        By company = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div/div/input[1]");
        By mobile = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div/div/input[2]");
        By country = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div/div/div[3]/label/input");
        By submitBtn = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/button");
        By text = By.xpath("//*[@id=\"inp_val\"]");
        By downloadLink = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/span/a");
        By youtubeLink = By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/a[1]");
        Thread.sleep(5000);
        
        // Fill form
        eleUtil.doSendKeys(email, "nikhil@gmail.com");
        eleUtil.doSendKeys(password, "Test@123");
        eleUtil.doSendKeys(company, "TechCorp");
        eleUtil.doSendKeys(mobile, "9876543210");
        eleUtil.doSendKeys(country, "India");  // will be skipped if disabled
        Thread.sleep(5000);

        // Submit form
        eleUtil.doClick(submitBtn);
        Thread.sleep(5000);

        // Enter text "Mango"
        eleUtil.doSendKeys(text, "Mango");
        Thread.sleep(5000);

        // Click download link
        eleUtil.doClick(downloadLink);
        Thread.sleep(5000);

        // Click YouTube link
        eleUtil.doClick(youtubeLink);
        Thread.sleep(5000);

        // Close browser
        brUtil.quitBrowser();
        System.out.println("Test completed successfully.");
	}

}
