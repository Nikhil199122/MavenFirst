package com.MavenFirst.com.MavenFirst;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PrintDropdownOptions 
{

	public static void main(String[] args) 
	{
		WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

        // Locate dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));

        // Create Select object
        Select select = new Select(dropdown);

        // Get all options
        List<WebElement> options = select.getOptions();

        System.out.println("Dropdown options are:");

        // Print options
        for (WebElement option : options) 
        {
            System.out.println(option.getText());
        }

        driver.quit();
    }	
}
