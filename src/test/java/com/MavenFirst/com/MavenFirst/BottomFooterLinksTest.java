package com.MavenFirst.com.MavenFirst;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BottomFooterLinksTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch the browser using BrowserUtility
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open the Freshworks website
        brUtil.lunchUrl("https://www.freshworks.com/");
        Thread.sleep(3000);
        
        // Step 3: Create an instance of ElementUtility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4:Single XPath for all bottom footer links
        By bottomFooterLinks = By.xpath("//*[@id='__next']/footer/div/div[4]/ul/li/a");
        
        // Step 5:Use the generic method for this section
        List<String> footerTexts = eleUtil.getSectionLinksText(bottomFooterLinks, "Bottom Footer");
        
        // Step 6:Print output
        System.out.println("Bottom Footer Links:");
        if (footerTexts.isEmpty()) 
        {
            System.out.println("No footer links found. Check XPath or scroll down.");
        } else 
        {
            for (String text : footerTexts) 
            {
                System.out.println(text);
            }
        }

        // Step 7: Close the browser
        brUtil.quitBrowser();

	}

}
