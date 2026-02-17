package com.MavenFirst.com.MavenFirst;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pagination 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
				        
		//  Open webpage
		driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=product/category&path=57_20");
		System.out.println("Page opened.");		
		Thread.sleep(5000);
				        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// ---------------------------
        // PAGE 7 USING YOUR NEW XPATH
        // ---------------------------
        String page7 = "//*[@id=\"entry_212409\"]/div/div[1]/ul/li[7]/a";
        clickPagination(driver, page7);
        System.out.println("Now on Page 7");

        Thread.sleep(5000);

        // -------------
        // CLICK PAGE 3
        // -------------
        String page3 = "//*[@id=\"entry_212409\"]/div/div[1]/ul/li[3]/a";
        clickPagination(driver, page3);
        System.out.println("Now on Page 3");

        Thread.sleep(5000);

        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}
	// Generic method to click pagination links
    public static void clickPagination(WebDriver driver, String xpath) 
    {
        WebElement page = driver.findElement(By.xpath(xpath));
        page.click();
        System.out.println("Clicked page using XPath: " + xpath);
    }
}
