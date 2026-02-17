package com.MavenFirst.com.MavenFirst;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PrintWebTableData 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the url
        String url = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
        driver.get(url);
        System.out.println("Page opened successfully");
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Create WebDriverWait Object        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        // Step 4: Print table data
        printTableData("//table[@id='customers']//tr","./th | ./td");
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}
	
	// ----------------------------------------------------
    // GENERIC METHOD → PRINT WEB TABLE DATA
    // ----------------------------------------------------
    public static void printTableData(String rowXpath, String colXpath) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        // Wait until table is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//table[@id='customers']")));

        // Fetch all rows (header + data rows)
        List<WebElement> rows = driver.findElements(By.xpath(rowXpath));
        System.out.println("Total rows found: " + rows.size() + "\n");

        // Loop through rows
        for (WebElement row : rows) 
        {
            List<WebElement> columns = row.findElements(By.xpath(colXpath));

            // Print each cell
            for (WebElement col : columns) 
            {
                System.out.print(col.getText() + " | ");
            }
            System.out.println();
        }
    }
}
