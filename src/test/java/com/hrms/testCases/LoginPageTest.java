package com.hrms.testCases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hrms.base.Base;
import com.hrms.pageObjects.HomePage;
import com.hrms.pageObjects.LoginPage;



public class LoginPageTest extends Base{
      
	
	
	LoginPage loginpage;
	HomePage homepage;
	
	
	@BeforeMethod(groups="Regression")
	public void setUp() throws IOException
	{
	
	  LogManager.getLogger(LoginPageTest.class.getName());	
	  initialization();
	  loginpage=new LoginPage();
		
	}
	
	@Test(groups="Regression",priority=1)
	public void validateTitleTest()
	{
		   String actualTitle=loginpage.verifyTitle();
	
	       Assert.assertEquals(actualTitle,"OrangeHRM - New Level of HR Management");
		
	}
	
	@Test(groups="Regression",priority=2)
	public void validateLogoTest()
	{
		boolean flag=loginpage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(groups="Regression",priority=3)
	public void validateLoginLogoutTest()
	{
		HomePage homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		homepage.logout();
		
	}
	
	
	@AfterMethod(groups="Regression")
	public void tearDown() {
			
		driver.quit();
	}
}
