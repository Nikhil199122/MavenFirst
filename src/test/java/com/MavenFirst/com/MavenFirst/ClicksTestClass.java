package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClicksTestClass 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser using BrowserUtility
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://www.tutorialspoint.com/selenium/practice/buttons.php");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Locators for buttons
        By clickMeBtn = By.xpath("//button[text()='Click Me']");
        By rightClickBtn = By.xpath("//button[text()='Right Click Me']");
        By doubleClickBtn = By.xpath("//button[text()='Double Click Me']");
        
        // Step 5: Perform Actions
        ElementUtil.performAction(clickMeBtn, "click");
        Thread.sleep(2000);
        ElementUtil.performAction(rightClickBtn, "rightClick");
        Thread.sleep(5000);
        ElementUtil.performAction(doubleClickBtn, "doubleClick");
        Thread.sleep(2000);

        // Step 6: Close browser
        driver.quit();
	}
	
	/**
     * Generic method to perform click, right-click, or double-click using Actions class
     * @param locator - element locator
     * @param actionType - "click", "rightClick", or "doubleClick"
     */
    public static void performAction(By locator, String actionType) 
    {
        WebElement element = driver.findElement(locator);
        switch (actionType.toLowerCase()) 
        {
            case "click":
            	Actions act1 = new Actions(driver);
                act1.moveToElement(element).click().perform();
                System.out.println("Performed single click using Actions on: " + locator);
                break;

            case "rightclick":
            	Actions act2 = new Actions(driver);
                act2.moveToElement(element).contextClick().perform();
                System.out.println("Performed right click using Actions on: " + locator);
                break;

            case "doubleclick":
            	Actions act3 = new Actions(driver);
                act3.moveToElement(element).doubleClick().perform();
                System.out.println("Performed double click using Actions on: " + locator);
                break;

            default:
                System.out.println("Invalid action type. Use: click, rightClick, or doubleClick");
        }
    }

}
