package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterLinkTestWithoutUsingInBuiltFunctionsMethodOfSelenium 
{
	public static void main(String[] args) throws InterruptedException 
	{
		//Step 1: Launch the browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the Freshworks website
        brUtil.lunchUrl("https://www.freshworks.com/");
        Thread.sleep(3000);
        
        // Step 3: Create an instance of ElementUtility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: check if "Company" section exists
        By companySection = By.xpath("//footer//div[contains(text(),'Company')]");
        boolean companyExists = eleUtil.isElementExists(companySection);
        System.out.println("Company Section Exists: " + companyExists);
        
        // Step 5: check for a non-existing element
        By fakeLocator = By.xpath("//footer//div[contains(text(),'RandomSection')]");
        boolean fakeExists = eleUtil.isElementExists(fakeLocator);
        System.out.println("Random Section Exists: " + fakeExists);
        
        // Step 7: Close the browser
        brUtil.quitBrowser();
	}

}
