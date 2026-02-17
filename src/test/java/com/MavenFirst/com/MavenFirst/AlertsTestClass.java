package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AlertsTestClass
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://www.tutorialspoint.com/selenium/practice/alerts.php");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // Step 4: Define locators
        By simpleAlert = By.xpath("//button[text()='Alert']");
        By timedAlert = By.xpath("(//button[text()='Click Me'])[1]");
        By confirmAlert = By.xpath("(//button[text()='Click Me'])[2]");
        By promptAlert = By.xpath("(//button[text()='Click Me'])[3]");
        
        // Step 5: Handle all alerts using Actions
        System.out.println("=== Simple Alert ===");
        ElementUtil.handleAlertWithActions(simpleAlert, "accept", null);
        Thread.sleep(5000);
        
        System.out.println("=== Timed Alert ===");
        ElementUtil.handleAlertWithActions(timedAlert, "accept", null);
        Thread.sleep(5000);

        System.out.println("=== Confirm Alert (Dismiss) ===");
        ElementUtil.handleAlertWithActions(confirmAlert, "accept", null);
        Thread.sleep(5000);

        System.out.println("=== Prompt Alert (Send Keys + Accept) ===");
        ElementUtil.handleAlertWithActions(promptAlert, "accept", "Hello from Selenium!");
        Thread.sleep(5000);
        
        // Step 6: Close browser
        driver.quit();
	}
	
	/**
     * Generic method to handle all types of alerts using Actions class.
     * @param locator Button locator to trigger the alert
     * @param actionType "accept" or "dismiss"
     * @param inputText Optional text for prompt alert
     */
    public static void handleAlertWithActions(By locator, String actionType, String inputText) throws InterruptedException 
    {

        // Move to element and click using Actions
        WebElement alertButton = driver.findElement(locator);
        Actions act = new Actions(driver);
        act.moveToElement(alertButton).click().build().perform();
        System.out.println("Clicked button using Actions: " + locator);
        Thread.sleep(5000);
        
        // Switch to alert
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text: " + alert.getText());
        
        // Handle prompt alerts
        if (inputText != null) 
        {
            alert.sendKeys(inputText);
            System.out.println("Entered text: " + inputText);
        }
        
        // Accept or dismiss alert
        if (actionType.equalsIgnoreCase("accept"))
        {
            alert.accept();
            System.out.println("Alert accepted");
        } else if (actionType.equalsIgnoreCase("dismiss")) 
        {
            alert.dismiss();
            System.out.println("Alert dismissed");
        }
        Thread.sleep(1500);
    }

}
