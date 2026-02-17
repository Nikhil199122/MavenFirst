package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BooksShadowDom 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
		        
		//  Open webpage
		driver.get("https://books-pwakit.appspot.com/");
		System.out.println("Page opened.");
		Thread.sleep(5000);	       
		        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		Thread.sleep(5000); // Wait for shadow DOM to load
		
		// Correct shadow DOM structure
        WebElement input = getShadowElementWithWait(
                "book-app",
                "#input"
        );

        input.sendKeys("I love to read books");
        System.out.println("Typed text in Shadow DOM successfully");
        Thread.sleep(5000);        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
        
	}
	// ============================================================
    // Generic shadow DOM locator with wait
    // ============================================================
    public static WebElement getShadowElementWithWait(String... selectors) throws InterruptedException 
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script =
                "let el = document.querySelector(arguments[0]);" +
                "if (!el || !el.shadowRoot) return null;" +
                "el = el.shadowRoot.querySelector(arguments[1]);" +
                "return el;";

        WebElement element = null;

        for (int i = 0; i < 10; i++) {
            element = (WebElement) js.executeScript(script, selectors[0], selectors[1]);
            if (element != null) return element;
            Thread.sleep(5000);
        }

        throw new RuntimeException("Shadow element not found: " + selectors[1]);
    }

}
