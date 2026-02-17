package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SelectMutipuleValuesInDropDown 
{
	public static void main(String[] args) throws InterruptedException 
	{
		BrowserUtility brUtil = new BrowserUtility();
        WebDriver driver = brUtil.launchBrowser("chrome");
        

        brUtil.lunchUrl("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        Thread.sleep(2000); // allow page to load

        ElementUtil eleUtil = new ElementUtil(driver);

        // Locators
        By dropdownLocator = By.id("justAnInputBox");
        By optionsLocator = By.cssSelector("span.comboTreeItemTitle");

        // Single selection
        System.out.println("Single selection mode:");
        eleUtil.handleComboTreeSelection("single", dropdownLocator, optionsLocator);
        Thread.sleep(2000);

        // Multiple selection
        System.out.println("Multiple selection mode:");
        eleUtil.handleComboTreeSelection("multiple", dropdownLocator, optionsLocator);
        Thread.sleep(2000);

        // Select all
        System.out.println("Select All mode:");
        eleUtil.handleComboTreeSelection("all", dropdownLocator, optionsLocator);
        Thread.sleep(2000);

        brUtil.quitBrowser();
        System.out.println("ComboTree Dropdown Test Completed Successfully!");
	
		/*WebDriver driver= new ChromeDriver();
		driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/#google_vignette");
		Thread.sleep(5000);
		driver.findElement(By.id("justAnInputBox")).click();
		Thread.sleep(5000);
		List<WebElement> listItems= driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
		Thread.sleep(5000);
		String s[]= {"choice 2", "choice 2 1", "choice 3", "choice 4", "choice 5", "choice 7"};
		int i=0;
		boolean flag=false;
		for(WebElement e:listItems)
		{
			if(!(e.getText().equals("")))
			{
				//Single Item
//				if(e.getText().equals("cho"))
//				{
//					e.click();
//					flag=true;
//				}
				//Multiple items
				if(e.getText().equals(s[i]))
				{
					e.click();
					i++;
					flag=true;
				}
				// All Item Selection
				//e.click();
//				if(e.getText().equals("cho"))
//				{
//					
//				}
			}	
		}
		if(flag==false)
		{
			System.out.println("Element not found");
		}
		Thread.sleep(5000);
		driver.quit();*/

	}			
}


