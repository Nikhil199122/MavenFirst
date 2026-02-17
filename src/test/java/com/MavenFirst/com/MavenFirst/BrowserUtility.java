package com.MavenFirst.com.MavenFirst;


import java.net.MalformedURLException;
import java.net.URL;
//import javax.management.RuntimeErrorException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserUtility 
{
	public WebDriver driver = null;
	// 1. launch the browser
	public WebDriver launchBrowser(String browserName) 
	{
        if (browserName.equalsIgnoreCase("chrome")) 
        {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        return driver;
    }
        
		/*if (browserName=="")
		{
			throw new FrameworkException("The browser name is blank please provide valid browser name");
		}
		if (browserName==null)
		{
			throw new FrameworkException("Browser name is null please provide valid name");
		}
		switch (browserName.toLowerCase()) {
		case "chrome":
			driver = new ChromeDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		case "edge":
			driver = new ChromeDriver();
			break;
		default:
			throw new FrameworkException("Please provide valid browser name");
			//System.out.println("Please pass the correct browser name");
		}
		// here it returns the driver
		return driver;
	}*/
	
	// 2. lunchUrl method
	public void lunchUrl(String Url) {
		if (Url==null)
		{
			throw new FrameworkException ("URL is null please provide valid URL");
		}
		if (Url=="")
		{
			throw new FrameworkException("URL is Blank please provide valid URL");
		}
		if (Url.indexOf("https")!=0)
		{
			throw new FrameworkException("URL does not contains either Http or Https please check the URL");
		}
		driver.navigate().to(Url);
	}
	public void lunchUrl(URL Url) throws MalformedURLException {
		String newUrl= Url.toString();
		if (newUrl==null)
		{
			throw new FrameworkException ("URL is null please provide valid URL");
		}
		if (newUrl=="")
		{
			throw new FrameworkException("URL is Blank please provide valid URL");
		}
		if (newUrl.indexOf("https")!=0)
		{
			throw new FrameworkException("URL does not contains either Http or Https please check the URL");
		}
		driver.navigate().to(Url);
	}
        
	// 3. getPageTitle method
	public String getPageTitle() {
		return driver.getTitle();
	}
	// 4. quitBrowser method
	public void quitBrowser() {
		driver.quit();
	}

	

}
