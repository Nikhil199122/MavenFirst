package com.MavenFirst.com.MavenFirst;

import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PinterestWindowHandling 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://www.pinterest.com/");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 3: Scroll to footer section (Quick Links)
        ElementUtil.scrollToBottom();
        System.out.println("Scrolled to footer section.");
        Thread.sleep(5000);
        
        // Step 4: Click on one Quick Link (for example, “Shop”)
        By shopLink = By.linkText("Shop");
        ElementUtil.doClick(shopLink);
        System.out.println("Clicked on 'Shop' link.");
        Thread.sleep(5000);
        
        // Step 5: Handle multiple windows
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        
        Iterator<String> it = allWindows.iterator();
        while (it.hasNext()) {
            String childWindow = it.next();
            if (!parentWindow.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println("Switched to new window.");
                System.out.println("New Window Title: " + driver.getTitle());
                Thread.sleep(5000);
                driver.close(); // Close the child tab
                System.out.println("Closed child window.");
            }
        }
        
        // Step 6: Switch back to parent
        driver.switchTo().window(parentWindow);
        System.out.println("Switched back to parent window.");
        Thread.sleep(5000);

        // Step 7: Close browser
        driver.quit(); 
        System.out.println("Browser closed successfully.");

	}

}
