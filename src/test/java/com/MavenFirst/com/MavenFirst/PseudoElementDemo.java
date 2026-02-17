package com.MavenFirst.com.MavenFirst;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PseudoElementDemo 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
				        
		//  Open webpage
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println("Page opened.");		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// Required field checks
		checkField(driver, "input-firstname", "firstname");
        checkField(driver, "input-lastname", "lastname");
        checkField(driver, "input-email", "email");
        checkField(driver, "input-telephone", "telephone");
        checkField(driver, "input-password", "password");
        checkField(driver, "input-confirm", "confirm");

        // NEW FIXED → Privacy Policy
        checkPrivacyPolicy(driver);
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}
	
	// =========================================================
    // GENERIC METHOD – CHECK FIELD (Pseudo + Empty Check)
    // =========================================================
    public static void checkField(WebDriver driver, String forAttribute, String fieldName) throws InterruptedException 
    {
        System.out.println("\n--- Checking: " + fieldName + " ---");
        String star = getPseudoContent(driver, forAttribute, "::before");
        System.out.println("Pseudo content: " + star);
        WebElement element = driver.findElement(By.name(fieldName));
        element.clear();
        // Sample input
        switch (fieldName) 
        {
            case "firstname":  element.sendKeys("Nikhil"); break;
            case "lastname":   element.sendKeys("Shahane"); break;
            case "email":      element.sendKeys("nshahane@gmail.com"); break;
            case "telephone":  element.sendKeys("8715647449"); break;
            case "password":   element.sendKeys("Nikhil@10"); break;
            case "confirm":    element.sendKeys("Nikhil@10"); break;
        }
        Thread.sleep(800);
        if (star.contains("*")) 
        {
            System.out.println("This field is required.");
            if (isBlank(element)) 
            {
                System.out.println("Field is blank → You must enter a value.");
            } else 
            {
                System.out.println("Value entered.");
            }
        } else 
        {
            System.out.println("This field is NOT required.");
        }
    }

    // =========================================================
    // GET PSEUDO ELEMENT (::before / ::after)
    // =========================================================
    public static String getPseudoContent(WebDriver driver, String forAttribute, String pseudoType) 
    {

        JavascriptExecutor js = (JavascriptExecutor) driver;

        String script =
                "var el = document.querySelector(\"label[for='" + forAttribute + "']\");"
                + "if(!el){return '';} "
                + "return window.getComputedStyle(el, \"" + pseudoType + "\").getPropertyValue('content');";

        String content = (String) js.executeScript(script);

        if (content != null && content.length() > 2) 
        {
            content = content.substring(1, content.length() - 1);
        }
        return content;
    }
    // =========================================================
    // CHECK IF FIELD IS BLANK
    // =========================================================
    public static boolean isBlank(WebElement element) 
    {
        String value = element.getAttribute("value");
        return value == null || value.trim().equals("");
    }

    // =========================================================
    // FIXED → CHECK PRIVACY POLICY CHECKBOX
    // =========================================================
    public static void checkPrivacyPolicy(WebDriver driver) throws InterruptedException 
    {

        System.out.println("\n--- Checking Privacy Policy Checkbox ---");
        WebElement checkbox = driver.findElement(By.name("agree"));
        if (!checkbox.isSelected()) 
        {
            System.out.println("Checkbox not selected → clicking");
            checkbox.click();
        } else 
        {
            System.out.println("Already selected");
        }
        Thread.sleep(800);
    }    
}
