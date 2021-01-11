package com.AskuityAutomation.utility;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;


public class utility {
	
	public static void unContionalWait(int sec)
	{
		try
		{
			Thread.sleep(sec*1000);
		}
		
		catch(InterruptedException e)
		{
			Assert.fail("Thread Interrupted");
		}
	}

	public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new 
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(Setup.driver, 60);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }
   
   public static void scrollDown()
   {
	   Actions act= new Actions(Setup.driver);
	   act.sendKeys(Keys.PAGE_DOWN);
	   
   }
   
   public static void clickElement(WebElement element)
   {
	   try{
		   element.click();
		   }
	   
	   catch(Exception ex)
	   {
		   
	   }
   }
   
   public static void moveToElemnet(WebElement ele)
   {
	   Actions act = new Actions(Setup.driver);
	   act.moveToElement(ele).perform();
	 	   
   }
   
   public Object[][] getExcelData(String excelPath, String sheetName) {
		Object arrayExcelData[][] = null;
		try {
			FileInputStream fs = new FileInputStream(excelPath);
			XSSFWorkbook wb = new XSSFWorkbook(fs);
			XSSFSheet sh = wb.getSheet(sheetName);

			int rowCount = sh.getLastRowNum();
			int cellCount = sh.getRow(0).getLastCellNum();

			arrayExcelData = new Object[rowCount][cellCount];

			for (int i = 1; i <= rowCount; i++) {
				XSSFRow row = sh.getRow(i);

				for (int j = 0; j < cellCount; j++) {
					XSSFCell cell = row.getCell(j);
					
					arrayExcelData[i - 1][j] = cell.getStringCellValue();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return arrayExcelData;
   
}
   
   static String Product;
   
   public  String getProduct()
   {
	   return Product;
   }
   
   public void setProduct(String newProduct)
   {
	   this.Product= newProduct;
   }
}