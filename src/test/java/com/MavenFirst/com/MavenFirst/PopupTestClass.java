package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class PopupTestClass 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser using BrowserUtility
        BrowserUtility brUtil = new BrowserUtility();
         driver = brUtil.launchBrowser("chrome");
         
         // Step 2: Open target website
         brUtil.lunchUrl("https://artoftesting.com/samplesiteforselenium");
         Thread.sleep(5000);
         
         // Step 3: Create ElementUtility object
         ElementUtil eleUtil = new ElementUtil(driver);
         
         // Step 4: Handle Alert Box
         ElementUtil.handleAlert("Alert", true); // Accept alert
         Thread.sleep(2000);
         
         // Step 5: Handle Confirm Box (choose dismiss for demo)
         ElementUtil.handleAlert("Confirm", false); // Dismiss confirm box
         Thread.sleep(2000);
         
         // Step 6: Perform Drag and Drop (Fixed locators)
         // Updated based on new page structure
         By source = By.xpath("//img[contains(@src,'artoftesting')]"); // image element
         By target = By.xpath("//div[@ondrop='drop(event)']");         // drop area
         ElementUtil.dragAndDrop(source, target);
         Thread.sleep(3000);

         // Step 7: Close browser
         driver.quit();

	}
	
	// Generic method to click a button using Actions
    public void clickElement(By locator) throws InterruptedException 
    {
        WebElement element = driver.findElement(locator);
        Actions act = new Actions(driver);
        act.moveToElement(element).click().build().perform();
        System.out.println("Clicked element: " + element.getText());
        Thread.sleep(2000);
    }

    // Generic method to handle alert and confirm boxes
    public void handleAlert(String alertType, boolean accept) throws InterruptedException {
        // Click the corresponding button based on alertType
        By button = By.xpath("//button[text()='Generate " + alertType + " Box']");
        driver.findElement(button).click();

        Thread.sleep(2000); // Wait for alert to appear

        // Switch to alert and handle based on type
        Alert alert = driver.switchTo().alert();
        System.out.println(alertType + " text: " + alert.getText());

        if (accept) {
            alert.accept();
            System.out.println(alertType + " accepted");
        } else {
            alert.dismiss();
            System.out.println(alertType + " dismissed");
        }
        Thread.sleep(2000);
    }

    // Generic method for drag and drop
    public void dragAndDrop(By sourceLocator, By targetLocator) throws InterruptedException {
        WebElement source = driver.findElement(sourceLocator);
        WebElement target = driver.findElement(targetLocator);
        Actions act = new Actions(driver);
        act.dragAndDrop(source, target).build().perform();
        System.out.println("Drag and drop completed successfully");
        Thread.sleep(2000);
    }
    

}
