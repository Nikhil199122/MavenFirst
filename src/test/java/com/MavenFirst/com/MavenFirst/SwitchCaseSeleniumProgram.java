package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SwitchCaseSeleniumProgram {

	public static void main(String[] args) throws InterruptedException 
	{
		// Set which browser to use
        String browser = "chrome";
        WebDriver driver = null;

        // Launch browser using switch-case
        switch (browser.toLowerCase()) {
            case "chrome":
                driver = new ChromeDriver();
                break;

            case "firefox":
                driver = new FirefoxDriver();
                break;

            case "edge":
                driver = new EdgeDriver();
                break;

            default:
                System.out.println("Invalid browser name");
                return;
        }

        // Open Google
        driver.get("https://www.google.com/");

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Get and compare titles
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google";

        if (actualTitle.equalsIgnoreCase(expectedTitle)) 
        {
            System.out.println("Pass");
        } else 
        {
            System.out.println("Fail");
        }

        // Close browser
        driver.quit();
        

	}

}
