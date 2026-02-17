package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DropdownGenericTest 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");

        // Step 2: Open webpage
        brUtil.lunchUrl("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(2000);

        // Step 3: Initialize utility
        ElementUtil eleUtil = new ElementUtil(driver);

        // Step 4: Locator for dropdown
        By carDropdown = By.xpath("//select[@id='cars']");

        // Step 5: Select option using generic method
        eleUtil.selectDropdownByVisibleText(carDropdown, "Audi");

        // Step 6: Verify selected value
        String selectedCar = eleUtil.getSelectedOptionText(carDropdown);
        System.out.println("Selected Car: " + selectedCar);

        Thread.sleep(3000);
        brUtil.quitBrowser();

        System.out.println("Dropdown selection test completed successfully.");


	}

}
