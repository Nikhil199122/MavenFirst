package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Selenium {

	public static void main(String[] args) throws InterruptedException 
	
	{
		WebDriver driver=new ChromeDriver(); // Top Casting
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
