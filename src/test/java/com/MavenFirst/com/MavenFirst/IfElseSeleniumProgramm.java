package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IfElseSeleniumProgramm {

	public static void main(String[] args) throws InterruptedException 
	{
		//WebDriver driver=new ChromeDriver(); // Top Casting
		String browser="chrome";
		WebDriver driver=null;
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver=new FirefoxDriver();

		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.get("https://www.google.com/");
		Thread.sleep(5000);
		String actualTitle=driver.getTitle();
		//system.out.println(actualTitle);
		String expectedTitile=" google ";
		expectedTitile=expectedTitile.trim(); //"google"
		if(actualTitle.equalsIgnoreCase(expectedTitile))
		{
			System.out.println("pass");
		}
		else
		{
			System.out.println("fail");
		}
		
		driver.quit();

	}

}
