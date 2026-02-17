package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FuleUploadDownloadExample 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://www.tutorialspoint.com/selenium/practice/upload-download.php");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Define locator for file upload element
        By fileUploadInput = By.id("uploadfile");
        Thread.sleep(5000);
        
        // Step 5: Provide file path (update this path as per your system)
        String filePath = "C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop";
        Thread.sleep(5000);
        
        // Step 6: Download file
        driver.findElement(By.xpath("//*[@id='downloadButton']"));
        Thread.sleep(5000);
        
        // Step 7: Close browser
        driver.quit(); 
        System.out.println("File upload and download completed successfully");

	}

}
