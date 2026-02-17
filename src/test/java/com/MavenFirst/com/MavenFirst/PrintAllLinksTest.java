package com.MavenFirst.com.MavenFirst;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import com.framework.utils.BrowserUtility;
public class PrintAllLinksTest 
{

	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtility brUtil = new BrowserUtility();
		WebDriver driver = brUtil.launchBrowser("chrome");
		// Launch the login page
        brUtil.lunchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        // Maximize window after launching
        driver.manage().window().maximize();
        // Find all links on the page
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("Total number of links on the page: " + linksList.size());
        System.out.println("-------------------------------------------------");
        // Loop through each link and print its text and URL
        for (WebElement link : linksList) 
        {
            String linkText = link.getText().trim();
            String linkHref = link.getAttribute("href");
            // Avoid printing empty or null links
            if (!linkText.isEmpty() && linkHref != null) 
            {
                System.out.println(linkText + " --> " + linkHref);
            }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("All links printed successfully.");
        // Close browser
        brUtil.quitBrowser();
	}

}
