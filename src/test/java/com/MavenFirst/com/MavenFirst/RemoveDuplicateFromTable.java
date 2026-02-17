package com.MavenFirst.com.MavenFirst;

import java.time.Duration;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveDuplicateFromTable 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the url
        String url = "https://cosmocode.io/automation-practice-webtable/";
        driver.get(url);
        System.out.println("Page opened successfully");
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Create WebDriverWait Object        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // XPath for Country column (2nd column)
        By countryColumn = By.xpath("//table[@id='countries']//tbody//tr/td[2]");

        // Step 3: Call generic method
        Set<String> uniqueCountries = removeDuplicatesFromTable(countryColumn);

        // Step 4: Print final result
        System.out.println("\n----- FINAL UNIQUE VALUES -----");
        for (String country : uniqueCountries) 
        {
            System.out.println(country);
        }
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");

	}
	
	// ============================================================
    // GENERIC METHOD: Remove duplicate values from table column
    // ============================================================
    public static Set<String> removeDuplicatesFromTable(By locator) 
    {

        // Get all elements from the table column
        List<WebElement> elements = driver.findElements(locator);
        System.out.println("\nTotal values found: " + elements.size());

        // LinkedHashSet removes duplicates and keeps order
        Set<String> uniqueValues = new LinkedHashSet<>();

        for (WebElement el : elements) {
            String text = el.getText().trim();

            // Ignore empty text and header
            if (!text.isEmpty() && !text.equalsIgnoreCase("Country")) 
            {
                uniqueValues.add(text);
            }
        }

        System.out.println("Unique values count: " + uniqueValues.size());
        System.out.println("Duplicate values count: 0");

        return uniqueValues;
    }

}
