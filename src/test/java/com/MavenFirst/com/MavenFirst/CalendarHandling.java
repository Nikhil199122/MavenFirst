package com.MavenFirst.com.MavenFirst;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarHandling 
{
	static WebDriver driver;
    static WebDriverWait wait;
	public static void main(String[] args) 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
				        
		//  Open webpage
		driver.get("https://www.goibibo.com/");
		System.out.println("Page opened.");
				
		// Create WebDriverWait Object        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		// Close popup if appears
        try {
            driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
        } catch (Exception e) {
            // ignore if popup not present
        }

        // Call generic method
        selectDate("11", "December 2025");
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}
	
	// ============================================================
    //      GENERIC METHOD TO SELECT ANY DATE ON GOIBIBO
    // ============================================================
    public static void selectDate(String day, String monthYear) {

        // 1. Click the departure field
        WebElement departureBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//p[text()='Departure']/parent::div")
        ));
        departureBox.click();

        // 2. Calendar appears – wait for it
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[contains(@class,'DayPicker')]")
        ));

        // 3. Loop until target month appears
        while (true) {

            // Read visible month-year
            String currentMonth = driver.findElement(
                    By.xpath("(//div[@class='DayPicker-Caption']/div)[1]")
            ).getText();

            // If month matches → break loop
            if (currentMonth.equalsIgnoreCase(monthYear)) {
                break;
            }

            // Click next button
            WebElement nextBtn = driver.findElement(
                    By.xpath("//span[contains(@class,'DayPicker-NavButton--next')]")
            );
            nextBtn.click();
        }

        // 4. Click the required day
        WebElement selectDay = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[contains(@class,'DayPicker-Day')]//p[text()='" + day + "']")
        ));
        selectDay.click();

        System.out.println("Selected Date: " + day + " " + monthYear);
    }
}
