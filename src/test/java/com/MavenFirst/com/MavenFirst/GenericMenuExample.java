package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class GenericMenuExample 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Initialize browser utility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");

		// Launch Amazon India
		brUtil.lunchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(10);
		
        // Call generic method - pass tagname, parent menu, and child menu
        selectSubMenu("a", "Components", "Monitors (2)");
        Thread.sleep(5000);
        
        // closed Browser 
        driver.quit();
    }

    // Generic reusable getElement method
    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    // Generic submenu selection using Actions class
    public static void selectSubMenu(String tagname, String parentMenu, String childMenu) throws InterruptedException {

        // Create dynamic XPaths
        By parentTP = By.xpath("//" + tagname + "[text()='" + parentMenu + "']");
        By childT = By.xpath("//" + tagname + "[text()='" + childMenu + "']");
        // Hover on parent menu
        WebElement TP = getElement(parentTP);
        Actions act = new Actions(driver);
        act.moveToElement(TP).build().perform();
        Thread.sleep(2000);
        // Click on child menu
        WebElement T = getElement(childT);
        T.click();
        Thread.sleep(5000);

	}

}
