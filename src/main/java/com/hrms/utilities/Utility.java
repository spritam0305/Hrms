package com.hrms.utilities;


import org.apache.logging.log4j.*;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.checkerframework.checker.units.qual.Current;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.base.Base;

public class Utility extends Base{
	
	public static String TESTDATA_SHEET_PATH =getBasePath()+"\\src\\main\\java\\com\\hrms\\testData\\hrmsTestData.xlsx";
	public static long PAGE_LOAD_TIMEOUT=30;
	public static long IMPLICIT_WAIT=10;
	static Workbook book;
	static Sheet sheet;
	
	
	public static void Wait(WebElement element,int time){
		
	WebDriverWait wait=new WebDriverWait(driver,time);
		
	wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	
	public static void enterFrame()
	{
		driver.switchTo().frame("rightMenu");
	}
	
	public static Object[][] getData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		//sheet=book.getSheet(sheetName);
	
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				
			}
		}
		return data;
	}
	
	
	public static Logger getLogger(Class<Current> Class){
		
		
		Logger log=LogManager.getLogger(Class.getName());
		
		return log;
		
	} 
	

	
	public static String getBasePath(){
		
		return System.getProperty("user.dir");
	}
	
	public static Actions mouseOver(WebElement element ){
		
		Actions a=new Actions(driver);
		a.moveToElement(element);
		return a;
		
		
	}
	
	public static void outFromFrame(){
		driver.switchTo().defaultContent();
	}
	

}
