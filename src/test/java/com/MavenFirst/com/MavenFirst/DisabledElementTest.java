package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DisabledElementTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");

        // Step 2: Open the target page
        brUtil.lunchUrl("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(2000);

        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);

        // Step 4: Define locators for First Name and Last Name fields
        By firstName = By.xpath("//input[@name='test']"); // for "First Enter name"
        By lastName = By.xpath("//input[@name='test' and @disabled]"); // for "Enter Last name"

        // Step 5: Perform actions using utility methods
        eleUtil.doSendKeys(firstName, "Nikhil");
        eleUtil.doSendKeys(lastName, "Shahane");

        System.out.println("First and last name entered successfully.");
        Thread.sleep(3000);

        // Step 6: Close the browser
        brUtil.quitBrowser();

        System.out.println("Test completed successfully.");

	}

}
