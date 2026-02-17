package com.MavenFirst.com.MavenFirst;

import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
public class TableDuplicateRemover 
{
	static WebDriver driver;
	public static void main(String[] args) 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the iframe practice page
        String url = "https://cosmocodelabs.com/automation-practice-webtable";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Call the generic method to get unique rows by "Country" (2nd column)
        List<List<String>> uniqueRows = getUniqueTableRows(driver, "//table[@id='countries']//tbody/tr", 2);
        
        // Step 4: Print unique table data
        System.out.println("Unique Table Data (" + uniqueRows.size() + " rows):");
        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("| %-8s | %-15s | %-15s | %-20s | %-20s |\n",
        		"Visited", "Country", "Capital(s)", "Currency", "Language");
        System.out.println("--------------------------------------------------------------------------");

        for (List<String> row : uniqueRows) 
        {
            System.out.printf("| %-8s | %-15s | %-15s | %-20s | %-20s |\n",
                    row.get(0), row.get(1), row.get(2), row.get(3), row.get(4));
        }
        
        // Step 5: Close browser
        brUtil.quitBrowser();
        System.out.println("Test completed successfully!");
	}
	
	/**
     * Generic method to extract unique rows from a table.
     *
     * @param driver       WebDriver instance
     * @param tableXPath   XPath of the table rows (e.g., "//table//tbody/tr")
     * @param uniqueColIdx Column index (1-based) used to check duplicates
     * @return List of unique row data
     */
    public static List<List<String>> getUniqueTableRows(WebDriver driver, String tableXPath, int uniqueColIdx) {

        // Step 1: Locate all rows
        List<WebElement> allRows = driver.findElements(By.xpath(tableXPath));
        System.out.println("Total Rows Found: " + allRows.size());

        // Step 2: Use Set to store unique identifiers
        Set<String> uniqueValues = new HashSet<>();
        List<List<String>> uniqueData = new ArrayList<>();

        // Step 3: Loop through each row
        for (int i = 0; i < allRows.size(); i++) 
        {
            WebElement row = allRows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));

            if (cells.size() > 0) 
            {
                // Extract the unique column text
                String key = cells.get(uniqueColIdx - 1).getText().trim();

                // If it's new, add the whole row
                if (uniqueValues.add(key)) 
                {
                    List<String> rowData = new ArrayList<>();
                    for (WebElement cell : cells) 
                    {
                        rowData.add(cell.getText().trim());
                    }
                    uniqueData.add(rowData);
                } else 
                {
                    System.out.println("Duplicate Ignored: " + key);
                }
            }
        }
        return uniqueData;
    }

}
