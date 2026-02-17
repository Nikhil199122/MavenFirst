package com.MavenFirst.com.MavenFirst;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleLanguagesTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");

        // Launch Naveen Automation OpenCart page
        brUtil.lunchUrl("https://www.google.co.in/");
        Thread.sleep(10);
        // Locate all language elements (below search box)
        List<WebElement> languages = driver.findElements(By.xpath("//div[@id='SIvCob']/a"));
        
        System.out.println("Total languages found: " + languages.size());
        System.out.println("--------------------------------------------------");
        
     // Print each language text
        for (WebElement lang : languages) 
        {
            System.out.println(lang.getText());
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("All languages printed successfully.");

        brUtil.quitBrowser();

	}

}
