package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;

public class HandleAlerts 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Launch browser
        WebDriver driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();

        // Scroll down
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1200)");

        // ---------- Simple Alert ----------
        driver.findElement(By.xpath("//button[text()='Simple Alert']")).click();
        Thread.sleep(2000);

        Alert a1 = driver.switchTo().alert();
        System.out.println(a1.getText());
        a1.accept();

        Thread.sleep(2000);

        // ---------- Confirmation Alert ----------
        driver.findElement(By.xpath("//button[text()='Confirmation Alert']")).click();
        Thread.sleep(2000);

        Alert a2 = driver.switchTo().alert();
        System.out.println(a2.getText());
        a2.dismiss();   // or a2.accept();

        Thread.sleep(2000);

        // ---------- Prompt Alert ----------
        driver.findElement(By.xpath("//button[text()='Prompt Alert']")).click();
        Thread.sleep(2000);

        Alert a3 = driver.switchTo().alert();
        System.out.println(a3.getText());
        a3.sendKeys("Nikhil Shahane");
        a3.accept();

        Thread.sleep(2000);

        driver.quit();
    }
      
}
