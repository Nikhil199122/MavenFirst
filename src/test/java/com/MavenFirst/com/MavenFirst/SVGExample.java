package com.MavenFirst.com.MavenFirst;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class SVGExample 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open webpage
        String url = "https://petdiseasealerts.org/forecast-map#/";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil util = new ElementUtil(driver);
        
        // Switch inside the iframe that holds SVG map
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@id,'map-instance')]")));
        Thread.sleep(5000);
        
        // Get all states (SVG <path> elements)
        List<WebElement> allStates = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']" + "//*[name()='g' and @class='region']" + "//*[name()='g' and @class='rpath']" + "//*[name()='path']"));
        Thread.sleep(5000);
        
        System.out.println("Total States Found: " + allStates.size());
        System.out.println("----------------------------------------");
        
        
        // Print all state names
        for (WebElement state : allStates) 
        {
            System.out.println(state.getAttribute("name"));
        }
        Thread.sleep(5000);
        
        System.out.println("----------------------------------------");
        
        // Select state and print all region details
        clickState(allStates, "Wyoming");
        Thread.sleep(5000);
        
        // After clicking, read all region titles for selected state
        List<WebElement> regions = driver.findElements(By.xpath("//*[local-name()='svg' and @id='map-svg']//*[name()='g' and @class='region']//*[name()='g' and @class='rpath']//*[name()='path']"));
        System.out.println("Regions inside selected state:");
        for (WebElement region  : regions) 
        {
            System.out.println(region.getAttribute("name"));
        }
        Thread.sleep(5000);
        
        //Close browser
        driver.quit();
        System.out.println("Test completed successfully!");    
	}
	// Generic method to click a state by its name
    public static void clickState(List<WebElement> states, String stateName) 
    {
        for (WebElement s : states) 
        {
            if (s.getAttribute("name").equals(stateName)) 
            {
                System.out.println("Selected State: " + stateName);
                s.click();
                break;
            }
        }
    }
}
