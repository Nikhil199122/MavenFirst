package com.MavenFirst.com.MavenFirst;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class ReadTableData 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        Thread.sleep(5000);

        // Locate all rows (excluding header)
        List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr"));

        int rowCount = rows.size();
        int colCount = driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr[1]/th")).size();

        System.out.println("Total Rows: " + (rowCount - 1));
        System.out.println("Total Columns: " + colCount);
        System.out.println("----------- Table Data -----------");

        // Loop through rows
        for (int i = 2; i <= rowCount; i++) 
        {

            // Loop through columns
            for (int j = 1; j <= colCount; j++) 
            {

                String data = driver.findElement(By.xpath("//table[@name='BookTable']/tbody/tr[" + i + "]/td[" + j + "]")).getText();

                System.out.print(data + " | ");
            }
            System.out.println();
        }

        driver.quit();

	}

}
