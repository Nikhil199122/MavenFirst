package com.MavenFirst.com.MavenFirst;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PrintAllImagesSrcTest 
{

	public static void main(String[] args) 
	{
		BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        // Launch Amazon India
        brUtil.lunchUrl("https://www.amazon.in/");
        // Maximize window after launching
        driver.manage().window().maximize();
        // Get all image elements on the page
        List<WebElement> imageList = driver.findElements(By.tagName("img"));
        System.out.println("Total number of images on Amazon page: " + imageList.size());
        System.out.println("-------------------------------------------------");
        // Loop through each image and print the 'src' attribute
        for (WebElement img : imageList) 
        {
            String srcValue = img.getAttribute("src");
            
            if (srcValue != null && !srcValue.trim().isEmpty()) 
            {
                System.out.println(srcValue);
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("All image src attributes printed successfully.");
        // Close browser
        brUtil.quitBrowser();

	}

}
