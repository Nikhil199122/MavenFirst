package com.MavenFirst.com.MavenFirst;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterLinksTest 
{
	public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1:Launch browser using your BrowserUtility
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2:Open the Freshworks website
        brUtil.lunchUrl("https://www.freshworks.com/");
        Thread.sleep(3000);
        
        // Step 3:Create an instance of ElementUtility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Get links for multiple footer sections dynamically
        String[] footerSections = { "Company", "Support & Success", "Products"  };

        for (String section : footerSections) 
        {
            System.out.println("----- " + section + " Section -----");
            List<String> links = eleUtil.getFooterLinksBySection(section);

            if (links.isEmpty()) 
            {
                System.out.println("No links found for: " + section);
            } else 
            {
                for (String text : links) 
                {
                    System.out.println(text);
                }
            }
            System.out.println();
        }
        
        // Step 5: Close browser
        brUtil.quitBrowser();
    }
	 // Generic method to get footer links by section name
    public List<String> getFooterLinksBySection(String sectionName) 
    {
        String dynamicXPath = "//footer//div[contains(.,'" + sectionName + "')]/following-sibling::ul//a";
        List<WebElement> links = driver.findElements(By.xpath(dynamicXPath));
        List<String> sectionLinks = new ArrayList<>();

        for (WebElement link : links) 
        {
            String text = link.getText().trim();
            if (!text.isEmpty()) 
            {
                sectionLinks.add(text);
            }
        }

        return sectionLinks;
    }

}
