package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BigBasketMenuTest 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        brUtil.lunchUrl("https://www.bigbasket.com/");
        System.out.println("BigBasket site opened successfully.");
        Thread.sleep(5000);

        // Step 2: Select menu and sub-menu (e.g., Beverages → Tea)
        selectSubMenu("Beverages", "Tea");
        Thread.sleep(4000);

        // Step 3: Close browser
        brUtil.quitBrowser();
        System.out.println("Test Completed Successfully.");
    }

    /**
     * Generic 3-level dynamic menu selector for BigBasket:
     * Step 1: Click "Shop by Category"
     * Step 2: Hover over main category (e.g., Beverages)
     * Step 3: Click sub-category (e.g., Tea)
     */
    public static void selectSubMenu(String mainMenu, String subMenu) throws InterruptedException {

        Actions act = new Actions(driver);

        // Step 1: Click on "Shop by Category" button
        WebElement shopByCategory = driver.findElement(By.xpath("//button[contains(.,'Shop by Category')]"));
        shopByCategory.click();
        System.out.println("Clicked on: Shop by Category");
        Thread.sleep(3000);

        // Step 2: Hover on main category (example: Beverages)
        WebElement mainCategory = driver.findElement(By.xpath("//a[contains(text(),'" + mainMenu + "')]"));
        act.moveToElement(mainCategory).build().perform();
        System.out.println("Hovered over main category: " + mainMenu);
        Thread.sleep(3000);

        // Step 3: Click on sub-category (example: Tea)
        WebElement subCategory = driver.findElement(By.xpath("//a[contains(text(),'" + subMenu + "')]"));
        act.moveToElement(subCategory).click().perform();
        System.out.println("Clicked on sub-category: " + subMenu);
        Thread.sleep(4000);
    }
}
