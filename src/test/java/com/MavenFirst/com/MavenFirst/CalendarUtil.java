package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CalendarUtil 
{
	// =================================================================
    // Generic Method: Click previous button 'n' times using WebDriverWait
    // =================================================================
    public static void goToPreviousMonth(WebDriverWait wait, int times) 
    {

        By prevBtnLocator = By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']");

        for (int i = 0; i < times; i++) 
        {

            // Wait until previous button is clickable
            WebElement prevBtn = wait.until(
                    ExpectedConditions.elementToBeClickable(prevBtnLocator));

            // Click previous button
            prevBtn.click();
            System.out.println("Previous button clicked: " + (i + 1));
        }
    }
    
    static WebDriverWait wait;
 // ---------------------------------------------------------
    //               GENERIC METHOD (FINAL)
    // ---------------------------------------------------------
    public static void selectDateTime(String dateNumber,
                                      String hourValue,
                                      String minuteValue,
                                      String amPmValue) 
    {

        // 1. Open the Date-time picker
        WebElement dateTimeBox = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//*[@id='datetimepicker1']")));
        dateTimeBox.click();

        // 2. Click the date based on number
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[contains(@class,'flatpickr-day') and text()='" + dateNumber + "']")));
        date.click();

        // 3. Enter hour
        WebElement hour = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@class='numInput flatpickr-hour']")));
        hour.clear();
        hour.sendKeys(hourValue);

        // 4. Enter minute
        WebElement minute = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//input[@class='numInput flatpickr-minute']")));
        minute.clear();
        minute.sendKeys(minuteValue);

        // 5. Select AM / PM
        WebElement ampm = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//span[@class='flatpickr-am-pm']")));

        if (!ampm.getText().equalsIgnoreCase(amPmValue)) 
        {
            ampm.click();
        }

        System.out.println(
                "Selected: Date " + dateNumber + ", Time " + hourValue + ":" + minuteValue + " " + amPmValue);
    }
}
