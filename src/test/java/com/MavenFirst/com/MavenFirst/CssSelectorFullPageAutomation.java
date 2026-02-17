package com.MavenFirst.com.MavenFirst;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelectorFullPageAutomation 
{
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch browser
        BrowserUtility brUtil = new BrowserUtility();
        driver = brUtil.launchBrowser("chrome");
        
        // Step 2: // Open webpage
        String url = "https://www.hyrtutorials.com/p/css-selectors-practice.html";
        driver.get(url);
        System.out.println("Opened Web Table Page.");
        Thread.sleep(5000);
        
        // Step 3: Initialize Element Utility
        ElementUtil eleUtil = new ElementUtil(driver);
        
        // ----------- TEXT INPUT FIELDS -----------
        type(By.cssSelector("input#firstName"), "John"); //First Name
        Thread.sleep(5000);
        type(By.cssSelector("input#lastName"), "Doe"); //Last Name
        Thread.sleep(5000);
        type(By.cssSelector("input.gender"), "Male");   // Gender
        Thread.sleep(5000);
        type(By.cssSelector("input.city"), "Pune"); //City
        Thread.sleep(5000);
        type(By.cssSelector(" input[type=text]:nth-child(5)"), "India"); //Country
        Thread.sleep(5000);
       
        // ----------- ADDED FIELDS BELOW -----------

        // 1. Security Question
        type(By.cssSelector("input[placeholder='Enter your security question']"), 
                "What is your nick name?");
        Thread.sleep(5000);

        // 2. Security Answer
        type(By.cssSelector("input[placeholder='Enter your security answer']"), 
                "Tiger");
        Thread.sleep(5000);

        // 3. Verify Personal Details
        type(By.cssSelector("input[placeholder='Verify your personal details']"),"Verified"); 
        Thread.sleep(5000);
        
        // ----------- DROPDOWN USING CSS -----------
        click(By.cssSelector("div.container > select > option:nth-child(2)")); // sendKeys works for dropdowns
        Thread.sleep(5000);
        click(By.cssSelector("div.container > select > option:nth-child(3)"));
        Thread.sleep(5000);

        // ----------- CHECKBOX -----------
        click(By.cssSelector(" input.confirm"));   // "Confirm Code" checkbox
        Thread.sleep(5000);

        // ----------- BUTTONS -----------
        click(By.cssSelector(" div.container > div > input:nth-child(2)"));   // click button
        Thread.sleep(5000);
        click(By.cssSelector("div.container > div > input:nth-child(3)"));      // click submit
        Thread.sleep(5000);
        click(By.cssSelector("#button3"));
        Thread.sleep(5000);
        
        // ----------- DROPDOWN OPTIONS USING CSS -----------

        // Option 2
        click(By.cssSelector("div.container > div > select > option:nth-child(2)")); 
        Thread.sleep(5000);
      
        //--------------Click Here Using CSS-------------------
        click(By.cssSelector("div.container > a:nth-child(17)"));
        click(By.cssSelector(" div > form > p.mytest"));
        
        System.out.println("All fields filled using CSS Selectors successfully.");
        Thread.sleep(5000);
        
        //Close browser
        driver.quit();
        System.out.println("Test completed successfully!");
	}
	
	// ----------- GENERIC METHODS -----------

	   // ----------- GENERIC METHODS -----------
    public static void type(By locator, String value) 
    {
        WebElement ele = driver.findElement(locator);
        ele.clear();
        ele.sendKeys(value);
    }
    
    public static void click(By locator) 
    {
        driver.findElement(locator).click();
    }
}
