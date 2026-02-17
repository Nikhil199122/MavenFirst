package com.MavenFirst.com.MavenFirst;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AmazonSearchSuggestionTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        driver.manage().window().maximize();
        
        // Launch Amazon India
        brUtil.lunchUrl("https://www.amazon.in/");
        Thread.sleep(10);
        
        // Locate the search box and type "ear"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("ear");
        
        // Wait for suggestions to load
        Thread.sleep(5000);
        
        // Locate all suggestion elements
        List<WebElement> suggestions = driver.findElements(By.xpath("//div[@class='s-suggestion-container']"));

        System.out.println("Total suggestions found: " + suggestions.size());
        System.out.println("--------------------------------------------------");
        
        // Print each suggestion text
        for (WebElement option : suggestions) 
        {
            System.out.println(option.getText());
        }

        System.out.println("--------------------------------------------------");
        System.out.println("All suggestions printed successfully.");

        brUtil.quitBrowser();

	}

}
