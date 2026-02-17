package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestFileUpload 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://omayo.blogspot.com/");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Define locator for file upload element
        By fileUploadInput = By.id("uploadfile");
        
        // Step 5: Provide file path (update this path as per your system)
        String filePath = "C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop";
        
        // Step 6: Call generic method to upload file
        ElementUtil.uploadFile(fileUploadInput, filePath);     
        System.out.println("File upload action performed successfully.");
        
        // Step 7: Wait to observe upload
        Thread.sleep(3000);
        
        // Step 8: Close browser
        driver.quit();  

	}
	
	// Generic method for uploading a file
    public static void uploadFile(By locator, String filePath) throws InterruptedException 
    {
        WebElement uploadInput = driver.findElement(locator);
        uploadInput.sendKeys(filePath);
        System.out.println("File path entered for upload: " + filePath);
        Thread.sleep(2000);
    }
}
