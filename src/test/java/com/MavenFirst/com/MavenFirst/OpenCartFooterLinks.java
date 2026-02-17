package com.MavenFirst.com.MavenFirst;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCartFooterLinks 
{

	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Launch Naveen Automation OpenCart page
        brUtil.lunchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        Thread.sleep(10);
        
        // Locate all footer links
        List<WebElement> footerLinks = driver.findElements(By.xpath("//footer//a"));
        
        System.out.println("Total footer links found: " + footerLinks.size());
        System.out.println("--------------------------------------------------");
        
        // Print each footer link text and href
        for (WebElement link : footerLinks) {
            String linkText = link.getText().trim();
            String linkHref = link.getAttribute("href");

            if (!linkText.isEmpty() && linkHref != null) {
                System.out.println(linkText + " --> " + linkHref);
            }
        }
        
        System.out.println("--------------------------------------------------");
        System.out.println("All footer links printed successfully.");

        brUtil.quitBrowser();
        
	}

}
