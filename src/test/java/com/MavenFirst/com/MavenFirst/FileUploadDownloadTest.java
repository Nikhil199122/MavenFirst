package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUploadDownloadTest 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://demoqa.com/upload-download");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Define locator for file upload element
        By fileUploadInput = By.id("uploadfile");
        
        // Step 5: Provide file path (update this path as per your system)
        String filePath = "C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop";

        // Step 6: Download file
        driver.findElement(By.xpath("//*[@id='downloadButton']"));
        Thread.sleep(5000);
        
        // Step 7: Close browser
        driver.quit(); 
        System.out.println("File upload and download completed successfully");
	}
	
    /**
     * Generic method to click a button (for download)
     */
    public static void clickDownloadButton(By locator) 
    {
        WebElement downloadBtn = driver.findElement(locator);
        downloadBtn.click();
        System.out.println("Download button clicked");
    }
}
