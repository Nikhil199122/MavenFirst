package com.MavenFirst.com.MavenFirst;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintWebTable 
{
	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Scroll to table
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,600)");

        // Locate all rows (second table)
        List<WebElement> rows = driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr"));

        int rowCount = rows.size();

        System.out.println("------- Table Data -------");

        // Loop through rows
        for (int i = 1; i <= rowCount; i++) 
        {
            // Locate columns for each row
            List<WebElement> columns = driver.findElements(By.xpath("(//table[@id='product'])[2]/tbody/tr[" + i + "]/td"));

            // Loop through columns
            for (WebElement col : columns) 
            {
                System.out.print(col.getText() + "   ");
            }

            System.out.println();
        }
        driver.quit();
    }
}

