package com.MavenFirst.com.MavenFirst;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationLastPageData 
{

	public static void main(String[] args) throws InterruptedException 
	{
		WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        Thread.sleep(2000);

        // Get all pagination links
        List<WebElement> pages = driver.findElements(By.xpath("//ul[@id='pagination']//a"));

        int totalPages = pages.size();
        System.out.println("Total Pages: " + totalPages);

        // Click pages one by one
        for (int i = 0; i < totalPages; i++) 
        {

            pages = driver.findElements(By.xpath("//ul[@id='pagination']//a"));
            pages.get(i).click();
            Thread.sleep(2000);

            System.out.println("Clicked Page: " + (i + 1));
        }

        // Now we are on LAST page
        System.out.println("---- Last Page Table Data ----");

        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr"));

        for (int i = 1; i <= rows.size(); i++) 
        {

            List<WebElement> cols = driver.findElements(By.xpath("//table[@id='productTable']/tbody/tr[" + i + "]/td"));

            for (WebElement col : cols) 
            {
                System.out.print(col.getText() + "   ");
            }
            System.out.println();
        }

        driver.quit();

	}

}
