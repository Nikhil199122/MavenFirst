package com.MavenFirst.com.MavenFirst;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerRegistration 
{
	static WebDriver driver;
	public static void main(String[] args) throws Exception 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
				
		//  Open webpage
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		System.out.println("Page opened.");
							
		// Create WebDriverWait Object        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
							        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		String filePath = "F:\\Nikhil\\Nikhil All Documents\\STAD Solution\\Selenium Assignment\\04-12-2025\\RegistrationData.xlsx";
		
		 Workbook wb = readExcel(filePath);
	     Sheet sheet = wb.getSheet("Sheet1");

	        // Loop all rows except header
	        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

	            Row row = sheet.getRow(i);

	            String fname = getCellValue(row, 0);
	            String lname = getCellValue(row, 1);
	            String email = getCellValue(row, 2);
	            String phone = getCellValue(row, 3);
	            String pass = getCellValue(row, 4);
	            String confirmPass = getCellValue(row, 5);

	            System.out.println("\nRegistering: " + fname + " " + lname);

	            boolean status = registerCustomer(
	                    "https://naveenautomationlabs.com/opencart/index.php?route=account/register",
	                    fname, lname, email, phone, pass, confirmPass
	            );

	            // Write result back into Excel
	            if (status) {
	                setCellValue(row, 6, "PASS");
	                System.out.println("Result: PASS");
	            } else {
	                setCellValue(row, 6, "FAIL");
	                System.out.println("Result: FAIL");
	            }
	        }

	        writeExcel(wb, filePath);
	        
	        // Close browser
	        driver.quit();
	        System.out.println("Test completed successfully!");
	}
	
	public static Workbook readExcel(String path) throws Exception {
        return new XSSFWorkbook(new FileInputStream(path));
    }

    public static void writeExcel(Workbook wb, String path) throws Exception {
        FileOutputStream fos = new FileOutputStream(path);
        wb.write(fos);
        fos.close();
        wb.close();
    }

    public static String getCellValue(Row row, int colIndex) {
        Cell cell = row.getCell(colIndex);
        if (cell == null) return "";
        return cell.toString();
    }

    public static void setCellValue(Row row, int colIndex, String value) {
        Cell cell = row.getCell(colIndex);
        if (cell == null) cell = row.createCell(colIndex);
        cell.setCellValue(value);
    }


    // ============================================
    // GENERIC REGISTRATION METHOD
    // ============================================

    public static boolean registerCustomer(
            String url,
            String first,
            String last,
            String email,
            String phone,
            String pass,
            String confirmPass
    ) {

        try {
            driver.get(url);

            driver.findElement(By.id("input-firstname")).sendKeys(first);
            driver.findElement(By.id("input-lastname")).sendKeys(last);
            driver.findElement(By.id("input-email")).sendKeys(email);
            driver.findElement(By.id("input-telephone")).sendKeys(phone);

            driver.findElement(By.id("input-password")).sendKeys(pass);
            driver.findElement(By.id("input-confirm")).sendKeys(confirmPass);

            // Click privacy policy
            driver.findElement(By.name("agree")).click();

            // Click Continue
            driver.findElement(By.xpath("//input[@value='Continue']")).click();

            // Verify success
            // Registration success page contains: "Your Account Has Been Created!"
            driver.findElement(By.xpath("//h1[contains(text(),'Your Account')]"));

            return true;

        } catch (Exception e) {
            return false;
        }
    }

}
