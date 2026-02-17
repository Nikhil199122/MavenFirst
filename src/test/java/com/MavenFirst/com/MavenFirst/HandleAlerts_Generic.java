package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HandleAlerts_Generic 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Open target website
        brUtil.lunchUrl("https://testautomationpractice.blogspot.com/");
        Thread.sleep(5000);
        
        // Step 3: Create ElementUtility object
        ElementUtil eleUtil = new ElementUtil(driver);
              
        // Simple Alert
        clickAlert("//*[@id=\"alertBtn\"]");
        acceptAlert();
        Thread.sleep(5000);
        

        // Confirmation Alert
        clickAlert("//*[@id=\"confirmBtn\"]");
        dismissAlert();
        Thread.sleep(5000);
        

        // Prompt Alert
        clickAlert("//*[@id=\"promptBtn\"]");
        sendTextAndAccept("Nikhil Shahane");
        Thread.sleep(5000);
        
        //Close browser
        driver.quit();

	}
	// -------- Generic Methods --------

	public static void clickAlert(String xpath) throws InterruptedException {
        driver.findElement(By.xpath(xpath)).click();
        Thread.sleep(2000);
    }

    public static void acceptAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.accept();
    }

    public static void dismissAlert() {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
    }

    public static void sendTextAndAccept(String text) {
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.sendKeys(text);
        alert.accept();
    }

}
