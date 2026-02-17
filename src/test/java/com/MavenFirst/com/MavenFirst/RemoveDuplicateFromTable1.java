package com.MavenFirst.com.MavenFirst;

import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RemoveDuplicateFromTable1 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the url
        String url = "https://www.tutorialspoint.com/selenium/practice/webtables.php";
        driver.get(url);
        System.out.println("Page opened successfully");
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Create WebDriverWait Object        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Step 4: Remove duplicate rows
        Set<String> uniqueRows = getUniqueRows("//table/tbody/tr","./td");

        // Step 5: Print final result
        System.out.println("\nFinal Unique rows count: " + uniqueRows.size());
        System.out.println("Duplicate rows count: 0");

        System.out.println("\n----- FINAL TABLE DATA (AFTER REMOVING DUPLICATES) -----");
        for (String row : uniqueRows) 
        {
            System.out.println(row);
        }
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}	
	// ----------------------------------------------------
    // GENERIC METHOD → GET UNIQUE ROWS FROM TABLE
    // ----------------------------------------------------
    public static Set<String> getUniqueRows(String rowXpath, String colXpath) 
    {

        List<WebElement> rows = driver.findElements(By.xpath(rowXpath));
        System.out.println("\nTotal rows found: " + rows.size());

        Set<String> uniqueData = new LinkedHashSet<>();

        for (WebElement row : rows) 
        {

            List<WebElement> columns = row.findElements(By.xpath(colXpath));
            StringBuilder rowText = new StringBuilder();

            for (WebElement col : columns) 
            {
                rowText.append(col.getText().trim()).append(" | ");
            }

            // Add row to Set (duplicates automatically removed)
            uniqueData.add(rowText.toString());
        }

        return uniqueData;
    }	
}
