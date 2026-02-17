package com.MavenFirst.com.MavenFirst;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;


public class ShadowDomExample 
{
	static WebDriver driver;
	static WebDriverWait wait;
	public static void main(String[] args) 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        //  Open webpage
        driver.get("https://dev.automationtesting.in/shadow-dom");
        System.out.println("Page opened.");
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        //  Initialize Element Utility
        ElementUtil eu = new ElementUtil(driver);
        
     // ---------------------------------------------
        // Using Generic Javascript shadow DOM method
        // ---------------------------------------------
        WebElement single = getShadowElement(
                "#shadow-root",
                "#shadow-element"
        );

        WebElement nested = getShadowElement(
                "#shadow-root",
                "#inner-shadow-dom",
                "#nested-shadow-element"
        );

        WebElement multiNested = getShadowElement(
                "#shadow-root",
                "#inner-shadow-dom",
                "#nested-shadow-dom",
                "#multi-nested-shadow-element"
        );

        System.out.println(single.getText());
        System.out.println(nested.getText());
        System.out.println(multiNested.getText());

        // ---------------------------------------------
        // Using SearchContext (Optional, same as your code)
        // ---------------------------------------------
        SearchContext sc = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
        WebElement s1 = sc.findElement(By.cssSelector("#shadow-element"));
        System.out.println(s1.getText());

        SearchContext sc1 = sc.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
        WebElement s2 = sc1.findElement(By.cssSelector("#nested-shadow-element"));
        System.out.println(s2.getText());

        SearchContext sc2 = sc1.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
        WebElement s3 = sc2.findElement(By.cssSelector("#multi-nested-shadow-element"));
        System.out.println(s3.getText());
 
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");       
	}
	
	// ================================================================
    // Generic Shadow DOM method (unlimited nested root support)
    // First argument = host
    // remaining = nested shadow elements / final element
    // ================================================================
    public static WebElement getShadowElement(String... selectors) {
        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script =
                "let el = document.querySelector(arguments[0]);" +
                "for (let i = 1; i < arguments.length; i++) {" +
                "    el = el.shadowRoot.querySelector(arguments[i]);" +
                "}" +
                "return el;";

        return (WebElement) js.executeScript(script, (Object[]) selectors);
    }
	
}
	
