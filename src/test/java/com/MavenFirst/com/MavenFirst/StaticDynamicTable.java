package com.MavenFirst.com.MavenFirst;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StaticDynamicTable 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the url
        String url = "https://testautomationpractice.blogspot.com/";
        driver.get(url);
        System.out.println("Page opened successfully");
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Create WebDriverWait Object        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Step 4: Print Static Web Table
        System.out.println("===== STATIC WEB TABLE =====");
        printTableData("//h2[contains(text(),'Static Web Table')]/following::table[1]");

        // Step 5: Print Dynamic Web Table
        System.out.println("\n===== DYNAMIC WEB TABLE =====");
        printTableData("//h2[contains(text(),'Dynamic Web Table')]/following::table[1]");
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}
	
	// ----------------------------------------------------
    // GENERIC METHOD → PRINT ANY WEB TABLE DATA
    // ----------------------------------------------------
    public static void printTableData(String tableXpath) 
    {
        // Locate table
        WebElement table = driver.findElement(By.xpath(tableXpath));

        // Get all rows from the table
        List<WebElement> rows = table.findElements(By.xpath(".//tr"));

        System.out.println("Total Rows: " + rows.size() + "\n");

        // Loop through each row
        for (WebElement row : rows) 
        {
            // Get all columns inside the row
            List<WebElement> cols = row.findElements(By.xpath(".//th | .//td"));

            // Print column data
            for (WebElement col : cols) 
            {
                System.out.print(col.getText() + "\t");
            }
            System.out.println();
        }
    }

}
