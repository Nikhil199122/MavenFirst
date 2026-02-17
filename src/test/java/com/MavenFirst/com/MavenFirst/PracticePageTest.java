package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PracticePageTest
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException	 
	{
		// Step 1:Launch browser using your BrowserUtility
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: Launch browser and open Practice Page
        brUtil.lunchUrl("https://rahulshettyacademy.com/AutomationPractice/");
        Thread.sleep(5000);
        
        // Step 3:Create an instance of ElementUtility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // -----------------------------------------
        // RADIO BUTTON EXAMPLE
        // -----------------------------------------
        By radioBtn = By.xpath("//input[@value='radio2']");
        ElementUtil.doClick(radioBtn);
        System.out.println("Selected Radio Button 2.");
        Thread.sleep(5000);
        
        // -----------------------------------------
        // CHECKBOX EXAMPLE
        // -----------------------------------------
        By checkbox1 = By.id("checkBoxOption1");
        By checkbox2 = By.id("checkBoxOption2");
        ElementUtil.doClick(checkbox1);
        ElementUtil.doClick(checkbox2);
        System.out.println("Checked Option 1 and Option 2.");
        Thread.sleep(5000);
        
        // -----------------------------------------
        // DROPDOWN EXAMPLE
        // -----------------------------------------
        By dropdown = By.id("dropdown-class-example");
        ElementUtil.selectDropdownByVisibleText(dropdown, "Option2");
        System.out.println("Selected Option 2 from dropdown.");
        Thread.sleep(5000);
        
        // -----------------------------------------
        // ALERT EXAMPLE
        // -----------------------------------------
        By nameInput = By.id("name");
        ElementUtil.doSendKeys(nameInput, "Nikhil");
        System.out.println("Entered name for alert.");
        Thread.sleep(5000);
        
        By alertButton = By.id("alertbtn");
        ElementUtil.doClick(alertButton);
        Thread.sleep(5000);
        
        // Handle Alert
        driver.switchTo().alert().accept();
        System.out.println("Alert handled successfully.");
        Thread.sleep(5000);
        
        // -----------------------------------------
        // WINDOW HANDLING EXAMPLE
        // -----------------------------------------
        String mainWindow = driver.getWindowHandle();
        By openWindowButton = By.id("openwindow");
        ElementUtil.doClick(openWindowButton);
        System.out.println("Opened new window.");

        for (String handle : driver.getWindowHandles()) 
        {
            driver.switchTo().window(handle);
        }
        System.out.println("Switched to new window. Title: " + driver.getTitle());
        Thread.sleep(5000);
        
        // Close new window and switch back
        driver.close();
        driver.switchTo().window(mainWindow);
        System.out.println("Returned to main window.");
        Thread.sleep(5000);
        
        // -----------------------------------------
        // FINISH TEST
        // -----------------------------------------
        brUtil.quitBrowser();
        System.out.println("Test completed successfully!");
        
	}

}
