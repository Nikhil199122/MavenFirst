package com.MavenFirst.com.MavenFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FrameHandling 
{
	public static void main(String[] args) throws InterruptedException 
	{
		// Step 1: Launch the browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        System.out.println("Chrome browser launched successfully.");
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Step 2: Navigate to the registration form template
        driver.get("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");
        System.out.println("Opened Vehicle Registration Form page.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Step 3: Click the form image
        driver.findElement(By.xpath("//img[@title='Vehicle-Registration-Forms-and-Examples']")).click();
        System.out.println("Clicked on the Vehicle Registration form image.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Step 4: Switch to iframe
        WebElement formFrame = driver.findElement(By.xpath("//iframe[contains(@id, 'frame-one')]"));
        driver.switchTo().frame(formFrame);
        System.out.println("Switched to form iframe.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // ------------------ FORM FILLING SECTION ------------------

        // Proposal Title
        WebElement proposalTitle = driver.findElement(By.id("RESULT_TextField-1"));
        proposalTitle.sendKeys("Automated Proposal Submission");
        System.out.println("Entered Proposal Title.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Location
        WebElement location = driver.findElement(By.xpath("//input[@id=\"RESULT_TextField-3\"]"));
        location.sendKeys("Pune, India");
        System.out.println("Entered Location.");
        Thread.sleep(5000);

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");
        
        // Proposed Date
        WebElement proposedDate = driver.findElement(By.xpath("//input[@id=\"RESULT_TextField-4\"]"));
        proposedDate.sendKeys("2025-10-30");
        System.out.println("Entered Proposed Date.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");
        
        // Description
        WebElement description = driver.findElement(By.xpath("//*[@id=\"RESULT_TextArea-5\"]"));
        description.sendKeys("This is a demo automation proposal created using Selenium WebDriver.");
        System.out.println("Entered Description.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Choose File Upload
        WebElement fileUpload = driver.findElement(By.id("RESULT_FileUpload-6"));
        String filePath = "C:\\Users\\NIKHIL SHAHANE\\OneDrive\\Desktop";
        fileUpload.sendKeys(filePath);
        System.out.println("File uploaded successfully from: " + filePath);
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // First Name
        WebElement firstName = driver.findElement(By.id("RESULT_TextField-8"));
        firstName.sendKeys("Nikhil");
        System.out.println("Entered First Name.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Last Name
        WebElement lastName = driver.findElement(By.id("RESULT_TextField-9"));
        lastName.sendKeys("Shahane");
        System.out.println("Entered Last Name.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Street Address
        WebElement address1 = driver.findElement(By.id("RESULT_TextField-10"));
        address1.sendKeys("123 Main Street");
        System.out.println("Entered Street Address.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Address Line 2
        WebElement address2 = driver.findElement(By.id("RESULT_TextField-11"));
        address2.sendKeys("Near City Mall");
        System.out.println("Entered Address Line 2.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // City
        WebElement city = driver.findElement(By.id("RESULT_TextField-12"));
        city.sendKeys("California");
        System.out.println("Entered City.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // State (Dropdown)
        WebElement stateDropdown = driver.findElement(By.id("RESULT_RadioButton-13"));
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText("California");
        System.out.println("Selected State: California.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Zip Code
        WebElement zip = driver.findElement(By.id("RESULT_TextField-14"));
        zip.sendKeys("411001");
        System.out.println("Entered Zip Code.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Phone Number
        WebElement phone = driver.findElement(By.id("RESULT_TextField-15"));
        phone.sendKeys("9876543210");
        System.out.println("Entered Phone Number.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Email
        WebElement email = driver.findElement(By.id("RESULT_TextField-16"));
        email.sendKeys("nikhil.shahane@test.com");
        System.out.println("Entered Email Address.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Submit Button
        WebElement submitButton = driver.findElement(By.xpath("//input[@id=\"FSsubmit\"]"));
        submitButton.click();
        System.out.println("Clicked on Submit button.");
        Thread.sleep(5000);
        
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(" ");

        // Step 5: Switch back and close browser
        driver.switchTo().defaultContent();
        driver.quit();
        System.out.println("Form filled and submitted successfully. Browser closed.");

	}

}
