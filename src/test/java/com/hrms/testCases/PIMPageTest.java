package com.hrms.testCases;

import com.hrms.base.Base;
import com.hrms.pageObjects.HomePage;
import com.hrms.pageObjects.LoginPage;
import com.hrms.pageObjects.PIMPage;
import com.hrms.utilities.Utility;


import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PIMPageTest extends Base {
	
	
	LoginPage login;
	HomePage homepage;
	private static Logger Log=LogManager.getLogger(PIMPageTest.class.getName());
	
	@BeforeMethod
	public void setUp() throws IOException{
		
		
		initialization();
		login=new LoginPage();
		homepage=login.login("admin","admin");
		Log.info("Driver Initialized");
		
	}
	
	@Test
	public void verifyAddEmployee(){
		
		PIMPage pimPage=homepage.clickPimLink();
		homepage.clickaddEmployeeLink();
		Utility.enterFrame();
		Log.info("Entered Into Frame");
		pimPage.addEmployee("Pritam","Kumar","Singh","pritam");
		Utility.outFromFrame();
		
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		
		homepage.Logout();
		Log.info("Logout Successfully");
		
		driver.close();
	}

}
