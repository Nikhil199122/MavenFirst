package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaginationExample 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
				        
		//  Open webpage
		driver.get("https://datatables.net/examples/basic_init/zero_configuration.html");
		System.out.println("Page opened.");
				        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
				        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		 // Calling generic pagination method
        findAndClickRow(driver, "Caesar Vance");
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");

	}
	
	// =================================================================
    // Generic method to locate a row by text on paginated tables
    // =================================================================
    public static void findAndClickRow(WebDriver driver, String searchText) throws InterruptedException 
    {

        while (true) 
        {

            // 1. Check if text exists on the current page
            if (driver.findElements(By.xpath("//td[text()='" + searchText + "']")).size() > 0) 
            {

                // Click the first column cell of that row
                driver.findElement(By.xpath("//td[text()='" + searchText + "']")).click();

                System.out.println("Found and clicked: " + searchText);
                break;
            }

            // 2. If not found, check if Next button is disabled
            WebElement nextBtn = driver.findElement(By.xpath("//a[@id='example_next']"));

            String nextBtnClass = nextBtn.getAttribute("class");

            if (nextBtnClass.contains("disabled")) 
            {
                System.out.println("End of page. Data not found.");
                break;
            }

            // 3. If enabled, click Next and continue loop
            nextBtn.click();
            Thread.sleep(1500);
        }
    }
}
