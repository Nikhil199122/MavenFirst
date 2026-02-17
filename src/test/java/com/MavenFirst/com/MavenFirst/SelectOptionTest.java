package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class SelectOptionTest {

    public static void main(String[] args) throws InterruptedException {

        BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        driver.manage().window().maximize();

        // Step 1: Launch the Login Page
        brUtil.lunchUrl("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
        Thread.sleep(2000);

        // Step 2: Enter login credentials
        driver.findElement(By.id("input-email")).sendKeys("nikhil@gmail.com");
        driver.findElement(By.id("input-password")).sendKeys("Test@123");

        // Step 3: Click Login button
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        System.out.println(" Logged in successfully!");

        Thread.sleep(5000);

        // Step 4: Click on "1 item(s)" in the cart
        driver.findElement(By.xpath("//span[contains(text(),'1 item(s)')]")).click();
        System.out.println("Clicked on 1 item(s) link in the cart");

        Thread.sleep(5000);
        
        // Step 5: Click on Checkout button
        driver.findElement(By.xpath("//a[contains(.,'Checkout')]")).click();
        System.out.println(" Checkout button clicked successfully!");
        Thread.sleep(5000);
        
        // Step 6:Estimate Shipping & Taxes.
        driver.findElement(By.xpath("//a[contains(text(),'Estimate Shipping')]")).click();
        System.out.println("Estimate Shipping & Taxes!");
        Thread.sleep(5000);

        // Step 7: Select Country from dropdown
        WebElement countryDropdown = driver.findElement(By.id("input-country"));
        Select selectCountry = new Select(countryDropdown);
        Thread.sleep(5000);
        
        selectCountry.selectByVisibleText("United Kingdom");
        Thread.sleep(5000);
        System.out.println("Selected Country: " + selectCountry.getFirstSelectedOption().getText());

        selectCountry.selectByValue("99"); // India
        Thread.sleep(5000);
        System.out.println("Selected Country: " + selectCountry.getFirstSelectedOption().getText());

        selectCountry.selectByIndex(5);
        Thread.sleep(5000);
        System.out.println("Selected Country: " + selectCountry.getFirstSelectedOption().getText());
        
        brUtil.quitBrowser();
    }
}