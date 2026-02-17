package com.MavenFirst.com.MavenFirst;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelLoginTest 
{
	static WebDriver driver;
	public static void main(String[] args) throws Exception 
	{
		// Launch browser using BrowserUtility
		BrowserUtility brUtil = new BrowserUtility();
		driver = brUtil.launchBrowser("chrome");
		
		//  Open webpage
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		System.out.println("Page opened.");
					
		// Create WebDriverWait Object        
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
					        
		//  Initialize Element Utility
		ElementUtil eu = new ElementUtil(driver);
		
		String path = "F:\\Nikhil\\Nikhil All Documents\\STAD Solution\\Selenium Assignment\\04-12-2025\\loginData.xlsx";

        Workbook wb = readExcel(path);
        Sheet sheet = wb.getSheet("Sheet1");

        // Loop all rows except header (row 0)
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            Row row = sheet.getRow(i);

            String username = getCellValue(row, 0);
            String password = getCellValue(row, 1);

            System.out.println("\nTrying login: " + username + " | " + password);

            boolean status = loginToApp(
                    "https://naveenautomationlabs.com/opencart/index.php?route=account/login",
                    username,
                    password
            );

            if (status) {
                setCellValue(row, 2, "PASS");
                System.out.println("Result: PASS");
            } else {
                setCellValue(row, 2, "FAIL");
                System.out.println("Result: FAIL");
            }
        }

        writeExcel(wb, path);
        
        // Close browser
        driver.quit();
        System.out.println("Test completed successfully!");

	}
	
//----------------------------------------------------
//           GENERIC METHOD → READ EXCEL
// ----------------------------------------------------
public static Workbook readExcel(String path) throws Exception {
    return new XSSFWorkbook(new FileInputStream(path));
}

// ----------------------------------------------------
//           GENERIC METHOD → WRITE EXCEL
// ----------------------------------------------------
public static void writeExcel(Workbook wb, String path) throws Exception {
    FileOutputStream fos = new FileOutputStream(path);
    wb.write(fos);
    fos.close();
    wb.close();
}

// ----------------------------------------------------
//           GENERIC METHOD → GET CELL VALUE
// ----------------------------------------------------
public static String getCellValue(Row row, int colIndex) {
    Cell cell = row.getCell(colIndex);
    if (cell == null) return "";
    return cell.toString();
}

// ----------------------------------------------------
//           GENERIC METHOD → SET CELL VALUE
// ----------------------------------------------------
public static void setCellValue(Row row, int colIndex, String value) {
    Cell cell = row.getCell(colIndex);
    if (cell == null) {
        cell = row.createCell(colIndex);
    }
    cell.setCellValue(value);
}

// ----------------------------------------------------
//            GENERIC METHOD → LOGIN TO APP
// ----------------------------------------------------
public static boolean loginToApp(String url, String user, String pass) {

    driver.get(url);

    try {
        driver.findElement(By.id("input-email")).clear();
        driver.findElement(By.id("input-email")).sendKeys(user);

        driver.findElement(By.id("input-password")).clear();
        driver.findElement(By.id("input-password")).sendKeys(pass);

        driver.findElement(By.xpath("//input[@value='Login']")).click();

        // verification step
        // Logout link appears only when login is successful
        driver.findElement(By.linkText("Logout"));

        return true;

    } catch (Exception e) 
    {
        return false;
    }
  }
}
