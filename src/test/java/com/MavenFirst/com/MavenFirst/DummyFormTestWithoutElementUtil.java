package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DummyFormTestWithoutElementUtil 
{

	public static void main(String[] args) throws InterruptedException 
	{

        // Initialize browser utility
        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        driver.manage().window().maximize();

        // Open page
        brUtil.lunchUrl("https://selectorshub.com/xpath-practice-page/");
        Thread.sleep(2000); // wait for page to load

        // Fill out the form directly
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Enter email']"));
        email.sendKeys("testuser@example.com");

        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
        password.sendKeys("Test@123");

        WebElement company = driver.findElement(By.xpath("//input[@placeholder='Enter your company']"));
        company.sendKeys("TechCorp");

        WebElement mobile = driver.findElement(By.xpath("//input[@placeholder='Enter your mobile number']"));
        mobile.sendKeys("9876543210");

        WebElement country = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/div[1]/div/div/div/div[3]/label/input"));
        country.sendKeys("India");
        Thread.sleep(5000); // wait for page to load

        // Click submit
        WebElement submitBtn = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/button"));
        submitBtn.click();
        Thread.sleep(5000);
        
        WebElement text= driver.findElement(By.xpath("//*[@id=\"inp_val\"]"));
        text.sendKeys("Mango");
        Thread.sleep(5000); // wait for page to load
        
        // Click download link
        WebElement downloadlink = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/span/a"));
        downloadlink.click();
        Thread.sleep(5000); // wait for page to load
        
        // Click  SelectorsHub Youtube Channel
        WebElement content = driver.findElement(By.xpath("//*[@id=\"content\"]/div[2]/div/div[2]/div/div[1]/div[2]/div/div/div/a[1]"));
        content.click();
        Thread.sleep(5000); // wait for page to load
        
        // Closed the Browser
        brUtil.quitBrowser();
	}

}
