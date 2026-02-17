package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePagination 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
						        
		//  Open webpage
		driver.get("http://scrapingcourse.com/ecommerce/");
		System.out.println("Page opened.");
						        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5000));
						        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// Call the generic method and pass product name
        findProductAndOpen(driver, "Aeon Capri");
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");

	}
	
	// =====================================================================
    // Generic pagination search method (WooCommerce)
    // =====================================================================
    public static void findProductAndOpen(WebDriver driver, String productName) throws InterruptedException 
    {

        while (true) 
        {

            // 1. Check if product is present on current page
            if (driver.findElements(By.xpath("//h2[text()='" + productName + "']")).size() > 0) {

                driver.findElement(By.xpath("//h2[text()='" + productName + "']")).click();
                System.out.println("Product found and opened: " + productName);
                break;
            }

            // 2. If product not found, check if Next button exists
            if (driver.findElements(By.xpath("//a[@class='next page-numbers']")).size() == 0) {
                System.out.println("End of pages. Product not found.");
                break;
            }

            // 3. Check if Next button is disabled (WooCommerce: no disabled attribute, so check absence)
            WebElement nextBtn = driver.findElement(By.xpath("//a[@class='next page-numbers']"));

            // If next button is not clickable or not found further, stop
            if (!nextBtn.isDisplayed()) 
            {
                System.out.println("Next button unavailable. End of pages.");
                break;
            }

            // 4. Click Next page
            nextBtn.click();
            Thread.sleep(1500);
        }
    }

}
