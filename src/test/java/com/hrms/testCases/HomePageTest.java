package com.hrms.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.units.qual.Current;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hrms.base.Base;
import com.hrms.pageObjects.HomePage;
import com.hrms.pageObjects.LoginPage;
import com.hrms.utilities.Utility;

public class HomePageTest extends Base {


	LoginPage loginpage;
	HomePage homepage;
	Logger log;
	@BeforeMethod()

	public void setUp() throws IOException{
		
		
		initialization();
		log=Utility.getLogger(Current.class);
		log.info("Driver Initialized and Entered Url");
		loginpage=new LoginPage();
		
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		
		
	}
	
	@Test
	public void validateTitleTest(){
		
		String actualTitle=homepage.validateTitle();
		Assert.assertEquals(actualTitle, "OrangeHRM");
		
	}
	
	
	
	@AfterMethod()
	public void tearDown()
	{
		driver.quit();
	}
	
}
