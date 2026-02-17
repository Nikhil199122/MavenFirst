package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;

public class PseudoElement 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
						        
		//  Open webpage
		driver.get("https://monika-chatterjee.github.io/Pseudo-Elements/sample-pseudo-element.html");
		System.out.println("Page opened.");		
		Thread.sleep(5000);
						        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// Locate the Submit button
        WebElement button = driver.findElement(By.cssSelector("button"));
        
		// Call generic pseudo-element method
        String pseudoText = getPseudoContent(driver, button, "::before");
        System.out.println("Pseudo-element text: " + pseudoText);

        // Call blank check method
        boolean blank = isBlank(button);
        System.out.println("Is button text blank? → " + blank);
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}
	 // =========================================================
    // GENERIC METHOD – Read Pseudo Element (::before / ::after)
    // =========================================================
    public static String getPseudoContent(WebDriver driver, WebElement element, String pseudoType) 
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // JS to fetch pseudo content
        String script =
                "return window.getComputedStyle(arguments[0], arguments[1])" +
                ".getPropertyValue('content');";

        String content = (String) js.executeScript(script, element, pseudoType);

        // Remove quotes returned by JS
        if (content != null && content.length() > 2) 
        {
            content = content.substring(1, content.length() - 1);
        }
        return content;
    }

    // =========================================================
    // GENERIC METHOD – Check if element text/value is blank
    // =========================================================
    public static boolean isBlank(WebElement element) 
    {
        String text = element.getText().trim();
        return text.isEmpty();
    }

}
