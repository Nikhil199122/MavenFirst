package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DifferenceQuitAndClose 
{
	WebDriver driver = null;
	public static void main(String[] args) throws InterruptedException
	{
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		String at= driver.getTitle();
		System.out.println(at);
		driver.quit();
 	}

}
