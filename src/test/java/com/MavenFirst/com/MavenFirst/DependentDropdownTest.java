package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DependentDropdownTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		// Initialize browser utility
		BrowserUtility brUtil = new BrowserUtility();
		WebDriver driver = brUtil.launchBrowser("chrome");
		
		// Launch Amazon India
        brUtil.lunchUrl("https://www.jqueryscript.net/demo/Multilevel-Dependent-Dropdown-Plugin-With-jQuery-Dependent-Dropdowns/");
        Thread.sleep(10);
        
        // Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Locators for dropdowns
        By firstLevel = By.id("first");
        By secondLevel = By.id("second");
        By thirdLevel = By.id("third");
        
        // Step 1: Select from First Level Dropdown
        eleUtil.selectDropdownByVisibleText(firstLevel, "Option 1");
        Thread.sleep(5000); // wait for dependent dropdown to load

        // Step 2: Select from Second Level Dropdown (enabled after first)
        eleUtil.selectDropdownByVisibleText(secondLevel, "Option 1-2");
        Thread.sleep(5000);

        // Step 3: Select from Third Level Dropdown (enabled after second)
        eleUtil.selectDropdownByVisibleText(thirdLevel, "Option 1-2-1");
        Thread.sleep(5000);
        
        // Close browser
        brUtil.quitBrowser();
        System.out.println("Dependent dropdown test completed successfully.");
        

	}

}
